package teacher.example.Teacher.exception;

public class TeacherNotFoundException extends RuntimeException{
    private String message;
    public TeacherNotFoundException(String message){
        this.message = message;
    }
}
