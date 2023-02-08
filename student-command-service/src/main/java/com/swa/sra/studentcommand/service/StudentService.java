package com.swa.sra.studentcommand.service;


import com.swa.sra.studentcommand.dto.AddStudentDTO;
import com.swa.sra.studentcommand.dto.AvatarDto;
import com.swa.sra.studentcommand.dto.StudentDto;
import com.swa.sra.studentcommand.dto.UserDTO;
import com.swa.sra.studentcommand.event.SaveStudentEvent;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@Slf4j
public class StudentService implements  IStudentService{


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private SaveStudentEvent saveStudentEvent;


    @Autowired
    private StudentServiceFeignClient studentServiceFeignClient;


    @Autowired
    private UserServiceFeignClient userServiceFeignClient;


    @Override
    public String  saveStudent(AddStudentDTO student) {
        log.info("Inside  saveStudent of StudentService");
//        iStudentRepository.save(student);

        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setAvatar(new AvatarDto());
        studentServiceFeignClient.add(studentDto);

        UserDTO userDTO = modelMapper.map(student, UserDTO.class);
        userServiceFeignClient.add(userDTO);

        return "student added";

    }

    @Override
    public void updateStudent(StudentDto student) {
        log.info("Inside  updateStudent of StudentService");
//        iStudentRepository.save(student);
    }

    @Override
    public AddStudentDTO getStudent(String studentNumber) throws Exception {
        log.info("Inside  getStudent of StudentService");
        /*return modelMapper.map(iStudentRepository.findByStudentNumber(studentNumber).orElseThrow(()->
                new Exception("Student Not Found")),StudentDto.class);*/
        return null;
    }

    @Override
    public List<AddStudentDTO> getAllStudent() {
        log.info("Inside  getAllStudent of StudentService");
       /* return iStudentRepository.findAll().stream().map(student->modelMapper.map(student,StudentDto.class))
                .collect(Collectors.toList());*/

        return null;

    }


    @FeignClient("STUDENTSERVICE")
    interface StudentServiceFeignClient{
        @PostMapping("/students/")
        StudentDto add(@RequestBody StudentDto dto);
    }

    @FeignClient("USERSERVICE")
    interface UserServiceFeignClient{
        @PostMapping("/users")
        UserDTO add(@RequestBody UserDTO dto);
    }
}
