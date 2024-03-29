package com.ohgiraffers.section03.math;

import java.util.Random;

public class Application3 {
    public static void main(String[] args) {
        /*java.untill.Random 클래스를 활용하여 사용자 지정 버위의 난수를 발생시킬 수 있다.*/
        /*java.untill.Random 클래스
        * java.untill.Random 클래스의 nextInt() 메소드를 이용한 난수 발생
        * nextInt(int bound) : 0부터 매개변수로 전달받은 정수 범위까지의 난수를 발생시켜서 정수 형태로 변환*/

        /*원하는 범위의 난수를 구하는 공식*/
        /*random.nextInt(구하려는 난수의 개수)+ 구하려는 난수의 최소값
        * */

        Random random= new Random();

        /*1. 0부터 9까지의 난수 발생*/
        int randomNumber1= random.nextInt(10);
        System.out.println("0부터 9까지의 난수 : "+ randomNumber1);

        /*1. 1부터 10까지의 난수 발생*/
        int randomNumber2= random.nextInt(10)+1;
        System.out.println("1부터 10까지의 난수 : "+ randomNumber2);

        /*1. 20부터 45까지의 난수 발생*/
        int randomNumber3= random.nextInt(26)+20;
        System.out.println("20부터 45까지의 난수 : "+ randomNumber3);

        /*1. -128부터 127까지의 난수 발생*/
        int randomNumber4= random.nextInt(256) -128;
        System.out.println("-128부터 127까지의 난수 : "+ randomNumber4);


    }
}