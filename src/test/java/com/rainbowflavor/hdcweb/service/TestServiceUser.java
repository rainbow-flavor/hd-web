package com.rainbowflavor.hdcweb.service;

import com.rainbowflavor.hdcweb.domain.User;
import com.rainbowflavor.hdcweb.repository.JpaRoleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class TestServiceUser {

    @Autowired
    UserService userService;
    @Autowired JpaRoleRepository jpaRoleRepository;
    @Autowired JpaRoleRepository roleRepository;

    @Test
    @DisplayName("User and Role Insert")
    void join() {
        User user = User.builder()
                .address("seoul")
                .email("irostub@gmail.com")
                .position("top")
                .name("stub")
                .phone("010-0000-0000")
                .birth(new Date())
                .password("qw1234")
                .build();

        userService.joinUser(user);

    }
}