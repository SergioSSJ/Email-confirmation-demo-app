package com.sergiossj.msmail.receivers;

import com.sergiossj.msmail.dtos.UserDto;
import com.sergiossj.msmail.entities.User;
import com.sergiossj.msmail.services.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;

import java.util.concurrent.CountDownLatch;

public class Receiver {

    //private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    private EmailService emailService;

    @KafkaListener(topics = "${spring.kafka.topic.userCreated}")
    public void receive(User payload) {
       // LOGGER.info("received payload='{}'", payload);
        emailService.sendSimpleMessage(payload);
        latch.countDown();
    }
}
