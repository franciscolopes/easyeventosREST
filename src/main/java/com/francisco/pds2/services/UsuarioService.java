package com.francisco.pds2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.repositories.UsuarioRepository;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	@Autowired
	private UsuarioRepository usuarioRepo;
	public Usuario find(Integer codUsuario) {
		Usuario obj = usuarioRepo.findOne(codUsuario);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codUsuario
					+ ", Tipo: " + Usuario.class.getName());
		}
		
		return obj;
	}
	
	
}
