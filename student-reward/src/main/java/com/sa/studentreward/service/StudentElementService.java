package com.sa.studentreward.service;

import com.sa.studentreward.dto.ElementDto;
import com.sa.studentreward.dto.Reward;
import com.sa.studentreward.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class StudentElementService implements  IStudentElementService {


    @Override
    public boolean checkSufficientScore(double elementPrice, double studentAvailableScore) {
        log.info("Inside checkSufficientScore method of StudentElementService");
        return studentAvailableScore > elementPrice;
    }

    @Override
    public boolean checkElementTypeExist(String elementType, List<ElementDto> elementList) {
        log.info("Inside checkElementTypeExist method of StudentElementService");

        return elementList.stream().map(ElementDto::getType).filter(elementType::equals).findFirst().isPresent();
    }

    @Override
    public ElementDto removeMatchingElementType(String elementType, StudentDto student) {
        log.info("Inside removeMatchingElementType method of StudentElementService");
        return student.getElementList().stream().filter(element->element.getType().equals(elementType)).findFirst()
                .map(element ->
                {
                    student.getElementList().remove(element);
                    return element;
                }).orElse(null);

    }

    @Override
    public StudentDto addScore(double score, StudentDto student) {
        log.info("Inside addScore method of StudentElementService");
        student.setScore(student.getScore() + score);
        return student;
    }

    @Override
    public StudentDto decreaseScore(double score, StudentDto student) {
        log.info("Inside decreaseScore method of StudentElementService");
        student.setScore(student.getScore() - score);
        return student;
    }

    @Override
    public ElementDto getMatchingElementType(String elementType, List<ElementDto> elementList) {
        log.info("Inside getMatchingElementType method of StudentElementService");
        return elementList.stream().filter(element->element.getType().equals(elementType) ).findAny().orElse(null);
    }


    @Override
    public StudentDto removeElementAndAddPrice(String elementType, StudentDto student) {
        log.info("Inside removeElementAndAddPrice method of StudentElementService");
        ElementDto removedElement =  removeMatchingElementType(elementType,student);
        return  addScore(removedElement.getPrice(),student);
    }


    @Override
    public StudentDto addElementAndReducePrice(ElementDto element, StudentDto student) {
        log.info("Inside addElementAndReducePrice method of StudentElementService");
        student.addElement(element);
        return decreaseScore(element.getPrice(),student);
    }

    @Override
    public StudentDto changeElement(ElementDto oElement, StudentDto student, ElementDto nElement) throws Exception {
        log.info("Inside changeElement method of StudentElementService");
        student = removeElementAndAddPrice(oElement.getType(),student);
        if(student.getScore() > nElement.getPrice())
        {
            student = addElementAndReducePrice(nElement,student);
            return  student;
        }
        else
            throw  new Exception("No Sufficient Score");
    }

    @Override
    public boolean checkElementExist(ElementDto element, List<ElementDto> elementList) {
        return elementList.stream().filter(element::equals).findFirst().isPresent();
    }

    @Override
    public boolean checkRewardTypeExist(String elementType, List<Reward> elementList) {
        return elementList.stream().map(Reward::getType).filter(elementType::equals).findFirst().isPresent();

    }


}
