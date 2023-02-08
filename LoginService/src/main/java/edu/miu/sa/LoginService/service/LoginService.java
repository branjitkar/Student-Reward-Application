package edu.miu.sa.LoginService.service;

import edu.miu.sa.LoginService.dto.LoginDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginService {
    @Value("${authentication.url}")
    private String url;
    @Value("${authentication.clientId}")
    private String clientId;
    @Value("${authentication.clientSecret}")
    private String clientSecret;

    public String getAuthToken(LoginDto userCredentials) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBasicAuth(clientId, clientSecret);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("grant_type", "password");
        params.add("username", userCredentials.getUsername());
        params.add("password", userCredentials.getPassword());
        params.add("scope", "webclient");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<OAuth2AccessToken> response = restTemplate.postForEntity(url, request, OAuth2AccessToken.class);

        return response.getBody().getValue();

    }
}
