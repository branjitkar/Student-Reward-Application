package com.service.school.dto;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Data
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
