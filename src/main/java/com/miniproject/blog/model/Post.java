package com.miniproject.blog.model;

import com.miniproject.audit.Auditable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity //DB 매핑을 알려주는 어노테이션은 제일 아래에(가까이) 있는 게 좋음
public class Post extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false)
    @Lob  //대용량 데이터
    private String content;  //섬머노트 라이브러리 <HTML> 태그가 섞여서 디자인 됨


    private int count; //글 조회수

    //작성자 정보 매핑
    @ManyToOne //한 post는 한 명의 유저를 가짐. Many = post, One = user
    @JoinColumn(name = "userId")
    private User user; //db는 오브젝트 저장 못함. FK, 자바는 오브젝트 저장 가능.

    @OneToMany(mappedBy = "post", fetch = FetchType.EAGER) //연관관계의 주인이 reply가 아니라는 뜻. FK가 아니니까 DB 칼럼 만들지 말란 의미.
    private List<Reply> replyList;

//    @CreatedDate
//    @Column(name = "CREATED_AT", updatable = false)
//    private LocalDateTime createdAt;
//
//    @LastModifiedDate
//    @Column(name = "LAST_MODIFIED_AT")
//    private LocalDateTime modifiedAt;
}
