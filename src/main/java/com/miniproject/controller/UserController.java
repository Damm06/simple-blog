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

    @GetMapping("/home")
    public String index() {
        return "index";
    }
}
