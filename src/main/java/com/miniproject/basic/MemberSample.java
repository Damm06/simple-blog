package com.miniproject.basic;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberSample {
    //변수에 직접 접근해서 값을 수정하면 안되니까 private 로 설정함
    //객체 지향에서는 변수를 private 로 하고 메서드를 public 으로 만들고 Getter, Setter 를 만듦.
    private int id;
    private String userName;
    private String password;
    private String email;

}
