package com.francisco.pds2.dto;

import java.io.Serializable;
import java.util.Date;

public class AtividadeNewDTO  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	/*atividade*/
	private String nomeAtividade;
	private String ministrante;
	private Date horarioInicio;
	private Date horarioFim;
	private Date dataInicioAtividade;
	private Date dataFimAtividade;
	private String descricaoAtividade;
	private Integer nroVagas;
	private String tipoAtividade;
	private Boolean inscricaoAberta;
	private Boolean atividadeAtiva;

	/*evento*/
	private Integer codEvento;
	
	/*local*/
	private Integer codLocal;
	
	public AtividadeNewDTO() {
		
	}

	public String getNomeAtividade() {
		return nomeAtividade;
	}

	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
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

	public Date getDataInicioAtividade() {
		return dataInicioAtividade;
	}

	public void setDataInicioAtividade(Date dataInicioAtividade) {
		this.dataInicioAtividade = dataInicioAtividade;
	}

	public Date getDataFimAtividade() {
		return dataFimAtividade;
	}

	public void setDataFimAtividade(Date dataFimAtividade) {
		this.dataFimAtividade = dataFimAtividade;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
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
