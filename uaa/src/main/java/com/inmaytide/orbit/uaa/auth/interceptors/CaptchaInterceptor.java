package com.inmaytide.orbit.uaa.auth.interceptors;

import com.inmaytide.orbit.uaa.utils.RestrictUtil;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CaptchaInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!request.getRequestURI().endsWith("/oauth/token") || !RestrictUtil.neededCaptcha(request)) {
            return true;
        }


        return true;
    }
}