package com.francisco.pds2.resources;

import java.io.IOException;
import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.dto.InscricaoNewDTO;
import com.francisco.pds2.services.AtividadeService;
import com.francisco.pds2.services.InscricaoService;
import com.francisco.pds2.services.UsuarioService;
import com.google.zxing.WriterException;

@RestController
@RequestMapping(value = "/inscricoes")
@CrossOrigin
public class InscricaoResource {

	@Autowired
	private InscricaoService inscricaoService;

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AtividadeService atividadeService;
	
	
	
	
	/*-----VALIDA PRESENÇA-------*/
	@RequestMapping(value = "/frequencia", method = RequestMethod.GET)
	public ResponseEntity<String> postFrequencia(@RequestParam(value = "qrcodeString", required = true) String qrcodeString) throws WriterException, IOException {

		int codUsuario = Integer.parseInt(qrcodeString); 
		int codAtividade = 1;
		Usuario usuario = usuarioService.find(codUsuario);
		Atividade atividade = atividadeService.buscar(codAtividade);
		Inscricao inscricao = inscricaoService.find(codUsuario, codAtividade);
		String msg = "";
		if(inscricao != null) {
			inscricao.setPresente(true);
			inscricaoService.marcaPresenca(inscricao);
			msg = "sdfgsd"+inscricao.getPresente()+" Presença do participante "+ usuario.getNome() + " confirmada na atividade "+atividade.getNome()+". Cod inscricao:"+inscricao.getCodigoCertificado() ;
		}else {
			msg = "O usuádio  "+ usuario.getNome() + " não está cadastrado na atividade "+atividade.getNome();
			
		}//o else nao esta funcionando
		
		ResponseEntity<String> responseEntity = new ResponseEntity<>(msg, HttpStatus.OK);
		return responseEntity;

	}
	/*-----VALIDA PRESENÇA-------*/
	
	
	
	
	
	/*------NOVA INSCRICAO--------*/
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InscricaoNewDTO objDto) {
		Inscricao obj = inscricaoService.fromDTO(objDto);
		obj = inscricaoService.insert(obj);
		
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{codAtividade}")
				.buildAndExpand(obj.getAtividade().getCodAtividade()).toUri();
		return ResponseEntity.created(uri).build();
	}
	/*------NOVA INSCRICAO--------*/
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
		List<Inscricao> list = inscricaoService.findAll();
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
		Inscricao obj = inscricaoService.find(codUsuario, codAtividade);
		return obj;
	}

	//URL de teste : http://localhost:8080/inscricoes/teste2?codUsuario=1&codAtividade=1
	/*------------------*/
}
