package com.ohgiraffers.jwtsecurity.user.controller;

import com.ohgiraffers.jwtsecurity.user.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @PostMapping("/signup")
    public String signup(@RequestBody User user) {
        return null;
    }
}
