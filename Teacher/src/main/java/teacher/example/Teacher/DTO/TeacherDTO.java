package teacher.example.Teacher.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import teacher.example.Teacher.Domain.Contact;
import teacher.example.Teacher.Domain.School;
import teacher.example.Teacher.Domain.TeachingClass;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TeacherDTO {

    private String teacherNumber;
    private String username;
    private String firstName;
    private String lastname;
    private School school;
    private Contact contact;
    private TeachingClass teachingclass;


}

