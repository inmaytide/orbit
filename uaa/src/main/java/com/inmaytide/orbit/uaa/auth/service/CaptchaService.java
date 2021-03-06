package com.inmaytide.orbit.uaa.auth.service;

import com.inmaytide.orbit.uaa.domain.dto.CaptchaValidate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient("captcha")
public interface CaptchaService {

    @GetMapping("/captcha/{captcha}")
    CaptchaValidate validate(@PathVariable String captcha, @RequestHeader("x-captcha-name") String captchaName);

}
