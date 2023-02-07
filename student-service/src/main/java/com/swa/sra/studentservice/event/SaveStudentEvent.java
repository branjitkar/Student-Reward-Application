package com.swa.sra.studentservice.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SaveStudentEvent {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void send(String message){
        log.info("Inside send method of SaveStudentEvent");
        kafkaTemplate.send("studentAddedEvent",message);
    }

}
