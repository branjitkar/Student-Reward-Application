package teacher.example.Teacher.DTO;

import lombok.Data;

@Data
public class AddTeacherDTO {
    private String userName;
    private String teacherNumber;
    private String firstName;
    private String lastname;
    private School school;
    private Contact contact;
    private TeachingClass teachingclass;
    private String password;





}
