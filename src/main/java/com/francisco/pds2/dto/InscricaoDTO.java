package com.francisco.pds2.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.francisco.pds2.domain.Inscricao;

public class InscricaoDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInscricao;
	private Boolean presente;
	private String codigoCertificado;

	public InscricaoDTO() {
		
	}
	
	public InscricaoDTO(Inscricao obj) {
		setNome(obj.getId().getUsuario().getNome());
		dataInscricao = obj.getDataInscricao();
		presente = obj.getPresente();
		codigoCertificado = obj.getCodigoCertificado();
	}
	
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInscricao() {
		return dataInscricao;
	}

	public void setDataInscricao(Date dataInscricao) {
		this.dataInscricao = dataInscricao;
	}

	public Boolean getPresente() {
		return presente;
	}

	public void setPresente(Boolean presente) {
		this.presente = presente;
	}

	public String getCodigoCertificado() {
		return codigoCertificado;
	}

	public void setCodigoCertificado(String codigoCertificado) {
		this.codigoCertificado = codigoCertificado;
	}
	
	
	
}
