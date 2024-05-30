package com.ohgiraffers.sessionsecurity.auth.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Configuration
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public void login() {

    }

    @GetMapping("/fail")
    public ModelAndView loginFail(ModelAndView mv, @RequestParam String message) {
        mv.addObject("message", message);
        return mv;
    }
}
