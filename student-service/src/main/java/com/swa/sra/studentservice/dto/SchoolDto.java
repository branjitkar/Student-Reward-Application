package com.swa.sra.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SchoolDto {

    private String name;

    private String address;

    private String emailAddress;

    private String phoneNumber;
}
