package com.ohgiraffers.section05.parameter;

public class Application {
    public static void main(String[] args) {
        /*메소드의 파라미터에 대해 이해하고 사용할 수 있다.*/
        /*메소드의 파라미터 선언부에는 다양한 종류의 값을 인자로 전달하며 호출할 수 있다.*/

        /*매개변수(parameter)로 사용 가능한 자료형
        * 1. 기본자료형
        * 2. 기본자료형 배열
        * 3. 클래스자료형
        * 4. 크래스자료형 배열
        * 5. 가변인자
        * */

        /*파라미터 타입별 호출 테스트 기능을 제공하는 ParameterTest 클래스 작성 후 인스턴스 생성*/
        ParameterTest pt=new ParameterTest();

        /*1. 기본자료형을 매개변수로 전달 받는 메소드 호출 확인*/
        /*기본자료형 8가지 모두 가능하다.*/
        int num=20;
        pt.testPrimaryTypeParameter(num);
    }
}
