package com.service.school.service.impl;

import com.service.school.dto.SchoolDTO;
import com.service.school.dto.SchoolWrapper;
import com.service.school.entity.School;
import com.service.school.repository.SchoolRepository;
import com.service.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolImpl implements SchoolService {
    @Autowired
    private SchoolRepository schoolRepository;

    @Override
    public SchoolDTO addSchool(SchoolDTO userDTO) {
        School school =  SchoolWrapper.mapToSchool(userDTO);
        return SchoolWrapper.mapToSchoolDto(schoolRepository.save(school));
    }

    @Override
    public void removeSchool(String id) {
        schoolRepository.deleteById(id);
    }

    @Override
    public List<SchoolDTO> getAllSchool() {
        List<School>list =  schoolRepository.findAll();
        return list.stream().map(SchoolWrapper::mapToSchoolDto).collect(Collectors.toList());
    }

    @Override
    public SchoolDTO updateSchool(SchoolDTO schoolDTO) {
        Optional<School> optionalSchool = schoolRepository.findById(schoolDTO.getId());

        if (optionalSchool.isPresent()){
            School user = SchoolWrapper.mapToSchool(schoolDTO);
            return SchoolWrapper.mapToSchoolDto(schoolRepository.save(user));
        }

        return null;
    }
}
