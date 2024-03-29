package teacher.example.Teacher.Service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import teacher.example.Teacher.DTO.AddTeacherDTO;
import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.DTO.UserDTO;
import teacher.example.Teacher.DTO.UserNotificationDTO;
import teacher.example.Teacher.Integration.KafkaSender;
import teacher.example.Teacher.Integration.Message;
import teacher.example.Teacher.config.FeignConfig;

@Service
@EnableFeignClients
public class TeacherServiceImp implements TeacherService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TeacherFeignClient teacherFeignClient;

    @Autowired
    private UserFeignClient userFeignClient;

    @Autowired
    private KafkaSender kafkaSender;

    public String addTeacher(AddTeacherDTO addTeacherDTO) {

        TeacherDTO teacher = modelMapper.map(addTeacherDTO, TeacherDTO.class);
        teacherFeignClient.add(teacher);
        UserDTO user = modelMapper.map(addTeacherDTO, UserDTO.class);
        user.setRole("TEACHER");
        userFeignClient.addUser(user);

        UserNotificationDTO userNotificationDTO = new UserNotificationDTO(user.getUserName(), user.getPassword(), user.getRole(), addTeacherDTO.getContact().getEmail());
        Message<UserNotificationDTO> message = new Message<>("added", userNotificationDTO);
        kafkaSender.send("new-user", message);

        return "Teacher added";
    }

    @FeignClient(name = "TEACHERSERVICE", configuration = FeignConfig.class)
    public interface TeacherFeignClient {
        @PostMapping("/teachers/add")
        TeacherDTO add(@RequestBody TeacherDTO teacher);
    }

    @FeignClient(name = "USERSERVICE", configuration = FeignConfig.class)
    public interface UserFeignClient {
        @PostMapping("/users")
        UserDTO addUser(@RequestBody UserDTO userDTO);
    }
}