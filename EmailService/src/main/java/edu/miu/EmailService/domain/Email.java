package edu.miu.EmailService.domain;

import lombok.Data;

@Data
public class Email {
    private String receiverEmail;
    private String subject;
    private String body;
}
