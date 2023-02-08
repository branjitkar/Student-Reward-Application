package edu.miu.sa.LoginService.controller;

import edu.miu.sa.LoginService.dto.LoginDto;
import edu.miu.sa.LoginService.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginDto userCredentials){
        try {
            String token = loginService.getAuthToken(userCredentials);
            return new ResponseEntity<>(token, HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>("Invalid Username or Password", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
