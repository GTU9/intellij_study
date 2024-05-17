package com.ohgiraffers.section02.reflection;

public class Application {

    /*
    * [ reflection ]
    * 컴파일된 자바 코드에서 역으로 클래스를 불러 method 및 field 정보를 구해오는 방법으로,
    * 반사, 투명이라는 의미를 가진다.
    * 리플레션 JVM에서 실행되는 애플리케이션의 런타임 동작을
    * 검사하거나 수정할 수 있는 기능이 필요한 경우 사용한다.
    * SpringFramework, MyBatis, Hibernate, jackson 등의 라이브러리에서 사용하며,
    * Spring에서는 Reflection을 사용해서 런타임 시
    * 개발자가 등록한 bean을 애플리케이션 내에서 사용할 수 있게 한다.
    *
    * [ 주의 사항 ]
    * Reflection은 강력한 도구이지만 무분별하게 사용해서는 안된다.
    * 1. 오버헤드 발생 : 성능 저하를 발생시킬 수 있으므로 성능에 민감한 애플리케이션에서는 사용하지 않는다.
    * 2. 캡슐화 저해 : private로 설정한 멤버에 접근 가능하므로 기능이 저하되며 여러 문제를 발생시킬 수 있다.
    *
    * [ Reflection이 사용되는 경우 ]
    * 1. IoC Container
    * 2. AOP
    * 3. Mybatis Mapper
    * 4. log4jdbc
    * */
}
