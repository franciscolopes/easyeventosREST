package com.francisco.pds2.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

public class InscricaoNewDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@NotNull(message="Preenchimento obrigatório")
	private Integer codUsuario;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer codAtividade;
	

	
	public InscricaoNewDTO() {
		
	}


	public Integer getCodAtividade() {
		return codAtividade;
	}


	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}


	public Integer getCodUsuario() {
		return codUsuario;
	}


	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}
	
	
	
}
