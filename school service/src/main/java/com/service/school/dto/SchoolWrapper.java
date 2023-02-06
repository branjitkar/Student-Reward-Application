package com.service.school.dto;


import com.service.school.entity.School;


public class SchoolWrapper {

    public static SchoolDTO mapToSchoolDto(School school){
        return new SchoolDTO(
                school.getId(),
                school.getName(),
                school.getAddress(),
                school.getEmailAddress(),school.getPhoneNumber()
        );
    }

    public static School mapToSchool(SchoolDTO schoolDTO){
        return new School(
                schoolDTO.getId(),
                schoolDTO.getName(),
                schoolDTO.getAddress(),
                schoolDTO.getEmailAddress(),schoolDTO.getPhoneNumber()
        );
    }
}
