package teacher.example.Teacher.Controller;

import org.springframework.kafka.core.KafkaTemplate;
import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.Domain.Teacher;
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
    private KafkaTemplate<String, Teacher> kafkaTemplate;
    private String topicName = "teacher-topic";

    public TeacherController (KafkaTemplate<String, Teacher> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    @PostMapping("/teachers/add")
    public ResponseEntity<?> add(@RequestBody Teacher teacher ){
        Teacher teacher1 = teacherService.addTeacher(teacher);
        kafkaTemplate.send(topicName, teacher1);
        return ResponseEntity.ok().body(modelMapper.map(teacher1, TeacherDTO.class));
    }
    @PutMapping("/teachers/{teacherNumber}")
    public ResponseEntity<?> update(@PathVariable String teacherNumber, @RequestBody Teacher teacher){
        Teacher teacher1 = teacherService.updateTeacher(teacherNumber, teacher);
        return ResponseEntity.ok().body(modelMapper.map(teacher1, TeacherDTO.class));
    }
    @DeleteMapping("/teachers/{teacherNumber}")
    public ResponseEntity<String> delete(@PathVariable String teacherNumber){
        return ResponseEntity.ok().body(teacherService.removeTeacher(teacherNumber));
    }
    @GetMapping("/teachers")
    public ResponseEntity<?> viewTeachers() {
        List<TeacherDTO> teachers = teacherService.viewTeachers();
       return ResponseEntity.ok().body(teachers);
    }
    }


