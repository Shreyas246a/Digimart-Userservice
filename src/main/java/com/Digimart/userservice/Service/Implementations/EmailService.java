package com.Digimart.userservice.Service.Implementations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Date;

public class EmailService {
    private final JavaMailSender mailSender;
    @Value("${MAIL_USERNAME}")
    private String fromEmail;
    public EmailService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }
    @Async
    public boolean sendEmail(String to,String subject,String body){
    try {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject(subject);
        message.setText(body);
        message.setTo(to);
        message.setSentDate(Date.from(Instant.now()));
        mailSender.send(message);
        return true;
    }catch (Exception e){
        throw new RuntimeException("Failed to send email: " + e.getMessage());
    }
    }
}
