package com.miniproject.dto;

import com.miniproject.blog.model.Post;
import com.miniproject.blog.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PostSaveRequestDto {

    private String title;
    private String content;
    private int count;
    private User user;

    public Post toEntity() {
        return Post.builder()
                .title(title)
                .content(content)
                .count(0)
                .user(user)
                .build();
    }

    public void setUser(User user) {
        this.user = user;
    }
}
