package com.miniproject.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class UserController {

//    @GetMapping("/auth/joinForm")
//    public String joinForm() {
//        return "joinForm";
//    }

//    @GetMapping("/home")
//    public String index() {
//        return "index";
//    }

    @GetMapping("/auth/user/save")
    public String userSave() {
        return "layout/user/user-save";
    }

    @GetMapping("/auth/user/login")
    public String userLogin() {
        return "layout/user/user-login";
    }
}
