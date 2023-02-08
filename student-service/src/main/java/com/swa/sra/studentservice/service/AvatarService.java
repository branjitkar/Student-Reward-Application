package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Avatar;
import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.repository.IStudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

@Service
@Slf4j
public class AvatarService implements  IAvatarService{


    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private IStudentRepository iStudentRepository;

    @Override
    public void applyElements(String studentNumber, Element element) throws Exception {
        log.info("Inside applyElements methods of applyElements");
        Student student = iStudentService.getStudentByStudentNumber(studentNumber);
        Avatar avatar = student.getAvatar();

        switch (element.getType()){
            case "head":
                avatar.setHead(element.getValue());
                break;
            case "hair":
                avatar.setHair(element.getValue());
                break;
            case "eye":
                avatar.setEye(element.getValue());
                break;
            case "eyebrow":
                avatar.setEyebrow(element.getValue());
                break;
            case "nose":
                avatar.setNose(element.getValue());
                break;
            case "mouth":
                avatar.setMouth(element.getValue());
                break;
            case "ears":
                avatar.setEars(element.getValue());
                break;
            case "body":
                avatar.setBody(element.getValue());
                break;
            case "hat":
                avatar.setHat(element.getValue());
                break;
            case "topColour":
                avatar.setTopColour(element.getValue());
                break;
                case "hatColour":
                avatar.setHatColour(element.getValue());
                break;
            default:

        }
        student.setAvatar(avatar);
        iStudentRepository.save(student);
    }
}
