package teacher.example.Teacher.Domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teacher")
public class Teacher {

    @Id
    private String teacherNumber;

    private String username;
    private String firstName;
    private String lastname;
    private School school;
    private Contact contact;
    private TeachingClass teachingclass;



    public Teacher(String teacherNumber, String username, String firstName, String lastname, String name, String address, String email, String phone, int year, String group) {
        this.teacherNumber = teacherNumber;
        this.username = username;
        this.firstName = firstName;
        this.lastname = lastname;
        this.school = new School(name, address);
        this.contact = new Contact(email, phone);
        this.teachingclass = new TeachingClass(year, group);
    }

    public Teacher() {
    }

    public String getTeacherNumber() {
        return teacherNumber;
    }

    public void setTeacherNumber(String teacherNumber) {
        this.teacherNumber = teacherNumber;
    }
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public TeachingClass getTeachingclass() {
        return teachingclass;
    }

    public void setTeachingclass(TeachingClass teachingclass) {
        this.teachingclass = teachingclass;
    }



}
