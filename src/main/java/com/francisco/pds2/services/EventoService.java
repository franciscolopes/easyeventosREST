package com.francisco.pds2.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.dto.EventoDTO;
import com.francisco.pds2.repositories.EventoRepository;
import com.francisco.pds2.services.exceptions.DataIntegrityException;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class EventoService {

	@Autowired
	private EventoRepository eventoRepo;// automaticamente instanciada pelo spring por causa da anotação autowired

	public Evento find(Integer codEvento) {
		Evento obj = eventoRepo.findOne(codEvento);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código: " + codEvento + ", Tipo: " + Evento.class.getName());
		}

		return obj;
	}

	public Evento insert(Evento obj) {
		obj.setCodEvento(null);
		return eventoRepo.save(obj);
	}

	public Evento update(Evento obj) {
		Evento newObj = find(obj.getCodEvento());
		updateData(newObj, obj);
		return eventoRepo.save(newObj);
	}

	public void delete(Integer codEvento) {
		find(codEvento);
		try {
			eventoRepo.delete(codEvento);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um evento que possui atividades");
		}
	}

	public List<Evento> findAll() {
		return eventoRepo.findAll();
	}

	public Page<Evento> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return eventoRepo.findAll(pageRequest);
	}

	public Evento fromDTO(EventoDTO objDto) {
		return new Evento(objDto.getCodEvento(), objDto.getNome(), objDto.getDataInicio(), objDto.getDataFim(), objDto.getDescricao());
	}

	
	/*estava alterando apenas o nome, acrescentei alteração de datas e descrição*/
	private void updateData(Evento newObj, Evento obj) {
		newObj.setNome(obj.getNome());
		newObj.setDataInicio(obj.getDataInicio());
		newObj.setDataFim(obj.getDataFim());
		newObj.setDescricao(obj.getDescricao());
	}
}