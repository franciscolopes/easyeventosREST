package com.francisco.pds2.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codUsuario) {
		Usuario obj = service.find(codUsuario);
		return ResponseEntity.ok().body(obj);

		
	}
}
