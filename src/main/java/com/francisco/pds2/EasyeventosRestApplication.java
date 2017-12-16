package com.francisco.pds2;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.repositories.UsuarioRepository;

@SpringBootApplication
public class EasyeventosRestApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(EasyeventosRestApplication.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		Usuario usuario1 = new Usuario(null, "joao", "email", "cpf");
		Usuario usuario2 = new Usuario(null, "ana", "email", "cpf");
		usuarioRepository.save(Arrays.asList(usuario1, usuario2));
	}
}
