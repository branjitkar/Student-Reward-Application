package com.swa.sra.studentservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private Long score = 1000L;

    private ClassRoom classRoom;

     private List<Avatar> avatarList;

    private  List<Reward> rewardList;

    private  School school;
}
