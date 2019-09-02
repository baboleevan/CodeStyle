package com.mhlab.codestyle.common.component;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Optional;

/**
 * 보안 관련 처리를 진행하는 인터셉터
 *
 * Created by MHLab on 02/09/2019..
 */

@Slf4j
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(!hasSessionInAccount(request.getSession())) { //세션에 정보가 없는 경우
            try { response.sendRedirect("/users/no_auth"); }
            catch (IOException ie ) { log.error("[AuthInterceptor] error = " + ie.getMessage()); } //만약 리다이렉션 도중 에러가 난 경우
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object object, Exception arg3) throws Exception {

    }


    /**
     * 세션 내에 계정 정보가 있는지 체크하는 메서드
     * @param session
     * @return
     */
    private boolean hasSessionInAccount(HttpSession session) {
        return Optional.ofNullable(session.getAttribute("Account")).isPresent(); //세션이 존재하지 않는 경우
    }
}
