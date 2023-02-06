package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentDto;

import java.util.List;

public interface IStudentService {

    void saveStudent(Student student);

    void updateStudent(Student student);

    StudentDto getStudent(String studentNumber) throws Exception;

    List<StudentDto> getAllStudent();



}
