package com.swa.sra.studentcommand.Integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaSender {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    public void send(String topic, Message<?> message){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String messageString = objectMapper.writeValueAsString(message);
            kafkaTemplate.send(topic , messageString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
