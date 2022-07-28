package com.miniproject.dto;

import com.miniproject.blog.model.RoleType;
import com.miniproject.blog.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor
public class UserSaveRequestDto {
    private String username;
    private String password;
    private String email;
    private RoleType role;

    public User toEntity() {
        return User.builder()
                .username(username)
                .password(password)
                .email(email)
                .role(RoleType.USER)
                .build();
    }
}
