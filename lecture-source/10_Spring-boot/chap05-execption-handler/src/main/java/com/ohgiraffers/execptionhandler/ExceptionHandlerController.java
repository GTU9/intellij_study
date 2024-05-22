package com.ohgiraffers.execptionhandler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExceptionHandlerController {

    @GetMapping("controller-null")
    public String nullPointerExceptionTest(){

        String str=null;
        System.out.println(str.charAt(0));

        return "/";

    }

    @GetMapping("controller-user")
    public String userExceptionTest() throws MemberRegistException {

        boolean check=true;

        if(check) {

            throw new MemberRegistException("당신은 회원 자격이 없습니다.");
        }
        return "/r";
    }
}
