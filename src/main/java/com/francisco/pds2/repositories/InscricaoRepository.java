package com.francisco.pds2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.francisco.pds2.domain.Inscricao;
import com.francisco.pds2.domain.InscricaoPK;

@Repository
public interface InscricaoRepository extends JpaRepository<Inscricao, InscricaoPK>{
	
	
	//Inscricao findById(Integer usuario_id, Integer atividade_id); 
	
	
	
	
	/*------BUSCA INSCRIÇÕES POR EVENTO--------
	//@Transactional(readOnly=true)
	@Query("SELECT obj FROM Atividade obj WHERE obj.evento.codEvento = :codEvento")
	Page<Inscricao> findBycodEvento(@Param("codEvento") Integer codEvento, Pageable pageRequest);
	/*------BUSCA INSCRIÇÕES POR EVENTO--------*/
	
	
}
