package com.kafka.producer.controller;

import com.kafka.producer.response.ResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/kafka/producer")
public class ProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public ProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping(path = "/")
    public ResponseDTO getResult(){
        System.out.println("ENDPOINT");
        kafkaTemplate.send("Menes", "Menes");
        return new ResponseDTO("enes", "sahin", 10);
    }

}
