package com.inmaytide.orbit.auth.client;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.inmaytide.orbit.auth.interceptor.CaptchaInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("orbit-captcha")
public interface CaptchaClient {

    @GetMapping("/captcha/{captcha}")
    ObjectNode validate(@RequestHeader(CaptchaInterceptor.HEADER_NAME_CAPTCHA_NAME) String cacheName,
                        @PathVariable("captcha") String captcha);
}
