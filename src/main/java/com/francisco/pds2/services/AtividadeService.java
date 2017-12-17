package com.francisco.pds2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.repositories.AtividadeRepository;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository atividadeRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Atividade buscar(Integer codAtividade) {
		Atividade obj = atividadeRepo.findOne(codAtividade);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codAtividade
					+ ", Tipo: " + Atividade.class.getName());
		}
		
		return obj;
	}
	
	public List<Atividade> findAll() {
		return atividadeRepo.findAll();
	}
	
}
