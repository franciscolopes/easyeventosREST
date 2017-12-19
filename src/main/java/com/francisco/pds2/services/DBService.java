package com.francisco.pds2.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Evento;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.Local;
import com.francisco.pds2.domain.Usuario;
import com.francisco.pds2.domain.enums.CategoriaUsuario;
import com.francisco.pds2.repositories.AtividadeRepository;
import com.francisco.pds2.repositories.EventoRepository;
import com.francisco.pds2.repositories.InscricaoRepository;
import com.francisco.pds2.repositories.LocalRepository;
import com.francisco.pds2.repositories.UsuarioRepository;


@Service
public class DBService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private EventoRepository eventoRepository;
	
	@Autowired
	private AtividadeRepository atividadeRepository;
	
	@Autowired
	private LocalRepository localRepository;
	
	@Autowired
	private InscricaoRepository inscricaoRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("hh:mm");
		
		Usuario usuario1 = new Usuario(null, "Maria","eearg.ti.francisco@gmail.com","10098415871",CategoriaUsuario.SERVIDOR);
		Usuario usuario2 = new Usuario(null, "Celio","celio@gmail.com","96098515871",CategoriaUsuario.ALUNO);
		Usuario usuario3 = new Usuario(null, "Alan","alan@gmail.com","15668415871",CategoriaUsuario.VISITANTE);
		
		usuarioRepository.save(Arrays.asList(usuario1, usuario2, usuario3));
		
		Evento evento1 = new Evento (null, "SNCT2017",sdf.parse("23/10/2017"),sdf.parse("27/10/2017"),"A Semana Nacional de Ciência e Tecnologia - SNCT - é coordenada pelo Ministério de Ciência e Tecnologia e tem como objetivo aproximar a Ciência e a Tecnologia da população.");
		Evento evento2 = new Evento (null, "3ª Mostra de Trabalhos do IFTM",sdf.parse("24/10/2017"),sdf.parse("24/10/2017")," Mostra de Trabalhos da Semana Nacional de Ciência e Tecnologia, a ocorrer no IFTM Campus Uberlândia Centro.");
		//Evento evento3 = new Evento (null, "TESTE",sdf.parse("24/10/2017"),sdf.parse("24/10/2017")," TESTE");
		eventoRepository.save(Arrays.asList(evento1, evento2));
		
		
				
		Atividade a1 = new Atividade(null,"Arduino","Joao",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso arduino",40,"Minicurso",true,true,evento1);
		Atividade a2 = new Atividade(null,"Testes de Sistemas","Alice",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso Testes",10,"Minicurso",true,true,evento1);
		Atividade a3 = new Atividade(null,"CSS 3","Ana",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("24/10/2017"),"Minicurso Css",20,"Minicurso",true,true,evento2);
		Atividade a4 = new Atividade(null,"HTML 5","Andre",sdf2.parse("18:45"),sdf2.parse("22:45"),sdf.parse("23/10/2017"),sdf.parse("26/10/2017"),"Minicurso Html",30,"Minicurso",true,true,evento2);
		
		Local local1 = new Local(null, "Auditorio", "Auditorio do campus", 150, a1);
		a1.setLocal(local1);
		
		Local local2 = new Local(null, "Sala 18", "Sala de aula do campus", 30, a2);
		a2.setLocal(local2);
		
		Local local3 = new Local(null, "Sala 19", "Sala de aula do campus", 30, a3);
		a3.setLocal(local3);
		
		Local local4 = new Local(null, "Sala 20", "Sala de aula do campus", 30, a4);
		a4.setLocal(local4);
		
		
		Local local5 = new Local(null, "Sala 22", "Sala de aula do campus", 45, null);
		
		evento1.getAtividades().addAll(Arrays.asList(a1, a2));
		evento2.getAtividades().addAll(Arrays.asList(a3, a4));
		
		atividadeRepository.save(Arrays.asList(a1, a2, a3, a4));
		localRepository.save(Arrays.asList(local1, local2, local3, local4,local5));
		
		Inscricao inscricao1 = new Inscricao(usuario1, a1, sdf.parse("20/10/2017"), false, "KJYHT");
		Inscricao inscricao2 = new Inscricao(usuario1, a4, sdf.parse("21/10/2017"), false,"P)*J&");
		Inscricao inscricao3 = new Inscricao(usuario2, a2, sdf.parse("10/10/2017"), false,"iuytr");
		Inscricao inscricao4 = new Inscricao(usuario3, a3, sdf.parse("17/10/2017"), false,"ftrgy");
		Inscricao inscricao5 = new Inscricao(usuario1, a2, sdf.parse("20/10/2017"), false, "XXXXX");
		
		
		a1.getInscricoes().addAll(Arrays.asList(inscricao1));
		a2.getInscricoes().addAll(Arrays.asList(inscricao3));
		a2.getInscricoes().addAll(Arrays.asList(inscricao5));
		a3.getInscricoes().addAll(Arrays.asList(inscricao4));
		a4.getInscricoes().addAll(Arrays.asList(inscricao2));
		
		usuario1.getInscricoes().addAll(Arrays.asList(inscricao1, inscricao2, inscricao5));
		usuario2.getInscricoes().addAll(Arrays.asList(inscricao3));
		usuario3.getInscricoes().addAll(Arrays.asList(inscricao4));
		
		inscricaoRepository.save(Arrays.asList(inscricao1, inscricao2, inscricao3, inscricao4, inscricao5));
		
		
		
	}
	
	
}
