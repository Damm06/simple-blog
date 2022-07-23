package com.miniproject.model;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity  //DB 매핑을 알려주는 어노테이션은 제일 아래에(가까이) 있는 게 좋음
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;

    @Column(nullable = false, length = 30)
    private String username;

    @Column(nullable = false, length = 100) //비밀번호 암호화하면 길어지니까 넉넉히 지정
    private String password;

    @Column(nullable = false, length = 30)
    private String phone;

    @Column(nullable = false, length = 50)
    private String email;

    @CreatedDate
    @Column(name = "CREATED_AT", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "LAST_MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    private UserRole user_role; //추후 변경 예정 enum으로 도메인을 지정해서 오류 입력를 방지

    @Getter
    public enum UserRole {
        ROLE_ADMIN("관리자"), ROLE_MEMBER("일반사용자");

        private String description;
        UserRole(String description) {
            this.description = description;
        }

    }
}
