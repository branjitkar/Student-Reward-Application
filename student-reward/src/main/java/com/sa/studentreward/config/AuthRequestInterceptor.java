package com.sa.studentreward.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.common.OAuth2AccessToken;

public class AuthRequestInterceptor implements RequestInterceptor {

    private final OAuth2ClientContext oAuth2ClientContext;
    private final OAuth2RestTemplate oAuth2RestTemplate;

    public AuthRequestInterceptor(OAuth2ClientContext oAuth2ClientContext, OAuth2RestTemplate oAuth2RestTemplate) {
        this.oAuth2ClientContext = oAuth2ClientContext;
        this.oAuth2RestTemplate = oAuth2RestTemplate;
    }

    @Override
    public void apply(RequestTemplate template) {
        OAuth2AccessToken accessToken = oAuth2ClientContext.getAccessToken();
        if (accessToken == null) {
            accessToken = oAuth2RestTemplate.getAccessToken();
        }
        template.header("Authorization", "Bearer " + accessToken.getValue());
    }
}
