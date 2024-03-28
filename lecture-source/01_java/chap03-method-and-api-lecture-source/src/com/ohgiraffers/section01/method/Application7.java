package com.ohgiraffers.section01.method;

public class Application7 {
    public static void main(String[] args) {
        /*매개변수와 리턴값을 복합적으로 활용하는 것을 이해하고 활용할 수 있다*/
        /*매개변수와 리턴값 복합 활용
        * 매개변수도 존재하고 리턴값도 존재하는 메소드를 이용하여 간단한 계산기 만들기
        * */

        int first=20;
        int second=10;

        Application7 app7= new Application7();
        System.out.println(app7.plusTwoNumber(first,second));
        System.out.println(app7.minusTwoNumber(first,second));
        System.out.println(app7.multipleTwoNumber(first,second));
        System.out.println(app7.divideTwoNumber(first,second));

    }

    public int plusTwoNumber(int first, int second){
     return first+second;
    }
    public int minusTwoNumber(int first, int second){
        return first-second;
    }
    public int multipleTwoNumber(int first, int second){
        return first*second;
    }
    public int divideTwoNumber(int first, int second){
        return first/second;
    }
}
