package com.francisco.pds2.services;

import org.springframework.mail.SimpleMailMessage;

import com.francisco.pds2.domain.Inscricao;

public interface EmailService {

	void sendOrderConfirmationEmail(Inscricao obj);
 	
 	void sendEmail(SimpleMailMessage msg);
}
