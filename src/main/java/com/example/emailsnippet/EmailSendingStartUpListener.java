package com.example.emailsnippet;

import com.example.emailsnippet.config.email.EmailSender;
import com.example.emailsnippet.model.EmailMessage;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@AllArgsConstructor
public class EmailSendingStartUpListener {

    private final EmailMessage demoEmailMessage;
    private final EmailSender emailSender;

    @EventListener(ApplicationReadyEvent.class)
    public void onApplicationReady() {
        emailSender.sendMail(demoEmailMessage);
    }
}
