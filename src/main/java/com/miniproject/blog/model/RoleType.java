package com.miniproject.blog.model;

import lombok.Getter;

@Getter
public enum RoleType {
    ROLE_ADMIN("관리자"), ROLE_MEMBER("일반사용자");

    private String description;
    RoleType(String description) {
        this.description = description;
    }
}
