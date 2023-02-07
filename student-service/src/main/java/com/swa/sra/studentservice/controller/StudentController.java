package com.swa.sra.studentservice.controller;

import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.service.IStudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students/")
@Slf4j
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student){
        log.info("Inside  saveStudent method of StudentController");
        try{
            iStudentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
    }

    @PutMapping("{studentNumber}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student){
        log.info("Inside  updateStudent method of StudentController");
        return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
    }

    @GetMapping("{studentNumber}")
    public ResponseEntity<?> getStudent(@PathVariable("studentNumber") String studentNumber) throws Exception {
        log.info("Inside  getStudent  method of StudentController");
        return new ResponseEntity<>(iStudentService.getStudent(studentNumber), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudent(){
        log.info("Inside  getAllStudent of StudentController");
        return new ResponseEntity<>(iStudentService.getAllStudent(), HttpStatus.OK);
    }
}
