package com.swa.sra.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private Long score;
}
