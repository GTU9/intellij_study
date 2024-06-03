package com.ohgiraffers.jwtsecurity.user.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test GET";
    }

    @PostMapping("/test")
    public String test2(){
        return "test POST";
    }
}
