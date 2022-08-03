package com.miniproject.blog.model;

import com.miniproject.audit.Auditable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity  //DB 매핑을 알려주는 어노테이션은 제일 아래에(가까이) 있는 게 좋음
public class User extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 30, unique = true)
    private String username;

    @Column(nullable = false, length = 100) //비밀번호 암호화하면 길어지니까 넉넉히 지정
    private String password;

//    @Column(nullable = false, length = 30)
//    private String phone;

    @Column(nullable = false, length = 50)
    private String email;

//    @CreatedDate
//    @Column(name = "CREATED_AT", updatable = false)
//    private LocalDateTime createdAt;

//    @CreationTimestamp  //이렇게 바꾸면 테이블에 날짜 뜸
//    @Column(name = "CREATED_AT", updatable = false)
//    private Timestamp createdAt;

//    @LastModifiedDate
//    @Column(name = "LAST_MODIFIED_AT")
//    private LocalDateTime modifiedAt;

    @Enumerated(EnumType.STRING)
    private RoleType role; //enum으로 도메인을 지정해서 오류 입력를 방지

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }

    public void update(String password) {
        this.password = password;
    }
}
