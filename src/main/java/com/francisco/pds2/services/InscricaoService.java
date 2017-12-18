package com.francisco.pds2.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.InscricaoPK;
import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.repositories.AtividadeRepository;
import com.francisco.pds2.repositories.InscricaoRepository;
import com.francisco.pds2.repositories.UsuarioRepository;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class InscricaoService {

	@Autowired
	private InscricaoRepository inscricaoRepo;
	
	@Autowired
	private AtividadeRepository atividadeRepo;
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	/*public Inscricao find(Integer usuario_id, Integer atividade_id) {
		Inscricao obj = inscricaoRepo.findById(usuario_id, atividade_id);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código: " + usuario_id + "e" + atividade_id + ", Tipo: " + Inscricao.class.getName());
		}

		return obj;
	}*/
	
	
	
	
	public Inscricao find(Integer codUsuario, Integer codAtividade) {
		Usuario usuario = usuarioRepo.findOne(codUsuario);
		Atividade atividade = atividadeRepo.findOne(codAtividade);
		Inscricao obj = inscricaoRepo.findOne(new InscricaoPK(usuario, atividade));
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código, Tipo: " + Inscricao.class.getName());
		}

		return obj;
	}
	
	

	public List<Inscricao> findAll() {
		return inscricaoRepo.findAll();
	}
	/*------BUSCA INSCRIÇÕES POR EVENTO--------
	public Page<Inscricao> search(Integer codEvento, Integer page, Integer linesPerPage, String orderBy, String direction) {
		 		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		 		//List<Inscricao> inscricroes = inscricaoRepo.findAll(ids);
		 		return inscricaoRepo.findBycodEvento(codEvento, pageRequest);	
		 	}
	/*------BUSCA INSCRIÇÕES POR EVENTO--------*/
	
	

}