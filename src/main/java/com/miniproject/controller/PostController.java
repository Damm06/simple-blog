package com.miniproject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {

    @GetMapping({"", "/"})
    public String index() {
        return "index";
    }

    @GetMapping("/post/saveForm")
    public String saveForm() {
        return "post/saveForm";
    }
}
