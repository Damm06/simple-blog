package com.miniproject.controller.api;

import com.miniproject.blog.model.RoleType;
import com.miniproject.blog.model.User;
import com.miniproject.dto.ResponseDto;
import com.miniproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserApiController {

    @Autowired
    private UserService userService;

    @Autowired
    private HttpSession session;

    @PostMapping("/api/user")
    public ResponseDto<Integer> save(@RequestBody User user) {
        System.out.println("UserApiController: save 호출됨");
        user.setRole(RoleType.MEMBER);
        userService.joinMember(user);
        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }

    //스프링 시큐리티 사용 안 한 전통 로그인 방법 -> 수정 예정
    @PostMapping("/api/user/login")
    public ResponseDto<Integer> login(@RequestBody User user) {
        System.out.println("");
        User principal = userService.login(user);

        if(principal != null) {
            session.setAttribute("principal", principal);
        }

        return new ResponseDto<Integer>(HttpStatus.OK, 1);
    }
}
