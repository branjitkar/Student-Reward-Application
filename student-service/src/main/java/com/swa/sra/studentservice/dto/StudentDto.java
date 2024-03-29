package com.swa.sra.studentservice.dto;

import com.swa.sra.studentservice.domain.Avatar;
import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Reward;
import com.swa.sra.studentservice.domain.School;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
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

    private  List<Reward> rewardList;

    private School school;

    private  List<ElementDto> elementList;
}
