package teacher.example.Teacher.Repository;

import teacher.example.Teacher.Domain.Teacher;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TeacherRepository extends MongoRepository<Teacher, String> {
    Teacher findByTeacherNumber(String teacherNumber);
}
