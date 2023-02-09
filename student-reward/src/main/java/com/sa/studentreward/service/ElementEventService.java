package com.sa.studentreward.service;

import com.netflix.discovery.converters.Auto;
import com.sa.studentreward.dto.*;
import com.sa.studentreward.event.IStudentRewardService;
import com.sa.studentreward.feign.ElementClient;
import com.sa.studentreward.feign.RewardClient;
import com.sa.studentreward.feign.StudentClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ElementEventService implements  IElementEventService {



    @Autowired
    private IStudentElementService iStudentElementService;
    @Autowired
    private ElementClient elementClient;

    @Autowired
    private StudentClient studentClient;


    @Autowired
    private IStudentRewardService iStudentRewardService;

    @Autowired
    private RewardClient rewardClient;

    @Override
    public void buyElements(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside buyElements method of ElementEventService ");
        StudentDto oStudent = studentClient.getStudent(studentElementDto.getStudentNumber());
        ElementDto element =elementClient.getElementById(studentElementDto.getElementId());
        if(iStudentElementService.checkSufficientScore(element.getPrice() ,oStudent.getScore())){
            if(oStudent.getElementList() != null && iStudentElementService.checkElementTypeExist(element.getType(),oStudent.getElementList())){
                   iStudentElementService.changeElement(
                           iStudentElementService.getMatchingElementType(element.getType(),oStudent.getElementList()),
                           oStudent,
                           element
                   );
            }else{
                iStudentElementService.addElementAndReducePrice(element,oStudent);
            }

           studentClient.saveStudent(oStudent);

        }else {
            throw  new Exception("Score Not Sufficient");
        }

    }

    @Override
    public void removeElements(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside removeElements method of ElementEventService ");
        StudentDto oStudent =  studentClient.getStudent(studentElementDto.getStudentNumber());
        ElementDto element =elementClient.getElementById(studentElementDto.getElementId());
        if(oStudent.getElementList() != null && iStudentElementService.checkElementTypeExist(element.getType(),oStudent.getElementList())) {
            oStudent = iStudentElementService.removeElementAndAddPrice(element.getType(),oStudent);
            studentClient.saveStudent(oStudent);
        }else
            throw new Exception("Error Removing");

    }

    @Override
    public void changeElement(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside changeElement method of ElementEventService ");
        StudentDto oStudent =  studentClient.getStudent(studentElementDto.getStudentNumber());
        ElementDto element = elementClient.getElementById(studentElementDto.getElementId());
        if(oStudent.getElementList() != null && iStudentElementService.checkElementTypeExist(element.getType(),oStudent.getElementList())) {
            oStudent = iStudentElementService.changeElement(
                    iStudentElementService.getMatchingElementType(element.getType(),oStudent.getElementList()),
                    oStudent,
                    element
            );
            studentClient.saveStudent(oStudent);
        }else
            throw new Exception("Error Changing");


    }


}
