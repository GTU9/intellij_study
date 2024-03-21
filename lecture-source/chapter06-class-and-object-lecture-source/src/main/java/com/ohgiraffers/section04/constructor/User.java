package com.ohgiraffers.section04.constructor;

public class User {
    private String id;
    private String pwd;
    private String name;
    private java.util.Date enrollDate;

    /*생성자의 작성 위치
    * 작성 위치는 문법상으로 클래스 내부에 작성하면 되지만,
    * 통상적으로 필드 선언부와 메소드 선언부 사이에 작성하는 것이 관례이다.
    * */

    /*생성자의 목적
    * 1. 인스턴스 생성 시점에 수행할 명령이 있는 경우 사용한다.
    * 2. 매개변수가 있는 생성자의 경우 매개변수로 전달받은 값으로 필드를 초기화하며 인스턴스를 생성할 목적으로 주로 사용된다.
    * 3. 작성한 생성자 외에는 인스턴스를 생성하는 방법을 제공하지 않는다는 의미를 가진다.
    *    따라서, 인스턴스를 생성하는 방법으로 제한하기 위한 용도로 사용할 수도 있다. (초기값 전달 강제화)
    *  */

    /*생성자 작성 방벙
    * [표현식]
    * 접근제한자 클래스명(매개변수){
    *           인스턴스 생성 시점에 수행할 명령 기술 (주로 필드 초기화)
    *           this.필드명=매개변수;              //설정자(setter) 여러 개의 기능을 한 번의 호출로 수행할 수 있다.
    * }
    * */

    /*생성자 작성 시 주의할점
    * 1. 생성자 메소드는 반드시 클래스의 이름과 동일해야 한다. (대/소문자까지 같아야함)
    * 2. 생성자 메소드는 반환형을 작성하지 않는다. (작성하는 경우 생성자가 아닌 메소드로 인식한다.)*/

    /*생성자의 종류
    * 1. 기본 생성자(매개변수 없는 생성자)
    * 2. 매개변수 있는 생성자
    * 기본 생성자는 자바 Compiler가 자동으로 추가해주는 구문이지만 명시적으로 작성할 수도 있다.
    * 매개변수가 있는 생성자 한개 라도 존재하는 경우 기본생성자를 자동으로 추가해주지 않기 때문에
    * 기본생성자가 필요한 경우에는 반드시 명시적으로 작성해 주어야 한다.
    * */

    /*1. 기본생성자(default constructor)*/
    public User(){
        /*수행할 내용이 아무 것도 존재하지 않는다.
        * 호출 확인을 위해 출력 구문만 작성해보았다.
        * 메소드와 같이 수행할 명령들을 작성할 수 있다.
        * */
        System.out.println("User 클래스의 기본생성자 호출함...");
    }

    /*주의사항. 동일한 생성자 혹은 메소드를 한 클래스 안에서 작성하는 것은 불가능한다. (Compile Error)*/
//    public User(){}

    /*2. 매개변수가 있는 생성자*/
    /*초기화할 필드가 여러 개인 경우, 초기화하고 싶은 필드의 갯수별로 생성자를 여러개 준비해둘 수 있다.*/
    /*id, pwd, name의 초기화를 담당할 생성자*/

    public  User(String id, String pwd, String name){
        /*분명히 동일한 이름의 생성자는 작성하지 못한다고 했는데 작성했다
        * 매개변수 선언부에 작성한 매개변수의 타입, 갯수, 순서에 따라 동일한 생성자 혹은 메소드를
        * 한 클래스 내에 여러개 작성할 수 있게 만든 기술이다.(오버로딩)
        * 오버로딩 부분은 뒤에 별도의 챕텅에서 다시 다루고 우선 지금은 매개변수가 있는 생성자의 역할에 대해 살펴보자
        * */

        /*매개변수에 있는 생성자의 주 목적은 인스턴스 생성 시점에 매개변수로 전달 받은 값을 이용해서 필드를 초기화 한다.*/
        this.id=id;                 //this는 인스턴스 생성 시점에 발생한 주소가 저장된다. (heap은 주소로 접근)
        this.pwd=pwd;
        this.name=name;

        System.out.println("User 클래스의 id, pwd, name을 초기화하는 생성자를 호출함...");
    }

    public String getInformation(){
        return "User [id="+this.id+",pwd="+this.pwd+",name="+this.name+",enrollDate="+this.enrollDate+"]";
    }
}
