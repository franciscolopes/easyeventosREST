package com.francisco.pds2.resources;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.dto.AtividadeDTO;
import com.francisco.pds2.dto.AtividadeDTO;
import com.francisco.pds2.services.AtividadeService;

@RestController
@RequestMapping(value="/atividades")
public class AtividadeResource {
	
	@Autowired
	 private AtividadeService service;
	
	@RequestMapping(value="/{codAtividade}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codAtividade) {
		
		Atividade obj = service.buscar(codAtividade);
		return ResponseEntity.ok().body(obj/*.getInscricoes()*/);	
	}
	
	
	@RequestMapping(value = "/{codAtividade}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody AtividadeDTO objDto, @PathVariable Integer codAtividade) {
		Atividade obj = service.fromDTO(objDto);
		obj.setCodAtividade(codAtividade);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{codAtividade}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codAtividade) {
		service.delete(codAtividade);
		return ResponseEntity.noContent().build();
	}
	

	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<AtividadeDTO>> findAll() {
		List<Atividade> list = service.findAll();
		List<AtividadeDTO> listDto = list.stream().map(obj -> new AtividadeDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<AtividadeDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Atividade> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<AtividadeDTO> listDto = list.map(obj -> new AtividadeDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
	
}
