package com.example.emailsnippet;

import com.example.emailsnippet.model.EmailMessage;
import com.example.emailsnippet.model.EmailSender;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
public class EmailSendingStartUpListener {

    private final EmailMessage demoEmailMessage;
    private final EmailSender emailSender;

    public EmailSendingStartUpListener(EmailMessage demoEmailMessage, EmailSender emailSender) {
        this.demoEmailMessage = demoEmailMessage;
        this.emailSender = emailSender;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        emailSender.sendMail(demoEmailMessage);
    }
}
