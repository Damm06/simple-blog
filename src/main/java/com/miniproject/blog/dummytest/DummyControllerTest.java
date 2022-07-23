package com.miniproject.blog.dummytest;

import com.miniproject.blog.model.RoleType;
import com.miniproject.blog.model.User;
import com.miniproject.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.function.Supplier;

@RestController
public class DummyControllerTest {

    @Autowired
    private UserRepository userRepository;

    @DeleteMapping("/dummy/user/{userId}")
    public String deleteUser(@PathVariable("userId") int userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            return "삭제에 실패하였습니다. 해당 id는 DB에 없습니다.";
        }
        return "삭제되었습니다. id: " + userId;
    }


    //save 함수는 id를 전달해주지 않으면 insert를 해준다.
    //save 함수는 id를 전달하면 해당 id에 대한 데이터가 있으면 update를 해주고,
    //save 함수는 id를 전달하면 래당 id에 대한 데이터가 없으면 insert를 한다.

    @Transactional //함수 종료 시 자동 커밋 됨.
    @PutMapping("/dummy/user/{id}")
    public User updateUser(@PathVariable("id") int userId, @RequestBody User requestUser) {
        System.out.println("id : " + userId);
        System.out.println("password : " + requestUser.getPassword());
        System.out.println("email : " + requestUser.getEmail());

        User user = userRepository.findById(userId).orElseThrow(() -> {
            return new IllegalArgumentException("수정에 실패하였습니다.");
        });  //이 때 영속화됨
        user.setPassword(requestUser.getPassword());
        user.setEmail(requestUser.getEmail());  //여기서 변경이 있으니까 변경을 체크하고 DB에 수정을 날려줌 -> 더티체킹

        //userRepository.save(user); //save 하지 않고 Transactional 사용해서 더티체킹으로 업데이트 함.
        return user;
    }


    @GetMapping("/dummy/users")
    public List<User> userList() {
        return userRepository.findAll();
    }

    @GetMapping("/dummy/pagingUser")
    public List<User> pageList(@PageableDefault(size = 2, sort = "userId",
    direction = Sort.Direction.DESC)Pageable pageable) {  //id 순서 거꾸로 호출
        Page<User> pagingUsers = userRepository.findAll(pageable);
        List<User> users = pagingUsers.getContent();
        return users;
    }


    @GetMapping("/dummy/user/{id}")
    public User detail(@PathVariable("id") int userId) {
        User user = userRepository.findById(userId).orElseThrow(() -> {
                    return new IllegalArgumentException("해당 사용자는 없습니다.");
                });
        return user;
    }

    @PostMapping("/dummy/join")
    public String join(User user) {
        System.out.println("userId : " + user.getUserId());
        System.out.println("userName : " + user.getUsername());
        System.out.println("password : " + user.getPassword());
        System.out.println("email : " + user.getEmail());
        System.out.println("phone : " + user.getPhone());
        System.out.println("role : " + user.getRole());
        System.out.println("createdAt : " + user.getCreatedAt());

        user.setRole(RoleType.MEMBER);
        userRepository.save(user);
        return "회원가입이 완료되었습니다.";
    }
}
