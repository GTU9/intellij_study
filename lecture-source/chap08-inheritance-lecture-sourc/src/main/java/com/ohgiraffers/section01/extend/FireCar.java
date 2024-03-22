package com.ohgiraffers.section01.extend;

public class FireCar extends Car {
    /*1. extends 키워드를 이용하여 Car 클래스 상속*/
    /*Car 클래스를 부모클래스로 FireCar를 자식클래스로 사용할 것이다.
    * 클래스 선언부에 extends Car를 추가해서  Car클래스를 상속 받을 것이다.
    * 하지만 생성자는 상속받지 못한다.
    * 또한 부모가 가지고 있는 private 멈버는 접근이 불가능하다.
    * */

    /*기본 생성자*/
    public FireCar(){}

    @Override
    public void soundHorn(){
        if(isRunning()){
            /*주행중 상태인 것을 확인해야한다.
            * runningStaus*/
            System.out.println("빠아아아아앙~~~~~~~~빠아아아아아앙");
        }else {
            System.out.println("소방차가 앞으로 갈 수 없습니다~ 비키세요 비켜~~");
        }
    }

    /*물 뿌리는 기능 추가*/
    public void sprayWater(){
        System.out.println("불난 곳을 발견했습니다. 물을 뿌립니다.=======================>>");
    }
}
