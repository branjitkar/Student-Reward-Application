package com.sa.studentreward.service;

import com.sa.studentreward.dto.ElementDto;
import com.sa.studentreward.dto.Reward;
import com.sa.studentreward.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IStudentElementService {

//    checked if there is enough score for the student to spend to buy that element
    boolean checkSufficientScore(double elementPrice,double studentAvailableScore);

    boolean checkElementTypeExist(String elementType, List<ElementDto> elementList);

    ElementDto  removeMatchingElementType(String elementType, StudentDto student);

    StudentDto addScore(double score ,StudentDto student);

    StudentDto decreaseScore(double score ,StudentDto student);

    ElementDto  getMatchingElementType(String elementType, List<ElementDto> elementList);

    /*remove the previously purchased element from their avatar and add
     its price back to the student score*/
    StudentDto  removeElementAndAddPrice(String elementType, StudentDto student);

    //add element to student list and subtract the student score
    StudentDto  addElementAndReducePrice(ElementDto element, StudentDto student);

    StudentDto  changeElement(ElementDto oElement, StudentDto student,ElementDto nElement) throws Exception;


    boolean checkElementExist(ElementDto element, List<ElementDto> elementList);

   boolean  checkRewardTypeExist(String elementType, List<Reward> elementList);

}
