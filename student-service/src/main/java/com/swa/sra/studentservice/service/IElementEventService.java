package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.dto.StudentElementDto;
import com.swa.sra.studentservice.dto.StudentRewardDto;

public interface IElementEventService {

    void buyElements(StudentElementDto studentElementDto) throws Exception;

    void removeElements(StudentElementDto studentElementDto) throws Exception;

    void changeElement(StudentElementDto studentElementDto) throws Exception;

    void buyRewards(StudentRewardDto studentRewardDto);
}
