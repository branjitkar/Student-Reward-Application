package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentDto;
import com.swa.sra.studentservice.repository.IStudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StudentService implements  IStudentService{

    @Autowired
     private  IStudentRepository iStudentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void saveStudent(Student student) {
        log.info("Inside  saveStudent of StudentService");
        iStudentRepository.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        log.info("Inside  updateStudent of StudentService");
        iStudentRepository.save(student);
    }

    @Override
    public StudentDto getStudent(String studentNumber) throws Exception {
        log.info("Inside  getStudent of StudentService");
        return modelMapper.map(iStudentRepository.findByStudentNumber(studentNumber).orElseThrow(()->
                new Exception("Student Not Found")),StudentDto.class);
    }

    @Override
    public List<StudentDto> getAllStudent() {
        log.info("Inside  getAllStudent of StudentService");
        return iStudentRepository.findAll().stream().map(student->modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());

    }
}
