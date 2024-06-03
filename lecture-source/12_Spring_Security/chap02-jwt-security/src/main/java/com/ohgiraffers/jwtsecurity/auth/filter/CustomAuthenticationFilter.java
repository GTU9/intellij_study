package com.ohgiraffers.jwtsecurity.auth.filter;

import org.springframework.security.core.AuthenticationException;

import java.io.IOException;

public class CustomAuthenticationFilter {

    /**
     * description. 지정된 url 요청 시 해당 요청을 가로채서 검증 로직을 수행하는 메소드
     *
     * @param request  : HttpServletRequest
     * @param response : HttpServletResponse
     * @return Authentication
     * @throws AuthenticationException
     */

    /**
     * description. 사용자의 로그인 요청 시 요청 정보를 임시 토큰에 저장하는 메소드
     *
     * @param request : HttpServletRequest
     * @return UsernamePasswordAuthenticationToken
     * @throws IOException
     */
}
