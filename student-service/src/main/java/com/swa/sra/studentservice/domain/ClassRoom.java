package com.swa.sra.studentservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Year;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassRoom {

    private String year;

    private String group;
}
