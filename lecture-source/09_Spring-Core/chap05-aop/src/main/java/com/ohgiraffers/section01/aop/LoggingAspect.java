package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*@Aspect : pointcut과 advice를 하나의 클래스 단위로 정의하기 위한 어노테이션*/
@Aspect
@Component
public class LoggingAspect {
    /*
    * [ @Pointcut ]
    * - 여러 Join point를 매치하기 위해 지정한 표현식
    * ds  execution([수식어] 리턴타입 [클래스이름].이름(파라미터_)
    * - 수식어(접근제어자) 생략 간응 public private protected default
    * - 파라미터 표현 방식
    *   *(..) : 매개변수가 0개 이상인 모든 메소드
    *   *(*) : 매개변수가 1개인 모든 메소드
    *   *(*,..) : 매개변수가 1개 이상인 모든 메소드
    * */

    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")
    public void logPointcut() {}

    /*
    * JoinPoint : Pointcut 으로 패치한 실행 지점
    * 매치된 JoinPoint에서 해야 할 일이 Advice이다.
    * 매개변수로 전달한 JoinPoint 객체는
    * 현재 JoinPoint의 메소드명, 인수값 등 자세한 정보에 액세스 할 수 있다.
    * */
    @Before("LoggingAspect.logPointcut()")
    public void logBefore(JoinPoint joinPoint){
        System.out.println("[Before joinPoint.getTarget()] "+joinPoint.getTarget());
        System.out.println("[Before joinPoint.getSignature()] "+joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("[Before joinPoint.getArgs()[0]] "+joinPoint.getArgs()[0]);
        }

    }


}
