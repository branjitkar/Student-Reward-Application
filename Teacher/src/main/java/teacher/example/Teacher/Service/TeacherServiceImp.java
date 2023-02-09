package teacher.example.Teacher.Service;

import teacher.example.Teacher.DTO.TeacherDTO;
import teacher.example.Teacher.Domain.Teacher;
import teacher.example.Teacher.Repository.TeacherRepository;
import teacher.example.Teacher.exception.TeacherNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImp implements TeacherService{
    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public String removeTeacher(String teacherNumber) {
        Optional<Teacher> toBeDeleted = Optional.ofNullable(teacherRepository.findByTeacherNumber(teacherNumber));
        if(toBeDeleted.isPresent()){
            teacherRepository.delete(toBeDeleted.get());
            return "Teacher Deleted!";
        }
        else
            throw new TeacherNotFoundException("Teacher with number "  + teacherNumber + " not found!" );
    }

    @Override
    public Teacher updateTeacher(String teacherNumber, Teacher teacher) {
        Optional<Teacher> optionalTeacher = Optional.ofNullable(teacherRepository.findByTeacherNumber(teacherNumber));
        if(optionalTeacher.isPresent()){
            Teacher toBeUpdated = optionalTeacher.get();
            toBeUpdated.setContact(teacher.getContact());
            toBeUpdated.setFirstName(teacher.getFirstName());
            toBeUpdated.setLastname(teacher.getLastname());
            toBeUpdated.setSchool(teacher.getSchool());
            toBeUpdated.setTeachingclass(teacher.getTeachingclass());
            return teacherRepository.save(toBeUpdated);
        }
        else
            throw new TeacherNotFoundException("Teacher with number "  + teacherNumber + " not found!" );
    }

    @Override
    public List<TeacherDTO> viewTeachers() {
        List<TeacherDTO> teacherList = teacherRepository.findAll().stream().map(teacher -> modelMapper.map(teacher, TeacherDTO.class)).collect(Collectors.toList());
        return teacherList;
    }

    @Override
    public Teacher getTeacherById(String teacherNumber) {
        Optional<Teacher> teacher = teacherRepository.findById(teacherNumber);
        if(teacher.isPresent()){
            return teacher.get();
        }
        else
            throw new TeacherNotFoundException("Teacher not found!");

    }

    @Override
    public void saveTeacher(TeacherDTO teacher) {

        teacherRepository.save(modelMapper.map(teacher,Teacher.class));

    }

}
