package com.codjavando.project.api.service.starter;

import com.codjavando.project.api.model.Email;
import com.codjavando.project.api.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@Slf4j
@EnableBinding(Sink.class)
public class EmailStarter {

    @Autowired
    private EmailService service;

    @StreamListener("input")
    public void consumeMessage(Email email) {
        log.info("Consume payload: " + email);
        service.sendEmail(email);
    }

}
