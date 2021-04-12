package com.example.emailsnippet.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailSender {

    private final JavaMailSender javaMailSender;

    public void sendMail(EmailMessage message) throws MailException {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(message.getTo());
        simpleMailMessage.setFrom(message.getFrom());
        simpleMailMessage.setSubject(message.getSubject());
        simpleMailMessage.setText(message.getBody());
        simpleMailMessage.setCc(message.getCc());
        try {
            log.info("Sending the email...");
            javaMailSender.send(simpleMailMessage);
            log.info("Email sent");
        } catch (MailException exception) {
            log.error("Couldn't send the email due to an issue", exception);
            throw exception;
        }
    }
}
