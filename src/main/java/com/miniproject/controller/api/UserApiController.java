package com.miniproject.controller.api;

import com.miniproject.blog.config.auth.PrincipalDetail;
import com.miniproject.blog.model.RoleType;
import com.miniproject.blog.model.User;
import com.miniproject.dto.ResponseDto;
import com.miniproject.dto.UserSaveRequestDto;
import com.miniproject.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@RestController
public class UserApiController {

   //@Autowired
    private final UserService userService;

    @PostMapping("/auth/api/v1/user")
    public Long save(@RequestBody UserSaveRequestDto userSaveRequestDto) {
        return userService.saveUser(userSaveRequestDto.toEntity());
    }

    @PutMapping("/api/v1/user")
    public Long update(@RequestBody User user, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        userService.updateUser(user, principalDetail);
        return user.getUserId();
    }


//    @PostMapping("auth/joinForm")
//    public ResponseDto<Integer> save(@RequestBody User user) {
//        System.out.println("UserApiController: save 호출됨");
//        user.setRole(RoleType.ROLE_USER);
//        userService.joinMember(user);
//        return new ResponseDto<Integer>(HttpStatus.OK, 1);
//    }
//


}
