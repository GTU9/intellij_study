package com.ohgiraffers.practice.array;

import java.util.Scanner;

public class Application4 {

    public static void main(String[] args) {

        /* 주민등록번호를 스캐너로 입력 받고 문자 배열로 저장한 뒤,
         * 성별 자리 이후부터 *로 가려서 출력하세요.
         *
         * -- 입력 예시 --
         * 주민등록번호를 입력하세요 : 990101-1234567
         *
         * -- 출력 예시 --
         * 990101-1******
         */
        Scanner sc= new Scanner(System.in);
        System.out.print("주민등록번호를 입력하세요(-없이 입력) : ");
        String str=sc.nextLine();
        char[] ch=new char[13];
        for(int i=0;i<ch.length;i++){
            ch[i]=str.charAt(i);
            if(i>6){
                ch[i]='*';
            }
            System.out.print(ch[i]);
            if(i==5){
                System.out.print("-");
            }
        }
    }

}
