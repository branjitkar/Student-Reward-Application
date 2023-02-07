package com.swa.sra.studentservice.controller;

import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.service.IAvatarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students-avatar/")
@Slf4j
public class AvatarController {

    @Autowired
    private IAvatarService iAvatarService;

    @PostMapping("{studentNumber}")
    public ResponseEntity<?> applyElements(@PathVariable("studentNumber") String studentNumber, @RequestBody Element element){
        log.info("Inside  applyElements method of StudentController");
        try{
            iAvatarService.applyElements(studentNumber,element);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Saved Successfully", HttpStatus.OK);
    }
}
