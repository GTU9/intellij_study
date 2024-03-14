package com.ohgiraffers.section02.looping;

public class C_doWhile {
    public void testSimpleDoWhileStatement(){
        /*do while문 단독 사용에 대한 흐름을 이해하고 적용할 수 있다.*/
        /*[do-while문 표현식]
        * 초기식;
        * do{
        *   1회차에서 무조건 실행하고, 이후에는 조건식을 확인하여 조건을 만족하는 경우 반복구문 실행
        *   증감식;
        * }while(조건식)
        * */

        /*조건을 false로 두고 실행 되는지 테스트*/
        do{
            /*조건식의 결과와 상관 없이 최초 1번은 무조건 동작함*/
            System.out.println("최초 한 번 동작함...");
        }while(false);

        System.out.println("반복문 종료 확인...");
    }
}
