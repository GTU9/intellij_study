package com.ohgiraffers.section02.superkeyword;

import java.util.Date;

public class Computer extends Product {

    /*Computer는 하나의 Product이지만, 모든 Product는 Computer가 아니다. (IS-A)*/

    private String cpu;
    private int hdd;
    private int ram;
    private String operationSystem;

    /*기본생성자*/
    public Computer(){
        System.out.println("Computer 클래스의 기본 생성자 호출함...");
    }

    /*모든 필드를 초기화하는 생성자*/

    public Computer(String code, String brand, String name, int price, Date manufaturingDate, String cpu, int hdd, int ram, String operationSystem) {

        /*부모의 모든 필드를 초기화하는 생성자로 Product 클래스가 가진 필드를 초기화할 값 전달*/
        super(code, brand, name, price, manufaturingDate);

        /*나머지 필드를 초기화*/
//        this(cpu, hdd, ram, operationSystem)

        /*this()로 위에 작성한 생성자를 호출한다는 의미는
        * super()를 두 번 호출하는 것과 같기 때문에 허용되지 않는다.
        * 부모 인스턴스를 두 개 생성할 수 없기 때문에 부모 생성자는 한 번만 호출 가능하다.*/

        /*나머지 필드는 그냥 작성함*/
        this.cpu = cpu;
        this.hdd = hdd;
        this.ram = ram;
        this.operationSystem = operationSystem;

        System.out.println("Computer 클래스의 부모 필드도 초기화하는 생성자 호출함...");

    }

    /*setter와 getter는 부모 필드의 메소드에 대해서는 자신의 것 처럼 사용 가능하다.
    * 따로 작성할 필요 없이 부모클래승 작성한 것을 사용할 수 있다.
    * 따라서 자식클래스에 추가된 필드에 대해서만 setter/getter를 작성하면 된다.*/


}
