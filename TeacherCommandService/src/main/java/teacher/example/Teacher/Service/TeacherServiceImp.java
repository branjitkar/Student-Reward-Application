package teacher.example.Teacher.Service;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import teacher.example.Teacher.DTO.AddTeacherDTO;
import teacher.example.Teacher.DTO.TeacherDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teacher.example.Teacher.DTO.UserDTO;

@Service
@EnableFeignClients
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TeacherFeignClient teacherFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    public String addTeacher(AddTeacherDTO addTeacherDTO) {

        TeacherDTO teacher = modelMapper.map(addTeacherDTO, TeacherDTO.class);
        teacherFeignClient.add(teacher);
        UserDTO user = modelMapper.map(addTeacherDTO, UserDTO.class);
        user.setRole("TEACHER");
        userFeignClient.addUser(user);

        return "Teacher added";
    }

    @FeignClient("TEACHERSERVICE")
    public interface TeacherFeignClient{
        @PostMapping("/teachers/add")
        TeacherDTO add(@RequestBody TeacherDTO teacher );
    }

    @FeignClient("USERSERVICE")
    public interface UserFeignClient{
        @PostMapping("/users")
        UserDTO addUser(@RequestBody UserDTO userDTO) ;
    }
}