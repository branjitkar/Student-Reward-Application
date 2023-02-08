package edu.miu.EmailService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserNotificationDTO {
    private String username;
    private String password;
    private String role;
    private String email;
}
