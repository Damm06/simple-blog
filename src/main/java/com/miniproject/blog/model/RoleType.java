package com.miniproject.blog.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoleType {
    ADMIN("ROLE_ADMIN","관리자"),
    USER("ROLE_USER","사용자");

//    ROLE_ADMIN("관리자"),
//    ROLE_MEMBER("사용자");
//    private String description;
//    RoleType(String description) {
//        this.description = description;
//    }

    private final String key;
    private final String title;
}
