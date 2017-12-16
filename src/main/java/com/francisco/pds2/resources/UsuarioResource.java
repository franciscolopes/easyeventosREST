package com.francisco.pds2.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Usuario;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioResource {

	@RequestMapping(method = RequestMethod.GET)
	public List<Usuario> listar() {
		 		
		 	
		 		
		 		Usuario e1 = new Usuario (1,"nome","email","cpf"); 
		 		
		 		Usuario e2 = new Usuario (1,"nome2","email2","cpf2"); 
		 		
		 		List<Usuario>  lista = new ArrayList<>();
		 		lista.add(e1);
		 		lista.add(e2);
		 		return lista;
	}
}
