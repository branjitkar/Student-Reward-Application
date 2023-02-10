package teacher.example.Teacher.Controller;

import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.DTO.Teachers;
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

    private String topicName = "teacher-topic";

    @PostMapping("/teachers/add")
    public ResponseEntity<?> add(@RequestBody TeacherDTO teacherDTO ){
        teacherService.saveTeacher(teacherDTO);
        return ResponseEntity.ok().body(teacherDTO);
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

        List<TeacherDTO> teacherList = teacherService.viewTeachers();
        return ResponseEntity.ok().body(teacherList);
    }
    @GetMapping("/teachers/{teacherNumber}")
    public ResponseEntity<?> getTeacher(@PathVariable("teacherNumber") String teacherNumber){
        Teacher teacher = teacherService.getTeacherById(teacherNumber);
        return ResponseEntity.ok().body(modelMapper.map(teacher, TeacherDTO.class));
    }

    }


