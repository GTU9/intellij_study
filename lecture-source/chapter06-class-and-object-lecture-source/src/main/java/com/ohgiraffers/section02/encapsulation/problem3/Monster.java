package com.ohgiraffers.section02.encapsulation.problem3;

public class Monster {

    /*1. name과 hp필드를 선언하여 Monster 클래스를 만든다.*/
//    String name;
//    int hp;
//
//    public void  setInfo(String name){
//        this.name=name;
//    }
//    public void setHp(int hp){
//        if(hp>0){
//            this.hp=hp;
//        }else{
//            this.hp=0;
//        }
//    }
//
//    public String getInfo(){
//        return "몬스터 이름은 "+this.name+"이고, 체력은 "+this.hp+"입니다.";
//    }

    /*---------------------------------------*/
    /*2. name 필드를 kinds로 변경한다.*/
    /*몬스터 정보를 저장할 필드 작성*/

    String kinds;
    int hp;

    public void setInfo(String Info){
        this.kinds=Info;
    }

    public void setHp(int hp) {
        if (hp > 0) {
            this.hp = hp;
        } else {
            this.hp = 0;
        }
    }
    public String getInfo(){
        return "몬스터 이름은 "+this.kinds+"이고, 체력은 "+this.hp+"입니다.";
    }

    /*필드를 kinds로 바꾸게 되면 setInfo메소드와 getInfo 메소드는 변경해줘야 한다.
    * 하지만 사용자(클라이언트)의 호출 코드는 변경하지 않아도 된다.*/

}
