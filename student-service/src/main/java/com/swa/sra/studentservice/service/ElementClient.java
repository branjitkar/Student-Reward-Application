package com.swa.sra.studentservice.service;

import com.swa.sra.studentservice.domain.Element;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("ElementService")
public interface ElementClient {

    @RequestMapping("/element/{id}")
    public Element getElementById(@PathVariable String id);
}
