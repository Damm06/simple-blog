package com.miniproject.blog.model;

import lombok.Getter;

@Getter
public enum RoleType {
    ADMIN("관리자"), MEMBER("일반사용자");

    private String description;
    RoleType(String description) {
        this.description = description;
    }
}
