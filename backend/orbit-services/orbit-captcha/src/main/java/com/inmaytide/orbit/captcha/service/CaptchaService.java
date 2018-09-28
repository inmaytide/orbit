package com.inmaytide.orbit.captcha.service;

import org.springframework.core.io.Resource;

/**
 * @author Moss
 * @since October 04, 2017
 */
public interface CaptchaService {

    Resource generateCaptcha(String format, String cacheName);

    Resource generateCaptcha(String cacheName);

    boolean validate(String captcha, String cacheName);

}
