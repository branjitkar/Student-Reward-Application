package com.sa.studentreward.event;

import com.sa.studentreward.dto.StudentDto;
import com.sa.studentreward.event.IStudentRewardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StudentRewardService implements IStudentRewardService {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Override
    public void updateStudent(StudentDto studentDto) {
        log.info("Inside send method of SaveStudentEvent");
        kafkaTemplate.send("studentUpdatedEvent",studentDto.toString());

    }
}
