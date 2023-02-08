package com.swa.sra.studentcommand.service;


import com.swa.sra.studentcommand.Integration.KafkaSender;
import com.swa.sra.studentcommand.Integration.Message;
import com.swa.sra.studentcommand.config.FeignConfig;
import com.swa.sra.studentcommand.dto.*;
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
public class StudentService implements IStudentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private StudentServiceFeignClient studentServiceFeignClient;
    @Autowired
    private UserServiceFeignClient userServiceFeignClient;
    @Autowired
    private KafkaSender kafkaSender;

    @Override
    public String saveStudent(AddStudentDTO student) {
        log.info("Inside  saveStudent of StudentService");

        StudentDto studentDto = modelMapper.map(student, StudentDto.class);
        studentDto.setAvatar(new AvatarDto());
        studentDto.setScore((long) 1000);
        studentServiceFeignClient.add(studentDto);

        UserDTO userDTO = modelMapper.map(student, UserDTO.class);
        userServiceFeignClient.add(userDTO);

        UserNotificationDTO userNotificationDTO = new UserNotificationDTO(userDTO.getUserName(), userDTO.getPassword(), userDTO.getRole(), student.getContact().getEmail());
        Message<UserNotificationDTO> message = new Message<>("added", userNotificationDTO);
        kafkaSender.send("new-user", message);

        return "student added";
    }

    @FeignClient(name = "STUDENTSERVICE", configuration = FeignConfig.class)
    interface StudentServiceFeignClient {
        @PostMapping("/students/")
        void add(@RequestBody StudentDto dto);
    }

    @FeignClient(name = "USERSERVICE", configuration = FeignConfig.class)
    interface UserServiceFeignClient {
        @PostMapping("/users")
        void add(@RequestBody UserDTO dto);
    }
}
