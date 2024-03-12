package com.ohgiraffers.section01.method;

public class Application6 {
    public static void main(String[] args) {
        /*메소드 리턴값을 이해하고 활용할 수 있다.*/
        /*메소드 리턴값 테스트
        * 메소드는 항상 마지막에 return 명령어가 존재한다.
        * return은 자신을 호출한 구문으로 복귀하는 것을 의미함
        * 복귀를 할 때 그냥 복귀를 할 수도 있지만, 값을 갖고 복귀할 수도 있다.
        * 이 떄 가지고 가는 값을 리턴값이라고 한다.
        *
        *
        * return 값을 반환받기 위해서는 메소드 선언부에 리턴 타입을 명시해 주어야한다.
        * void는 아무 반환값도 가지지 않겠다는 리턴타입에 사용할 수 있는 키워드이다.
        * 반환값이 없는 경우 return 구문은 생략해도 컴파일러가 자동으로 추가해주지만,
        * 반환값이 있는 경우 return 구문을 반드시 명시적으로 작성해야 한다.
        * 또한 메소드 선언부에 선언한 리턴타입 반환값의 자료형은 반드시 일치해야 한다.*/

        System.out.println("main() 매소드 시작함...");

        /*1. 메소드 리턴값 확인*/
        /*메소드 작성 후 호출을 해보면 아무런 변화가 없다.
        * 하지만 호출은 할 것이다.
        * 아무런 내용이 출력되지 않은 것은 당연하다. 출력하는 명령어가 존재하지 않는다.
        * */
        Application6 app6=new Application6();
        app6.testMethod();

        /*호출한 메소드는 hello world 라는 문자열을 반환하도록 해 놓았다.
        * 호출한 메소드가 종료되서 호출 구문 자체가 반환값이 된다.
        * */

        String returnText=app6.testMethod();
        System.out.println(returnText);

        /*변수에 저장하지 않고 바로 출력도 가능하다.*/
        System.out.println(app6.testMethod());
        System.out.println("main() 메소드 종료함...");

    }

    public String testMethod(){
        /*public 뒤에 바로 return으로 가지고 갈 타입을 명시한다.
        * 아무 값도 리턴하지 않는 경우 void, 값을 반환하는 경우에는 반환값이 자료형을 작성해야 한다.
        * */

        return "hello world";
    }
}
