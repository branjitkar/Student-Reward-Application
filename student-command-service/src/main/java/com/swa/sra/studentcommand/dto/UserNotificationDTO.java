package com.swa.sra.studentcommand.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserNotificationDTO {
    private String username;
    private String password;
    private String role;
    private String email;
}
