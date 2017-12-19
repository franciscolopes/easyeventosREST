package com.francisco.pds2.services;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.InscricaoPK;
import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.dto.InscricaoNewDTO;
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

	/*
	 * public Inscricao find(Integer usuario_id, Integer atividade_id) { Inscricao
	 * obj = inscricaoRepo.findById(usuario_id, atividade_id); if (obj == null) {
	 * throw new ObjectNotFoundException( "Objeto não encontrado! código: " +
	 * usuario_id + "e" + atividade_id + ", Tipo: " + Inscricao.class.getName()); }
	 * 
	 * return obj; }
	 */

	/*------INSERT --------*/
	public Inscricao insert(Inscricao obj) {
		// obj.setCodEvento(null);
		return inscricaoRepo.save(obj);
	}
	/*------INSERT --------*/

	public void marcaPresenca(Inscricao inscricao) {
		inscricaoRepo.save(inscricao);
	}

	/*------INSERT NOVA INSCRIÇÃO--------*/
	public Inscricao fromDTO(InscricaoNewDTO objDto) {

		Usuario usuario = usuarioRepo.findOne(objDto.getCodUsuario());
		Atividade atividade = atividadeRepo.findOne(objDto.getCodAtividade());

		/*----gera codigo de validação---*/
		String simbolos = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ123456789+@$%#";
		String codigoValidacao = "";
		Random random = new Random();

		for (int i = 0; i < 8; i++) {
			char c = simbolos.charAt(random.nextInt(60));
			codigoValidacao += c;
		}
		/*----gera codigo de validação---*/

		Inscricao inscricao = new Inscricao(usuario, atividade, new Date(), false, codigoValidacao);

		atividade.getInscricoes().addAll(Arrays.asList(inscricao));

		usuario.getInscricoes().addAll(Arrays.asList(inscricao));
		System.out.println(inscricao);
		return inscricao;
	}
	/*------INSERT NOVA INSCRIÇÃO--------*/

	public Inscricao find(Integer codUsuario, Integer codAtividade) {
		Usuario usuario = usuarioRepo.findOne(codUsuario);
		Atividade atividade = atividadeRepo.findOne(codAtividade);
		Inscricao obj = inscricaoRepo.findOne(new InscricaoPK(usuario, atividade));
		if (obj == null) {
			throw new ObjectNotFoundException("Objeto não encontrado! código, Tipo: " + Inscricao.class.getName());
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

	public Page<Inscricao> buscaInscricaoPorAtividade(Integer codAtividade, Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Atividade atividade = atividadeRepo.findOne(codAtividade);
		return inscricaoRepo.findByIdAtividade(atividade, pageRequest);
	}

	public Page<Inscricao> buscaInscricaoPorEvento(Integer codEvento, Integer page, Integer linesPerPage,
			String orderBy, String direction) {
		PageRequest pageRequest = new PageRequest(page, linesPerPage, Direction.valueOf(direction), orderBy);
		
		return inscricaoRepo.findByIdAtividadeEventoCodEvento(codEvento, pageRequest);
	}

}