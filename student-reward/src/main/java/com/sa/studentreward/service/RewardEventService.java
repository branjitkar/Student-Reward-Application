package com.sa.studentreward.service;

import com.sa.studentreward.dto.*;
import com.sa.studentreward.event.IStudentRewardService;
import com.sa.studentreward.feign.RewardClient;
import com.sa.studentreward.feign.StudentClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RewardEventService implements  IRewardEventService{

    @Autowired
    private StudentClient studentClient;

    @Autowired
    private RewardClient rewardClient;

    @Autowired
    private IStudentElementService iStudentElementService;


    @Override
    public void buyRewards(StudentRewardDto studentRewardDto) throws Exception {
        log.info("Inside buyRewards method of ElementEventService ");
        StudentDto oStudent =  studentClient.getStudent(studentRewardDto.getStudentNumber());
//        Reward reward = rewardClient.getById(studentRewardDto.getRewardId());
        Reward reward = studentRewardDto.getReward();

        if(oStudent.getRewardList() !=null && iStudentElementService.checkRewardTypeExist(reward.getType().toString(),oStudent.getRewardList())){

               Reward removedReward = oStudent.getRewardList().stream().filter(element->element.getType().value.equals(reward.getType().toString())).findFirst()
                        .map(element ->
                        {
                            oStudent.getRewardList().remove(element);
                            return element;
                        }).orElse(null);
               oStudent.setScore(oStudent.getScore()+reward
                       .getPrice());

               if(oStudent.getScore() >= reward.getPrice()) {
                   if(reward.getType() != RewardType.ELEMENT && reward.getQuantity() > 0) {
                       oStudent.addReward(reward);
                       oStudent.setScore(oStudent.getScore()-reward
                               .getPrice());

                   }else throw new Exception("Not Sufficient Quantity");
               } else throw new Exception("Not Sufficient Score");

            }else{
                oStudent.addReward(reward);
                oStudent.setScore(oStudent.getScore()-reward
                        .getPrice());

            }
            studentClient.saveStudent(oStudent);
            if(reward.getType() != RewardType.ELEMENT){
                reward.setQuantity(reward.getQuantity() - 1);
                rewardClient.saveReward(reward);
            }

    }

    @Override
    public void adminAdministerRewards(StudentRewardDto studentRewardDto) throws Exception {
        log.info("Inside adminAdministerRewards method of ElementEventService ");
        StudentDto oStudent =  studentClient.getStudent(studentRewardDto.getStudentNumber());
        Reward reward = studentRewardDto.getReward();

        if(oStudent.getRewardList() !=null && iStudentElementService.checkRewardTypeExist(reward.getType().toString(),oStudent.getRewardList())){

            Reward removedReward = oStudent.getRewardList().stream().filter(element->element.getType().value.equals(reward.getType().toString())).findFirst()
                    .map(element ->
                    {
                        oStudent.getRewardList().remove(element);
                        oStudent.setScore(oStudent.getScore()+reward
                                .getPrice());
                        return element;
                    }).orElse(null);
            if(reward.getType() != RewardType.ELEMENT && reward.getQuantity() > 0) {
                    oStudent.addReward(reward);

                    reward.setQuantity(reward.getQuantity() - 1);
                    rewardClient.saveReward(reward);
                }else throw new Exception("Not Sufficient Quantity");
        }else{
            oStudent.addReward(reward);
        }
        studentClient.saveStudent(oStudent);


    }
}
