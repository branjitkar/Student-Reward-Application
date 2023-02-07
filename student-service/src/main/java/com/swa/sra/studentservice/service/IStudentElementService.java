package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Element;
import com.swa.sra.studentservice.domain.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentElementService {

//    checked if there is enough score for the student to spend to buy that element
    boolean checkSufficientScore(double elementPrice,double studentAvailableScore);

    boolean checkElementTypeExist(String elementType, List<Element> elementList);

    Element  removeMatchingElementType(String elementType, Student student);

    Student addScore(double score ,Student student);

    Student decreaseScore(double score ,Student student);

    Element  getMatchingElementType(String elementType, List<Element> elementList);

    /*remove the previously purchased element from their avatar and add
     its price back to the student score*/
    Student  removeElementAndAddPrice(String elementType, Student student);

    //add element to student list and subtract the student score
    Student  addElementAndReducePrice(Element element, Student student);

    Student  changeElement(Element oElement, Student student,Element nElement) throws Exception;


    boolean checkElementExist(Element element, List<Element> elementList);

}
