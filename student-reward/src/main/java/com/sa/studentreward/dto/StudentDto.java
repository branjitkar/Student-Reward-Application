package com.sa.studentreward.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class StudentDto {

    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private double score;

    private AvatarDto avatar;

    private  List<Reward> rewardList= new ArrayList<>() ;

    private SchoolDto school;

    private  List<ElementDto> elementList = new ArrayList<>();

    public  void addElement(ElementDto element){
        elementList.add(element);
    }
    public  void addReward(Reward reward){
        rewardList.add(reward);
    }
}
