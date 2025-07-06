package com.example.demorelationship.cronjobs;

import com.example.demorelationship.mail.EmailService;
import com.example.demorelationship.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class RealTimeJob
{


    @Value("${demoName}")
    public String demoName;

    @Autowired
    StudentRepository studentRepository;

    @Autowired
    EmailService emailService;

    @Scheduled(cron = "${job.cron.expression}")
    public void executeJob()
    {
        System.out.println("Hello to all from real time job");
        System.out.println(studentRepository.findById(1L).get().getAddress());
        System.out.println(demoName);
        System.out.println("Sending mail to user");
        emailService.sendmail();
    }
}
