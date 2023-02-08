package com.swa.sra.studentcommand.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AddStudentDTO {
    private long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private ContactDTO contact;
    private SchoolDto school;
}
