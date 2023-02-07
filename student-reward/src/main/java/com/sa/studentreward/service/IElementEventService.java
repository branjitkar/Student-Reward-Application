package com.sa.studentreward.service;

import com.sa.studentreward.dto.StudentElementDto;
import com.sa.studentreward.dto.StudentRewardDto;


public interface IElementEventService {

    void buyElements(StudentElementDto studentElementDto) throws Exception;

    void removeElements(StudentElementDto studentElementDto) throws Exception;

    void changeElement(StudentElementDto studentElementDto) throws Exception;


}
