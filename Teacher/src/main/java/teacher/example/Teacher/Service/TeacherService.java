package teacher.example.Teacher.Service;

import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.Domain.Teacher;

import java.util.List;

public interface TeacherService {

    public Teacher addTeacher(Teacher teacher);

    public String removeTeacher( String teacherNumber);

    public Teacher updateTeacher (String teacherNumber, Teacher teacher);

    public List<TeacherDTO> viewTeachers();

    public Teacher getTeacherById(String teacherNumber);

    public void saveTeacher(TeacherDTO teacher);
}
