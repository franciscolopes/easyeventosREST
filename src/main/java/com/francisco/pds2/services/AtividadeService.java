package com.francisco.pds2.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.dto.EventoDTO;
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
	
	
	public Page<Atividade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return atividadeRepo.findAll(pageRequest);
	}

	/*public Atividade fromDTO(AtividadeDTO objDto) {
		return new Atividade(objDto.getCodEvento(), objDto.getNome(), objDto.getDataInicio(), objDto.getDataFim(), objDto.getDescricao());
	}*/
	
	
}
