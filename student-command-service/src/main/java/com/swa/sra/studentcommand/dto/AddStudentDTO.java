package com.swa.sra.studentcommand.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

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
    private Long score;
    private AvatarDto avatar;
    private List<RewardDto> rewardList;
    private SchoolDto school;
}
