package com.example.emailsnippet.config.email;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class EmailServerConfigurations {

    @Value("${application.email.server.host}")
    private String serverHost;

    @Value("${application.email.server.port}")
    private int serverPort;

    @Value("${application.email.server.username}")
    private String serverUsername;

    @Value("${application.email.server.password}")
    private String serverPassword;

    @Bean
    JavaMailSender javaMailSender() {
        JavaMailSenderImpl javaMailSender = new JavaMailSenderImpl();
        javaMailSender.setHost(serverHost);
        javaMailSender.setPort(serverPort);
        Properties properties = javaMailSender.getJavaMailProperties();
        if (!serverUsername.isBlank() && !serverPassword.isBlank()) {
            javaMailSender.setUsername(serverUsername);
            javaMailSender.setPassword(serverPassword);
            properties.put("mail.smtp.auth", "true");
            properties.put("mail.smtp.starttls.enable", "true");
        }
        properties.put("mail.transport.protocol", "smtp");
        properties.put("mail.debug", "true");
        return javaMailSender;
    }
}
