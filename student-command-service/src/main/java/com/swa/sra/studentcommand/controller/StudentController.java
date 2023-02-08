package com.swa.sra.studentcommand.controller;

import com.swa.sra.studentcommand.dto.AddStudentDTO;
import com.swa.sra.studentcommand.service.IStudentService;
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
    public ResponseEntity<?> saveStudent(@RequestBody AddStudentDTO student){
       /* log.info("Inside  saveStudent of StudentController");
        try{
            iStudentService.saveStudent(student);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>("Error Saving", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
*/
        String result = iStudentService.saveStudent(student);
        return ResponseEntity.ok().body(result);

    }

    @PutMapping("{studentNumber}")
    public ResponseEntity<?> updateStudent(@RequestBody AddStudentDTO student){
        log.info("Inside  updateStudent of StudentController");
        return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
    }

    @GetMapping("{studentNumber}")
    public ResponseEntity<?> getStudent(@PathVariable("studentNumber") String studentNumber) throws Exception {
        log.info("Inside  getStudent of StudentController");
        return new ResponseEntity<>(iStudentService.getStudent(studentNumber), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<?> getAllStudent(){
        log.info("Inside  getAllStudent of StudentController");
        return new ResponseEntity<>(iStudentService.getAllStudent(), HttpStatus.OK);
    }
}
