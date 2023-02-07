package com.swa.sra.studentservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentElementDto {

    private String studentNumber;

    private String elementId;
}
