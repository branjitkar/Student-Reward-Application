package com.sa.studentreward.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElementDto {

    private int id;

    private String type;

    private double price;

    private String value;
}
