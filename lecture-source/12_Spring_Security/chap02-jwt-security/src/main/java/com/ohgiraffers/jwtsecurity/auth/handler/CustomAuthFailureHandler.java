package com.ohgiraffers.jwtsecurity.auth.handler;

/**
 * 사용자 로그인 실패 시 실패 요청을 커스텀 하기 위한 핸들러 클래스
 */
/*
 *   [ 패키지 구조 ]
 *   AuthenticationFailureHandle(interface) -&gt; SimpleUrlAuthenticationFail(class) -&gt; AuthFailHandler
 *   우리는 AuthenticationFilureHandler 구현해야 하지만 기존에 구현되어 있는 SimpleUrlAuthenticationFail 상속 받아
 *   응답 메시지와 페이지 경로를 설정할 수 있게 하도록 재정의를 하는 것이다.
 *   페이지 경로와 커스텀을 할 수 있도록 만들어주는 메서드는 setDefaultFailureUrl("경로") 메서드 이다.
 * */
public class CustomAuthFailureHandler {

    /**
     * 사용자의 잘못된 로그인 시도를 커스텀 하기 위한 핸들러 메소드
     *
     * @param request   사용자 요청 개체
     * @param response  서버 응답값
     * @param exception 발생한 오류를 담는 개체
     */
}