package com.francisco.pds2.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.francisco.pds2.domain.Atividade;
import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.InscricaoPK;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, InscricaoPK>{
	
	//List<Inscricao> findByInscricaopkAtividade(Atividade atividade);
	
	@Transactional(readOnly=true)
	//@Query//("SELECT obj FROM Inscricao obj WHERE obj.id.atividade = :atividade")
	Page<Inscricao> findByIdAtividade(/*@Param("atividade")*/ Atividade atividade, Pageable pageRequest);
	  
	
	

}
