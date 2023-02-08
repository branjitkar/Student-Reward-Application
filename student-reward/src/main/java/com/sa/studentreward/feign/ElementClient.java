package com.sa.studentreward.feign;

import com.sa.studentreward.dto.ElementDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.text.Element;

@FeignClient("ElementService")
public interface ElementClient {

    @RequestMapping("/element/{id}")
    public ElementDto getElementById(@PathVariable String id);
}
