package com.francisco.pds2.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

public class AtividadeNewDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String nome;
	
	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=80, message="O tamanho deve ser entre 5 e 80 caracteres")
	private String ministrante;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="hh:mm")
	private Date horarioInicio;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="hh:mm")
	private Date horarioFim;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@NotNull(message="Preenchimento obrigatório")
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String descricao;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer nroVagas;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private String tipoAtividade;
	
	@NotNull(message="Preenchimento obrigatório")
	private Boolean inscricaoAberta;
	@NotNull(message="Preenchimento obrigatório")
	private Boolean atividadeAtiva;

	@NotNull(message="Preenchimento obrigatório")
	private Integer codEvento;
	
	@NotNull(message="Preenchimento obrigatório")
	private Integer codLocal;
	
	public AtividadeNewDTO() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMinistrante() {
		return ministrante;
	}

	public void setMinistrante(String ministrante) {
		this.ministrante = ministrante;
	}

	public Date getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(Date horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public Date getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(Date horarioFim) {
		this.horarioFim = horarioFim;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicioAtividade(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFimAtividade(Date dataFim) {
		this.dataFim = dataFim;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricaoAtividade(String descricao) {
		this.descricao = descricao;
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


	public Integer getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
	}

	public Integer getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(Integer codLocal) {
		this.codLocal = codLocal;
	}
	

}
