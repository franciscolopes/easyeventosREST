package com.francisco.pds2.resources;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.dto.EventoDTO;
import com.francisco.pds2.services.EventoService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.data.domain.Page;
import javax.validation.Valid;

@RestController
@RequestMapping(value = "/eventos")
public class EventoResource {

	@Autowired
	private EventoService service;

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.GET)
	public ResponseEntity<Evento> find(@PathVariable Integer codEvento) {

		Evento obj = service.find(codEvento);
		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody EventoDTO objDto) {
		Evento obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codEvento}")
				.buildAndExpand(obj.getCodEvento()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody EventoDTO objDto, @PathVariable Integer codEvento) {
		Evento obj = service.fromDTO(objDto);
		obj.setCodEvento(codEvento);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{codEvento}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codEvento) {
		service.delete(codEvento);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EventoDTO>> findAll() {
		List<Evento> list = service.findAll();
		List<EventoDTO> listDto = list.stream().map(obj -> new EventoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<EventoDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Evento> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<EventoDTO> listDto = list.map(obj -> new EventoDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}
	

}
