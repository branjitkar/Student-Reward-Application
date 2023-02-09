package edu.miu.EmailService.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.miu.EmailService.domain.Email;
import edu.miu.EmailService.dto.UserNotificationDTO;
import edu.miu.EmailService.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.KafkaListener;

@Service
public class NewUserListener {
    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = {"new-user"})
    public void listenWhenOrderPlaced(@Payload String userDetails) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            System.out.println("Received new user details ....");
            UserNotificationDTO messageUserDetails = objectMapper.readValue(userDetails, new TypeReference<Message<UserNotificationDTO>>() {
            }).getMessage();

            String body = "<p>Welcome to Student Reward Application.</p>\n" +
                    "<p>You have been registered as a <b>" + messageUserDetails.getRole() + "</b>. Please use the following credentirals to login to the system.</p>\n" +
                    "<p>username: <b>" + messageUserDetails.getUsername() + "</b><br/>\n" +
                    "password: <b>" + messageUserDetails.getPassword() + "</b></p>";

            Email email = new Email(messageUserDetails.getEmail(), "Welcome to Student Reward Application", body);
            emailService.sendWithHTMLBody(email);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}
