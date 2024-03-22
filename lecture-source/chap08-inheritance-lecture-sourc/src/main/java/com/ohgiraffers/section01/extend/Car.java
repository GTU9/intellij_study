package com.ohgiraffers.section01.extend;

public class Car {

    private boolean runningStaus;
    public void run(){
        runningStaus=true;

        System.out.println("자동차가 달립니다.");
    }

    public void soundHorn(){
        if(isRunning()){
            System.out.println("빵!빵!");
        }else {
            System.out.println("주행중이 아닌 상태에서는 경적을 울릴 수 없습니다.");
        }
    }

    protected boolean isRunning(){
        return runningStaus;
    }

    public void stop(){
        runningStaus=false;
        System.out.println("자동차가 멈춥니다.");
    }
}
