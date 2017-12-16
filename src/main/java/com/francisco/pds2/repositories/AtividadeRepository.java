package com.francisco.pds2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francisco.pds2.domain.Atividade;

@Repository//um objeto desse evento é capaz de realizar operações de acesso a dados referente a objetos atividade
public interface AtividadeRepository extends JpaRepository<Atividade, Integer>{
	
}
