package com.example.emailsnippet.config.email;

import com.example.emailsnippet.model.EmailMessage;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MessageConfigurations {

    @Value("${application.email.messages.demoMessage.from}")
    private String fromEmail;

    @Value("${application.email.messages.demoMessage.to}")
    private String[] toEmails;

    @Value("${application.email.messages.demoMessage.cc}")
    private String[] ccEmails;

    @Value("${application.email.messages.demoMessage.subject}")
    private String subject;

    @Value("${application.email.messages.demoMessage.body}")
    private String body;

    @Bean
    public EmailMessage demoEmailMessage() {
        return EmailMessage
                .builder()
                .from(fromEmail)
                .to(toEmails)
                .cc(ccEmails)
                .subject(subject)
                .body(body)
                .build();
    }
}
