package com.swa.sra.studentservice.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;


@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {

    @Id
    private Long id;

    private String firstName;

    private String lastName;

    private String studentNumber;

    private double score = 1000.00;

    private ClassRoom classRoom;

     private Avatar avatar;

    private  List<Reward> rewardList;

    private  School school;

    private  List<Element> elementList = new ArrayList<>();

    public  void addElement(Element element){
        elementList.add(element);
    }
}
