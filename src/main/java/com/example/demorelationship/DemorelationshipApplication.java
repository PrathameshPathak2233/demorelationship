package com.example.demorelationship;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

// If application want to execute cron jobs or its executing real time jobs then you have to use @EnableScheduing

@EnableScheduling
@SpringBootApplication
public class DemorelationshipApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemorelationshipApplication.class, args);
		// Prath please add your code here
	}

}
// mail sever --HOw I can send automatice mail to user
// HOw we can configure mail sever
// What are different properties are require?
// What code is requires to send mail to user
// Sender, Receiver, Subject , BOdy, message, attachment
// As part of cron job execution we will send the mails