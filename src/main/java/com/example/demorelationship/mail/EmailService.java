package com.example.demorelationship.mail;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service      // Its an annotation is used -- to define on the classes which may contain business logic
public class EmailService {


    // JavaMailSender which we will use
    // How I can write the code to send the mail


    @Autowired
    JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    public String fromMail;

    public void sendmail() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(fromMail);
        mailMessage.setTo("pathakprathamesh1@gmail.com","patilj203@gmail.com");
        mailMessage.setSubject("TestMail1234");
        mailMessage.setText("Hello from Spring boot mail server12345");
        javaMailSender.send(mailMessage);

    }

}
