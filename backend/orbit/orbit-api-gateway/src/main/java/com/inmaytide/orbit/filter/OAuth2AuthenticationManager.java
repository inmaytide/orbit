package com.inmaytide.orbit.filter;

import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.http.AccessTokenRequiredException;
import org.springframework.security.oauth2.client.resource.BaseOAuth2ProtectedResourceDetails;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

public class OAuth2AuthenticationManager implements ReactiveAuthenticationManager {

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        if (authentication == null) {
            return Mono.error(new AccessTokenRequiredException(new BaseOAuth2ProtectedResourceDetails()));
        }
        return Mono.just(authentication);
    }

}
