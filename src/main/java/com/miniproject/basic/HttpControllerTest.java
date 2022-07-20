package com.miniproject.basic;

import org.springframework.web.bind.annotation.*;

@RestController
public class HttpControllerTest {

    //http://localhost:8080/http/get (select)
    @GetMapping("/http/get")  //get의 데이터 요청 방식은 쿼리 스트림 밖에 없음
    public String getTest(MemberSample m) { //위의 주소에 추가할 수 있음 ?id=1&username=ssar&password=123&email=ssar@naver.com
        return "get 요청 :" + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/post (insert)
    @PostMapping("/http/post")
    public String postTest(@RequestBody MemberSample m) { //MessageConverter 라는 스프링부트의 클래스가 자동으로 변환해줌. JSON으로 입력하면 객체 그대로 반환함.
        return "post 요청 :" + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody MemberSample m) {
        return "put 요청 :" + m.getId() + ", " + m.getUserName() + ", " + m.getPassword() + ", " + m.getEmail();
    }

    //http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest() {
        return "delete 요청";
    }
}
