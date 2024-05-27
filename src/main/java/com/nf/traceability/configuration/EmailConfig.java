package com.nf.traceability.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
public class EmailConfig
{
    //datasendernextfirstsfl@gmail.com
    //sendmail@sfldata
    //https://www.google.com/settings/security/lesssecureapps go to site and turn on

    @Bean
    public SimpleMailMessage emailTemplate()
    {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("datasendernextfirstsfl@gmail.com");
        message.setFrom("datasendernextfirstsfl@gmail.com");
        message.setSubject("Important email");
        message.setText("FATAL - Application crash. Save your job !!");
        return message;
    }
}
