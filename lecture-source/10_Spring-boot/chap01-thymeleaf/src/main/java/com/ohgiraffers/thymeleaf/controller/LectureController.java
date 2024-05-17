package com.ohgiraffers.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("lecture")
public class LectureController  {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){

        mv.setViewName("/lecture/expression");

        return mv;
    }
}
