package com.ohgiraffers.section01.extend;

public class RacingCar extends Car{

    /*1. extends 키워드를 이용하여 Car 클래스 상속 */

    /*기본생성자*/
    public RacingCar(){
        System.out.println("RacingCar 클래스 생성자 호출됨...");
    }

    /*2. run() 오버라이딩*/
    @Override
    public void run(){
        System.out.println("레이싱카 전속력으로 질주합니다!!!!!!!!!!");

    }

    /*3. soundHorn(), stop() 오버라이딩*/
    @Override
    public void soundHorn() {
        System.out.println("레이싱 카는 경적을 울리지 않습니다. (조용...)");
    }

    public void stop(){
        System.out.println("레이싱카가 멈춥니다.");
    }
}
