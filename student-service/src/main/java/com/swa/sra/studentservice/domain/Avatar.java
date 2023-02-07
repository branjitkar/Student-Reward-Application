package com.swa.sra.studentservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Avatar {

    private String  id;

    private String head, hair, eye, eyebrow, nose, mouth, ears, body, hat, top, topColour, hatColour;


}
