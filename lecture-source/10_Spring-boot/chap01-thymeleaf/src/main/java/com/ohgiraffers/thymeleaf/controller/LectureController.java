package com.ohgiraffers.thymeleaf.controller;

import com.ohgiraffers.thymeleaf.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("lecture")
public class LectureController  {

    @GetMapping("expression")
    public ModelAndView expression(ModelAndView mv){

        mv.addObject("member", new MemberDTO("토끼",20,'무',"서울시 노원구"));

        mv.addObject("hello", "hello <h3>Thymeleaf</h3>");

        mv.setViewName("/lecture/expression");

        return mv;
    }

    @GetMapping("conditional")
    public ModelAndView conditional(ModelAndView mv){

        mv.addObject("num", 216);
        mv.addObject("str", "바나나");

        List<MemberDTO> memberList=new ArrayList<>();

        mv.setViewName("/lecture/conditional");

        return mv;
    }
}
