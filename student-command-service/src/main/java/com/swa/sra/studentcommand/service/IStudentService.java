package com.swa.sra.studentcommand.service;


import com.swa.sra.studentcommand.dto.AddStudentDTO;
import com.swa.sra.studentcommand.dto.StudentDto;

import java.util.List;

public interface IStudentService {
    String saveStudent(AddStudentDTO student);
}
