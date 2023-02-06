package com.service.school.service;

import com.service.school.dto.SchoolDTO;

import java.util.List;

public interface SchoolService {

    SchoolDTO addSchool(SchoolDTO userDTO);

    void removeSchool(String id);

    List<SchoolDTO> getAllSchool();

    SchoolDTO updateSchool(SchoolDTO userDTO);
}
