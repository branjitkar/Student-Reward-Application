package com.swa.sra.studentservice.controller;

import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentElementDto;
import com.swa.sra.studentservice.service.ElementEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students/element/")
@Slf4j
public class StudentElementController {

    @Autowired
    private ElementEventService elementEventService;

    @PostMapping("buy")
    public ResponseEntity<?> buyElements(@RequestBody StudentElementDto studentElementDto){
        log.info("Inside  buyElements method of StudentController");
        try{
            elementEventService.buyElements(studentElementDto);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Transaction Successful", HttpStatus.OK);
    }

    @PostMapping("change")
    public ResponseEntity<?> changeElements(@RequestBody StudentElementDto studentElementDto){
        log.info("Inside  changeElements method of StudentController");
        try{
            elementEventService.changeElement(studentElementDto);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Change Successful", HttpStatus.OK);
    }

    @PostMapping("remove")
    public ResponseEntity<?> removeElement(@RequestBody StudentElementDto studentElementDto){
        log.info("Inside  removeElement method of StudentController");
        try{
            elementEventService.removeElements(studentElementDto);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Remove Successful", HttpStatus.OK);
    }
}
