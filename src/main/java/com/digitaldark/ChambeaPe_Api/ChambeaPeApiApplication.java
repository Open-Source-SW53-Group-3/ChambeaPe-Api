package com.digitaldark.ChambeaPe_Api;

import com.digitaldark.ChambeaPe_Api.shared.service.impl.EmailSenderServiceImpl;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class ChambeaPeApiApplication {
	@Autowired
	EmailSenderServiceImpl emailSenderService;

	public static void main(String[] args) {
		SpringApplication.run(ChambeaPeApiApplication.class, args);
	}
}
