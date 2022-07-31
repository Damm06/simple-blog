package com.miniproject.controller.api;

import com.miniproject.blog.config.auth.PrincipalDetail;
import com.miniproject.blog.model.Post;
import com.miniproject.blog.model.User;
import com.miniproject.dto.PostSaveRequestDto;
import com.miniproject.dto.PostUpdateRequestDto;
import com.miniproject.dto.ResponseDto;
import com.miniproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostApiController {

//    @Autowired
    private final PostService postService;

    //글 작성 API
    @PostMapping("/api/v1/post")
    public Long save(@RequestBody PostSaveRequestDto postSaveRequestDto, @AuthenticationPrincipal PrincipalDetail principalDetail) {
        return postService.save(postSaveRequestDto, principalDetail.getUser());
    }

    //글 수정 API
    @PutMapping("/api/v1/post/{id}")
    public Long update(@PathVariable("id") long postId, @RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.update(postId, new PostUpdateRequestDto());
    }

    //글 삭제 API
    @DeleteMapping("/api/v1/post/{id}")
    public Long deleteById(@PathVariable("id") long postId) {
        postService.deleteById(postId);
        return postId;
    }
}

//    public ResponseDto<Long> save(@RequestBody Post post) {
//        System.out.println("UserApiController: save 호출됨");
//        return new ResponseDto<Long>(HttpStatus.OK,1L);}