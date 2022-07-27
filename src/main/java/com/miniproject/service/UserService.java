package com.miniproject.service;

import com.miniproject.blog.model.User;
import com.miniproject.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void joinMember(User user) {
        userRepository.save(user);
    }

//    @Transactional(readOnly = true)
//    public User login(User user) {
//       return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
//    }

}
