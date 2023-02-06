package com.service.user.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private String id;
    @NotEmpty(message = "UserName field is required")
    private String userName;

    @NotEmpty(message = "Password field is required")
    private String password;

    @NotEmpty(message = "Role field is required")
    private String role;
}
