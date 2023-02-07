package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Element;

public interface IAvatarService {


    void applyElements(String studentNumber, Element element) throws Exception;
}
