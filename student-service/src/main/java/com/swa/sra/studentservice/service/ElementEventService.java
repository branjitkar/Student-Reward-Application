package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentElementDto;
import com.swa.sra.studentservice.dto.StudentRewardDto;
import com.swa.sra.studentservice.repository.IStudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
public class ElementEventService implements  IElementEventService {

    @Autowired
    private IStudentRepository iStudentRepository;

    @Autowired
    private IStudentElementService iStudentElementService;
    @Autowired
    private ElementClient elementClient;

    @Autowired
    private  IStudentService iStudentService;
    @Override
    public void buyElements(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside buyElements method of ElementEventService ");
        Student oStudent = iStudentService.getStudentByStudentNumber(studentElementDto.getStudentNumber());
        Element element =elementClient.getElementById(studentElementDto.getElementId());
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
            iStudentRepository.save(oStudent);
        }else {
            throw  new Exception("Score Not Sufficient");
        }

    }

    @Override
    public void removeElements(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside removeElements method of ElementEventService ");
        Student oStudent = iStudentService.getStudentByStudentNumber(studentElementDto.getStudentNumber());
        Element element =elementClient.getElementById(studentElementDto.getElementId());
        if(oStudent.getElementList() != null && iStudentElementService.checkElementExist(element,oStudent.getElementList())) {
            oStudent = iStudentElementService.removeElementAndAddPrice(element.getType(),oStudent);
            iStudentRepository.save(oStudent);
        }else
            throw new Exception("Error Removing");

    }

    @Override
    public void changeElement(StudentElementDto studentElementDto) throws Exception {
        log.info("Inside changeElement method of ElementEventService ");
        Student oStudent = iStudentService.getStudentByStudentNumber(studentElementDto.getStudentNumber());
        Element element = elementClient.getElementById(studentElementDto.getElementId());
        oStudent = iStudentElementService.changeElement(
                iStudentElementService.getMatchingElementType(element.getType(),oStudent.getElementList()),
                oStudent,
                element
        );
        iStudentRepository.save(oStudent);
    }

    @Override
    public void buyRewards(StudentRewardDto studentRewardDto) {
        log.info("Inside buyRewards method of ElementEventService ");
    }
}
