package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletComponentScan;
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
    public boolean checkElementTypeExist(String elementType, List<Element> elementList) {
        log.info("Inside checkElementTypeExist method of StudentElementService");

        return elementList.stream().map(Element::getType).filter(elementType::equals).findFirst().isPresent();
    }

    @Override
    public Element removeMatchingElementType(String elementType, Student student) {
        log.info("Inside removeMatchingElementType method of StudentElementService");
        return student.getElementList().stream().filter(element->element.getType().equals(elementType)).findFirst()
                .map(element ->
                {
                    student.getElementList().remove(element);
                    return element;
                }).orElse(null);

    }

    @Override
    public Student addScore(double score, Student student) {
        log.info("Inside addScore method of StudentElementService");
        student.setScore(student.getScore() + score);
        return student;
    }

    @Override
    public Student decreaseScore(double score, Student student) {
        log.info("Inside decreaseScore method of StudentElementService");
        student.setScore(student.getScore() - score);
        return student;
    }

    @Override
    public Element getMatchingElementType(String elementType, List<Element> elementList) {
        log.info("Inside getMatchingElementType method of StudentElementService");
        return elementList.stream().filter(element->element.getType().equals(elementType) ).findAny().orElse(null);
    }


    @Override
    public Student removeElementAndAddPrice(String elementType, Student student) {
        log.info("Inside removeElementAndAddPrice method of StudentElementService");
        Element removedElement =  removeMatchingElementType(elementType,student);
        return  addScore(removedElement.getPrice(),student);
    }


    @Override
    public Student addElementAndReducePrice(Element element, Student student) {
        log.info("Inside addElementAndReducePrice method of StudentElementService");
        student.addElement(element);
        return decreaseScore(element.getPrice(),student);
    }

    @Override
    public Student changeElement(Element oElement, Student student, Element nElement) throws Exception {
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
    public boolean checkElementExist(Element element, List<Element> elementList) {
        return elementList.stream().filter(element::equals).findFirst().isPresent();
    }


}
