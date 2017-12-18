package com.francisco.pds2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.InscricaoPK;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, InscricaoPK>{
	
	

}
