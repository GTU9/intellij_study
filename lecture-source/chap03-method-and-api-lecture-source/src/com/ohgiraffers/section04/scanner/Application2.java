package com.ohgiraffers.section04.scanner;

import java.util.Scanner;

public class Application2 {
    public static void main(String[] args) {
        /*Scanner의 nextLine()과 next()에 대헤 구분하여 사용할 수 있다.*/
        /*nextLine() : 공백을 포함한 한 줄을 입력을 위한 개행문자 전까지 읽어서 문자열로 반환한다.(공백문자 포함)
        * next() : 공백문자 개행문자 전까지 읽어서 문자열로 반환한다. (공백문자 미포함)
        * */

        /*1. Scanner 객체 생성*/
        Scanner sc =new Scanner(System.in);

        /*2. 문자열 입력*/
        /*2-1. nextLine()*/
        System.out.print("인사말을 입력해주세요 : ");
        String greetiong1=sc.nextLine();

        System.out.println(greetiong1);

        /*2-2. next()*/
        System.out.print("인사말을 입력해주세요 : ");
        String greetiong2=sc.next();

        System.out.println(greetiong2);
    }
}
