package com.francisco.pds2.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.dto.UsuarioDTO;
import com.francisco.pds2.dto.UsuarioNewDTO;
import com.francisco.pds2.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
@CrossOrigin
public class UsuarioResource {

	@Autowired
	private UsuarioService service;

	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer codUsuario) {

		Usuario obj = service.find(codUsuario);
		return ResponseEntity.ok().body(obj);

	}
	
	
	
	/*------NOVO USUARIO--------*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody UsuarioNewDTO objDto) {
		Usuario obj = service.fromDTO(objDto);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codUsuario}")
				.buildAndExpand(obj.getCodUsuario()).toUri();
		return ResponseEntity.created(uri).build();
	}
	/*------NOVO USUARIO--------*/
	
	
	
	
	

	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody UsuarioDTO objDto, @PathVariable Integer codUsuario) {
		Usuario obj = service.fromDTO(objDto);
		obj.setCodUsuario(codUsuario);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{codUsuario}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer codUsuario) {
		service.delete(codUsuario);
		return ResponseEntity.noContent().build();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		List<Usuario> list = service.findAll();
		List<UsuarioDTO> listDto = list.stream().map(obj -> new UsuarioDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<UsuarioDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Usuario> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<UsuarioDTO> listDto = list.map(obj -> new UsuarioDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
}
