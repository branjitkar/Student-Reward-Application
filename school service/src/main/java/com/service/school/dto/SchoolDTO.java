package com.service.school.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDTO {

    private String id;
    @NotEmpty(message = "Name field is required")
    private String name;

    @NotEmpty(message = "Address field is required")
    private String address;

    @NotEmpty(message = "EmailAddress field is required")
    private String emailAddress;

    @NotEmpty(message = "Phone Number field is required")
    private String phoneNumber;
}
