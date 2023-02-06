package com.swa.sra.studentservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class School {

    private String name;

    private String address;

    private String emailAddress;

    private String phoneNumber;
}
