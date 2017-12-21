package com.francisco.pds2.services;

import org.springframework.mail.SimpleMailMessage;

import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.Usuario;

public interface EmailService {

	void sendOrderConfirmationEmail(Inscricao obj);
 	
 	void sendEmail(SimpleMailMessage msg);
 	
 	void sendNewPasswordEmail(Usuario usuario, String newPass);
}
