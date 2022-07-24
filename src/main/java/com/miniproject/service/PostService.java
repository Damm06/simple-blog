package com.miniproject.service;

import com.miniproject.blog.model.Post;
import com.miniproject.blog.model.User;
import com.miniproject.blog.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;

    @Transactional
    public void write(Post post, User user) {
        post.setCount(0);
        post.setUser(user);
        postRepository.save(post);
    }
}
