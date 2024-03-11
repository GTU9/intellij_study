package com.ohgiraffers.section05.logical_operator;

public class Application2 {
    public static void main(String[] args) {
        /*논리 연산자의 우선순위와 활용*/
        /*논리 and 연산자와 or 연산자의 우선순위
        * && : 11순위
        * || : 12순위
        * 논리 and 연산자 우선순위가 논리 or 연산자 우선순위보다 높다.*/

        int x=3;
        int y=10;

        System.out.println(y>=5||x<0&&x>2);

        /*1. 1부터 100사이의 값인지 확인*/
        /*1<= 변수 <= 이렇게는 사용못함 -->변수 >=1 && 변수 <=100 이렇게 사용해야 한다.*/
        int num1 =55;
        System.out.println("1부터 100사이인지 확인 : "+ (num1>=1&&num1<=100));

        int num2 =166;
        System.out.println("1부터 100사이인지 확인 : "+ (num1>=1&&num2<=100));

        /*2. 영어 대문자인지 확인*/
        char ch1 ='G';
        System.out.println("영어 대문자인지 확인 : "+(ch1>='A'&&ch1<='Z'));

        char ch2='g';
        System.out.println("영어 대문자인지 확인 : "+(ch1>='A'&&ch2<='Z'));

        /*3. 대소문자 상관 없이 영문자 y인지 확인*/
        /*문자 변수 =='y' || 문자변수== 'Y'*/
        char ch3 ='Y';
        System.out.println("영문자 y인지 확인 : "+(ch3=='y'||ch3=='Y'));

        char ch4 ='y';
        System.out.println("영문자 y인지 확인 : "+(ch3=='y'||ch4=='Y'));
    }
}
