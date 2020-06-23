package com.codjavando.project.api.service;

import com.codjavando.project.api.model.Email;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void sendEmail(Email email) {
        String myEmail = "emailtestapimeeting@gmail.com";
        String myPassword = "001122bb";

        SimpleEmail simpleEmail = new SimpleEmail();
        simpleEmail.setHostName("smtp.gmail.com");
        simpleEmail.setSmtpPort(587);
        simpleEmail.setAuthenticator(new DefaultAuthenticator(myEmail, myPassword));
        simpleEmail.setSSLOnConnect(true);

        try {
            simpleEmail.setFrom(myEmail);
            simpleEmail.setSubject("Confirmation Presence");
            simpleEmail.setMsg("Hi, " + email.getName() + "\nYou confirmed your presence at the meeting. Thank you!");
            simpleEmail.addTo(email.getEmail());
            simpleEmail.send();
            log.info("Successfully sent!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
