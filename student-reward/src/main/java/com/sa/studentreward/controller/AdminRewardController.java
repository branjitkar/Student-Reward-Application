package com.sa.studentreward.controller;

import com.sa.studentreward.dto.StudentRewardDto;
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
@RequestMapping("/student-rewards/admin")
@Slf4j
public class AdminRewardController {
    @Autowired
    private IRewardEventService rewardEventService;

    @PostMapping
    public ResponseEntity<?> adminAdministerRewards(@RequestBody StudentRewardDto studentRewardDto){
        log.info("Inside  adminAdministerRewards method of StudentController");
        try{
            rewardEventService.adminAdministerRewards(studentRewardDto);
        }catch (Exception e){
            System.out.println(e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Transaction Successful", HttpStatus.OK);
    }
}
