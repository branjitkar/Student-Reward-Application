package edu.miu.EmailService.controller;

import edu.miu.EmailService.domain.Email;
import edu.miu.EmailService.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;

    @PostMapping
    public ResponseEntity<?> send(@RequestBody Email email){
        emailService.send(email);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

    @PostMapping("/html")
    public ResponseEntity<?> sendWithHTMLBody(@RequestBody Email email){
        emailService.sendWithHTMLBody(email);
        return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
    }

}
