package com.miniproject.service;

import com.miniproject.blog.config.auth.PrincipalDetail;
import com.miniproject.blog.model.RoleType;
import com.miniproject.blog.model.User;
import com.miniproject.blog.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    //@Autowired
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public Long saveUser(User user) {
        String hashPw = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(hashPw);
        user.setRole(RoleType.USER);
        return userRepository.save(user).getUserId();
    }

    @Transactional
    public Long updateUser(User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        User userEntity = userRepository.findById(user.getUserId()).orElseThrow(() -> new IllegalArgumentException("해당 회원이 없습니다 id= " + user.getUserId()));
        userEntity.update(bCryptPasswordEncoder.encode(user.getPassword()));
        principalDetail.setUser(userEntity);
        return userEntity.getUserId();
    }


//    @Transactional
//    public void joinMember(User user) {
//        userRepository.save(user);
//    }

//    @Transactional(readOnly = true)
//    public User login(User user) {
//       return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }

}
