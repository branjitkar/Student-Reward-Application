package com.swa.sra.studentcommand.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private Long score;

    private AvatarDto avatar;

    private ContactDTO contact;

    private SchoolDto school;
}
