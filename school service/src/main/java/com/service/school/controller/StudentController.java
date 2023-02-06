package com.service.school.controller;

import com.service.school.dto.SchoolDTO;
import com.service.school.reponsemsg.ResponseMessage;
import com.service.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    private SchoolService service;
    @PostMapping("/addSchool")
    ResponseEntity<?> addUser(@RequestBody SchoolDTO userDTO) {
        service.addSchool(userDTO);
        return new ResponseEntity<>(new ResponseMessage("School Created Successfully"), HttpStatus.OK);
    }

    @GetMapping("/getAllSchool")
    ResponseEntity<?> getAllSchoolList() {
        List<SchoolDTO> userDTOList = service.getAllSchool();
        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping("/updateSchool/{id}")
    ResponseEntity<?> updateSchool(@PathVariable(value = "id") String id, @RequestBody SchoolDTO dto) {
        dto.setId(id);
        SchoolDTO updateSchoolDTO = service.updateSchool(dto);

        if (updateSchoolDTO == null) {
            return new ResponseEntity<>(new ResponseMessage("School Cannot update"), HttpStatus.BAD_GATEWAY);
        } else {
            return new ResponseEntity<>(new ResponseMessage("School Update Successfully"), HttpStatus.OK);
        }
    }

    @DeleteMapping("/deleteSchool/{id}")
    ResponseEntity<?> deleteSchool(@PathVariable(value = "id") String id){
        service.removeSchool(id);
        return new ResponseEntity<>(new ResponseMessage("School Delete Successfully"), HttpStatus.OK);
    }
}
