package com.francisco.pds2.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.repositories.AtividadeRepository;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class AtividadeService {
	
	@Autowired
	private AtividadeRepository eventoRepo;//automaticamente instanciada pelo spring por causa da anotação autowired
	public Atividade buscar(Integer codAtividade) {
		Atividade obj = eventoRepo.findOne(codAtividade);
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código: " + codAtividade
					+ ", Tipo: " + Atividade.class.getName());
		}
		
		return obj;
	}
}
