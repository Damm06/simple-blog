package com.miniproject.service;

import com.miniproject.blog.model.Post;
import com.miniproject.blog.model.User;
import com.miniproject.blog.repository.PostRepository;
import com.miniproject.dto.PostSaveRequestDto;
import com.miniproject.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto, User user) {
        postSaveRequestDto.setUser(user);
        return postRepository.save(postSaveRequestDto.toEntity()).getPostId();
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    @Transactional(readOnly = true)
    public Post detail(long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id=" + postId));
    }

    @Transactional
    public Long update(Long postId, PostUpdateRequestDto postUpdateRequestDto) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 id가 없습니다. id= " + postId));
        post.update(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        return postId;
    }

    @Transactional
    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }
}


//@Transactional
//    public void write(Post post, User user) {
//        post.setCount(0);
//        post.setUser(user);
//        postRepository.save(post);
//    }