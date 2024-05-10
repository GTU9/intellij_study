package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account accountGenerator(){
        return new PersonalAccount(20, "110-1234-567890");
    }

    @Bean
    public MemberDTO memberGenerator(){
        return new MemberDTO(1, "토끼", "010-1234-5678", "rabbit@gmail.com", accountGenerator());
    }
}
