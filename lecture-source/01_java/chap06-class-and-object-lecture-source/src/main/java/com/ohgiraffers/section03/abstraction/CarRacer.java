package com.ohgiraffers.section03.abstraction;

public class CarRacer {

    private final Car car =new Car();

    public void startUp(){
        car.statUp();
    }
    public void stepAccelater(){
        car.go();
    }
    public void stepBreak(){
        car.stop();
    }
    public void turn0ff(){
        car.turnOff();
    }
}
