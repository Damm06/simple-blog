package com.miniproject.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
//@Configuration //빈등록(IoC 관리)
//@EnableWebSecurity //시큐리티 필터 추가
//@EnableGlobalMethodSecurity(prePostEnabled = true) //특정 주소 접근 시 권한 및 인증을 미리 체크한다는 의미
public class SecurityConfig {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .authorizeRequests()
//                .antMatchers("/auth/**")
//                .permitAll()
//                .anyRequest()
//                .authenticated();
//    }
}