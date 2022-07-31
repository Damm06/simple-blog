package com.miniproject.controller;

import com.miniproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RequiredArgsConstructor
@Controller
public class PostController {

    private final PostService postService;

    @GetMapping({"", "/"})
    public String index(Model model) {
        model.addAttribute("posts", postService.findAll());
        return "index";
    }

    //글 저장
    @GetMapping("/post/save")
    public String savePost() {
        return "layout/post/post-save";
    }

    @GetMapping("/post/update/{id}")
    public String update(@PathVariable("id") long postId, Model model) {
        model.addAttribute("post", postService.detail(postId));
        return "layout/post/post-update";
    }

    @GetMapping("/post/{id}")
    public String detail(@PathVariable("id") long postId, Model model) {
        model.addAttribute("post", postService.detail(postId));
        return "layout/post/post-detail";
    }
}
