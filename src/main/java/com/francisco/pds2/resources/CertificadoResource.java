package com.francisco.pds2.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.services.AtividadeService;
import com.francisco.pds2.services.EventoService;
import com.francisco.pds2.services.InscricaoService;
import com.francisco.pds2.services.UsuarioService;

@RestController
@RequestMapping(value = "/certificado")
@CrossOrigin
public class CertificadoResource {

	@Autowired
	private InscricaoService inscricaoService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AtividadeService atividadeService;

	@Autowired
	private EventoService eventoService;
	
	int presencaReal=0;
	
	@RequestMapping(value = "/mostrar")
	public String certificado() {
		
		String msg = "";
		int codEvento = 1;
		Evento evento = eventoService.find(codEvento);
		
		int presencaMinimaEvento = evento.getPresencaMinima();
		List<Inscricao> inscricoes = inscricaoService.findAll();//precisa ser as inscrições do usuario apenas
		
		
		
		/*for(int i=0; i<inscricoes.size(); i++) {
			if(inscricoes.get(i).getPresente().equals(false)) {
				presencaReal = presencaReal + 1;
			}
		}*/
		
		//parece que nao esta entrando no for
		for(Inscricao x : inscricoes){
			if (x.getPresente().equals(true)){
				presencaReal=presencaReal+1;
			}
		}
		//presencaReal=inscricoes.size();
		//ao inves de mostrar mensagem deve redirecionar para pagina de certificado, ou fazer o download
		if(presencaReal>=presencaMinimaEvento) {
			msg = "Deve receber certificado "+presencaReal+"  "+inscricoes.get(1).getAtividade().getNome();
		}else {
			msg = "Sem direito a certificado "+presencaReal+inscricoes.get(3).getAtividade().getNome();
		}
		
		
		return msg;

		
		
	}
	
	
	
	
	
	
	

}