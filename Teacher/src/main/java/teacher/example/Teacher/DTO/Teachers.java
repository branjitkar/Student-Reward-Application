package teacher.example.Teacher.DTO;



import java.util.ArrayList;
import java.util.Collection;


public class Teachers {
    private Collection<TeacherDTO> teachers = new ArrayList<>();

    public void setTeachers(Collection<TeacherDTO> teachers) {
        this.teachers = teachers;
    }

    @Override
    public String toString() {
        return "Teachers{" +
                "teachers=" + teachers +
                '}';
    }

    public Collection<TeacherDTO> getTeachers(){
        return  teachers;
    }

}
