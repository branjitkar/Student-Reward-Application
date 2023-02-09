package com.sa.studentreward.controller;

import com.sa.studentreward.dto.StudentElementDto;
import com.sa.studentreward.dto.StudentRewardDto;
import com.sa.studentreward.service.IElementEventService;
import com.sa.studentreward.service.IRewardEventService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student-rewards/reward/")
@Slf4j
public class StudentRewardController {

    @Autowired
    private IRewardEventService rewardEventService;

    @PostMapping("buy")
    public ResponseEntity<?> buyRewards(@RequestBody StudentRewardDto studentRewardDto){
        log.info("Inside  buyRewards method of StudentController");
        try{
            rewardEventService.buyRewards(studentRewardDto);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Transaction Successful", HttpStatus.OK);
    }
}
