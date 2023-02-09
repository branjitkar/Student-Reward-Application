package teacher.example.Teacher.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document(collection = "teacher")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {

    @Id
    private String teacherNumber;

    private String username;
    private String firstName;
    private String lastname;
    private School school;
    private Contact contact;
    private TeachingClass teachingclass;


}




