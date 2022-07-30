package com.miniproject.controller.api;

import com.miniproject.blog.model.Post;
import com.miniproject.blog.model.User;
import com.miniproject.dto.ResponseDto;
import com.miniproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostApiController {

    @Autowired
    private PostService postService;

    //스프링 시큐리티로 로그인 먼저 구현해야 할 듯
    @PostMapping("/api/post")
    public ResponseDto<Long> save(@RequestBody Post post) {
        System.out.println("UserApiController: save 호출됨");
        return new ResponseDto<Long>(HttpStatus.OK,1L);
    }
}
