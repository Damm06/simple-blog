package com.miniproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

    //인증이 안 된 사용자들이 출입할 수 있는 경로를 /auth/** 로 해서 허용
    //그냥 주소가 / 이면 index.html 허용
    //static 이하에 있는 리소스 파일들 (js,css,images 등) 것들도 허용

    @GetMapping("/auth/joinForm")
    public String joinForm() {
        return "joinForm";
    }

//    @GetMapping("/home")
//    public String index() {
//        return "index";
//    }

    //회원가입 페이지
    @GetMapping("/auth/user/save")
    public String userSave() {
        return "layout/user/user-save";
    }

    //로그인 페이지
    @GetMapping("/auth/user/login")
    public String userLogin() {
        return "layout/user/user-login";
    }

    //회원정보 수정 페이지
    @GetMapping("/user/update")
    public String userUpdate() {
        return "layout/user/user-update";
    }

}
