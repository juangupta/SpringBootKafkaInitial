package com.co.bancolombia.juang.sender;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import com.co.bancolombia.juang.model.User;

@Component
public class Sender {

    private final KafkaTemplate<String, User> kafkaTemplate;

    @Value("${juang.topic}")
    private String topic;

    Sender(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void send(User user) {
        this.kafkaTemplate.send(topic, user);
        System.out.println("Sent sample message [" + user + "] to " + topic);
    }

}
