package com.sa.studentreward.feign;

import com.sa.studentreward.config.FeignConfig;
import com.sa.studentreward.dto.StudentDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.swing.text.Element;

@FeignClient(name = "StudentService", configuration = FeignConfig.class)
public interface StudentClient {

    @RequestMapping("/students/{studentNumber}")
    public StudentDto getStudent(@PathVariable String studentNumber);

    @RequestMapping(value = "/students/" ,method = RequestMethod.POST)
    public void saveStudent(@RequestBody StudentDto studentDto);
}
