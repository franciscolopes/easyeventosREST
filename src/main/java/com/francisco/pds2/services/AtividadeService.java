package com.francisco.pds2.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.domain.Local;
import com.francisco.pds2.dto.AtividadeDTO;
import com.francisco.pds2.dto.AtividadeNewDTO;
import com.francisco.pds2.repositories.AtividadeRepository;
import com.francisco.pds2.repositories.EventoRepository;
import com.francisco.pds2.repositories.LocalRepository;
import com.francisco.pds2.services.exceptions.DataIntegrityException;
import com.francisco.pds2.services.exceptions.ObjectNotFoundException;

@Service
public class AtividadeService {

	@Autowired
	private AtividadeRepository atividadeRepo;// automaticamente instanciada pelo spring por causa da anotação autowired

	@Autowired
	private EventoRepository eventoRepo;

	@Autowired
	private LocalRepository localRepo;

	public Atividade buscar(Integer codAtividade) {
		Atividade obj = atividadeRepo.findOne(codAtividade);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! código: " + codAtividade + ", Tipo: " + Atividade.class.getName());
		}

		return obj;
	}

	/*--------INSERT--------*/
	public Atividade insert(Atividade obj) {
		//obj.setCodAtividade(null);
		obj = atividadeRepo.save(obj);
		
		return obj;
	}

	/*--------INSERT--------*/
	
	
	public List<Atividade> findAll() {
		return atividadeRepo.findAll();
	}

	public Page<Atividade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return atividadeRepo.findAll(pageRequest);
	}

	public Atividade fromDTO(AtividadeDTO objDto) {

		return new Atividade(objDto.getCodAtividade(), objDto.getNome(), objDto.getMinistrante(),
				objDto.getHorarioInicio(), objDto.getHorarioFim(), objDto.getDataInicio(), objDto.getDataFim(),
				objDto.getDescricao(), objDto.getNroVagas(), objDto.getTipoAtividade(), objDto.getInscricaoAberta(),
				objDto.getAtividadeAtiva(), null);

	}

	
	/*------INSERT NOVA ATIVIDADE--------*/
	public Atividade fromDTO(AtividadeNewDTO objDto) {

		Evento evento = eventoRepo.findOne(objDto.getCodEvento());
		Local local = localRepo.findOne(objDto.getCodLocal());
		Atividade atividade = new Atividade(null, objDto.getNome(), objDto.getMinistrante(),
				objDto.getHorarioInicio(), objDto.getHorarioFim(), objDto.getDataInicio(),
				objDto.getDataFim(), objDto.getDescricao(), objDto.getNroVagas(),
				objDto.getTipoAtividade(), objDto.getInscricaoAberta(), objDto.getAtividadeAtiva(), evento);

		//atividadeRepo.save(atividade);
		
		atividade.setLocal(local);
		
		atividadeRepo.save(atividade);
		local.setAtividade(atividade);
		localRepo.save(local);
		
		evento.getAtividades().addAll(Arrays.asList(atividade));
	
		return atividade;
	}
	/*------INSERT NOVA ATIVIDADE--------*/

	public Atividade update(Atividade obj) {
		Atividade newObj = buscar(obj.getCodAtividade());
		updateData(newObj, obj);
		return atividadeRepo.save(newObj);
	}

	private void updateData(Atividade newObj, Atividade obj) {

		newObj.setNome(obj.getNome());
		newObj.setMinistrante(obj.getMinistrante());
		newObj.setHorarioInicio(obj.getHorarioInicio());
		newObj.setHorarioFim(obj.getHorarioFim());
		newObj.setDataInicio(obj.getDataInicio());
		newObj.setDataFim(obj.getDataFim());
		newObj.setDescricao(obj.getDescricao());
		newObj.setNroVagas(obj.getNroVagas());
		newObj.setTipoAtividade(obj.getTipoAtividade());
		newObj.setInscricaoAberta(obj.getInscricaoAberta());
		newObj.setAtividadeAtiva(obj.getAtividadeAtiva());
	}

	public void delete(Integer codAtividade) {
		buscar(codAtividade);
		try {
			atividadeRepo.delete(codAtividade);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir pois há entidades relacionadas");
		}
	}

}
