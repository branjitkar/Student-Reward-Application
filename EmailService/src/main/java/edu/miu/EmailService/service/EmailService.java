package edu.miu.EmailService.service;

import edu.miu.EmailService.domain.Email;

public interface EmailService {
    void send(Email email);
    void sendWithHTMLBody(Email email);
}
