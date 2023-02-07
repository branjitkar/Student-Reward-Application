package teacher.example.Teacher.Controller;

import teacher.example.Integration.Message;
import teacher.example.Integration.Sender;
import teacher.example.Teacher.DTO.AddTeacherDTO;
import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.Service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private Sender sender;
    private String topicName = "teacher-topic";

    @PostMapping("/teacher-command")
    public ResponseEntity<?> add(@RequestBody AddTeacherDTO addTeacherDTO ){
        String result = teacherService.addTeacher(addTeacherDTO);
        return ResponseEntity.ok().body(result);
    }

    }


