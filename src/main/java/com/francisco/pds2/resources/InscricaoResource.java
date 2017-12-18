package com.francisco.pds2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.services.InscricaoService;

@RestController
@RequestMapping(value = "/inscricoes")
public class InscricaoResource {

	@Autowired
	private InscricaoService service;

	/*
	 * @RequestMapping(value="/{usuario_id}/conf/{atividade_id}",
	 * method=RequestMethod.GET) public ResponseEntity<?> find(@PathVariable Integer
	 * usuario_id, @PathVariable Integer atividade_id) {
	 * 
	 * 
	 * Inscricao obj = service.find(usuario_id, atividade_id); return
	 * ResponseEntity.ok().body(obj); }
	 */

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Inscricao>> findAll() {
		List<Inscricao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	/*@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ResponseEntity<Inscricao> find() {

		Inscricao obj = service.find();
		return ResponseEntity.ok().body(obj);
	}*/

	/*------------------*/
	@RequestMapping("/teste2")
	public @ResponseBody Inscricao getInscricao(@RequestParam int codUsuario, @RequestParam int codAtividade) {
		Inscricao obj = service.find(codUsuario, codAtividade);
		return obj;
	}

	//URL de teste : http://localhost:8080/inscricoes/teste2?codUsuario=1&codAtividade=1
	/*------------------*/
}
