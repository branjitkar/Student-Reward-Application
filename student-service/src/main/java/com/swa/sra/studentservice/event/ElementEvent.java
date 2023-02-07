package com.swa.sra.studentservice.event;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.swa.sra.studentservice.domain.Student;
import com.swa.sra.studentservice.dto.StudentElementDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ElementEvent {


//    @KafkaListener(topics = {"studentUpdatedEvent"})
//    public void receiveBuyElement(@Payload Student student){
//
//       // JsonNode data = new ObjectMapper().readTree(studentElementDto);
//        System.out.println("Message Received==== " + student.toString());
//    }
}
