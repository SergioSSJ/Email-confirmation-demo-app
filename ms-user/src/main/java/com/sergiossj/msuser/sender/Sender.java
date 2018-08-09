package com.sergiossj.msuser.sender;

import com.sergiossj.msuser.entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    public void send(String topic, User payload) {
        System.out.println("SENDING PAYLOAD"+payload+topic);
      //  LOGGER.info("Sending to topic: " + topic + " and payload:" + payload);
        kafkaTemplate.send(topic, payload);
    }
}
