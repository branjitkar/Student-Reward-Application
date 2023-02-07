package com.swa.sra.studentcommand.controller;

import com.swa.sra.studentcommand.dto.AddStudentDTO;
import com.swa.sra.studentcommand.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student-command")
@Slf4j
public class StudentController {
    @Autowired
    private IStudentService iStudentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody AddStudentDTO student){
        String result = iStudentService.saveStudent(student);
        return ResponseEntity.ok().body(result);

    }
}
