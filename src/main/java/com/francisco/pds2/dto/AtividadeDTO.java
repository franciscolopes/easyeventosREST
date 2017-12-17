package com.francisco.pds2.dto;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.francisco.pds2.domain.Atividade;

public class AtividadeDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	
	private Integer codAtividade;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String ministrante;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern="hh:mm")
	private Date horarioInicio;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern="hh:mm")
	private Date horarioFim;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=500, message="O tamanho deve ser entre 5 e 500 caracteres")
	private String descricao;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Integer nroVagas;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String tipoAtividade;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private Boolean inscricaoAberta;
	private Boolean atividadeAtiva;
	

	public AtividadeDTO() {
	}

	public AtividadeDTO(Atividade obj) {
		
		codAtividade = obj.getCodAtividade();
		nome = obj.getNome();
		ministrante =  obj.getMinistrante();
		horarioInicio =  obj.getHorarioInicio();
		horarioFim =  obj.getHorarioFim();
		dataInicio = obj.getDataInicio();
		dataFim = obj.getDataFim();
		descricao = obj.getDescricao();
		nroVagas =  obj.getNroVagas();
		tipoAtividade =  obj.getTipoAtividade();
		inscricaoAberta =  obj.getInscricaoAberta();
		atividadeAtiva =  obj.getAtividadeAtiva();
	}
	
	
	
	
	
	public Integer getNroVagas() {
		return nroVagas;
	}

	public void setNroVagas(Integer nroVagas) {
		this.nroVagas = nroVagas;
	}

	public String getTipoAtividade() {
		return tipoAtividade;
	}

	public void setTipoAtividade(String tipoAtividade) {
		this.tipoAtividade = tipoAtividade;
	}

	public Boolean getInscricaoAberta() {
		return inscricaoAberta;
	}

	public void setInscricaoAberta(Boolean inscricaoAberta) {
		this.inscricaoAberta = inscricaoAberta;
	}

	public Boolean getAtividadeAtiva() {
		return atividadeAtiva;
	}

	public void setAtividadeAtiva(Boolean atividadeAtiva) {
		this.atividadeAtiva = atividadeAtiva;
	}

	

	public Integer getCodAtividade() {
		return codAtividade;
	}

	public void setCodAtividade(Integer codAtividade) {
		this.codAtividade = codAtividade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}
	
}
