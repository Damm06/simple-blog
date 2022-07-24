package com.miniproject.blog.repository;

import com.miniproject.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    //Jpa Naming 쿼리임. 알아서 아래와 같이 번역?해줌
    // SELECT * FROM user WHERE username = ? AND password = ?;
    User findByUsernameAndPassword(String username, String password);

//    //이 방법으로 쓸 수도 있음
//    @Query(value = "SELECT * FROM user WHERE username = ?1 AND password = ?2", nativeQuery = true)
//    User login(String username, String password);
}
