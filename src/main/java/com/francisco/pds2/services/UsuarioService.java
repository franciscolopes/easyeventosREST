package com.francisco.pds2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;
	public Usuario find(Integer codUsuario) {
		Usuario obj = usuarioRepo.findOne(codUsuario);
		return obj;
	}
	
	
}
