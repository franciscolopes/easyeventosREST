package com.francisco.pds2.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Atividade implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer codAtividade;
	private String nome;
	private String ministrante;
	
	@JsonFormat(pattern="hh:mm")
	private Date horarioInicio;
	
	@JsonFormat(pattern="hh:mm")
	private Date horarioFim;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	private String descricao;
	private Integer nroVagas;
	private String tipoAtividade;
	private Boolean inscricaoAberta;
	private Boolean atividadeAtiva;
		
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="evento_id")
	private Evento evento;
	
	@OneToOne(cascade=CascadeType.ALL, mappedBy="atividade")//The meaning of CascadeType.ALL is that the persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
	private Local local;

	
	@OneToMany(mappedBy="id.atividade")
	private Set<Inscricao> inscricoes = new HashSet<>();

	public Atividade() {
		
	}

	public Atividade(Integer codAtividade, String nome, String ministrante, Date horarioInicio, Date horarioFim,
			Date dataInicio, Date dataFim, String descricao, Integer nroVagas, String tipoAtividade,
			Boolean inscricaoAberta, Boolean atividadeAtiva, Evento evento) {
		super();
		this.codAtividade = codAtividade;
		this.nome = nome;
		this.ministrante = ministrante;
		this.horarioInicio = horarioInicio;
		this.horarioFim = horarioFim;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
		this.nroVagas = nroVagas;
		this.tipoAtividade = tipoAtividade;
		this.inscricaoAberta = inscricaoAberta;
		this.atividadeAtiva = atividadeAtiva;
		this.evento = evento;
		
	}
	
	public Set<Inscricao> getInscricoes() {
		return inscricoes;
	}

	public void setInscricoes(Set<Inscricao> inscricoes) {
		this.inscricoes = inscricoes;
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

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	

	public Local getLocal() {
		return local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codAtividade == null) ? 0 : codAtividade.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		if (codAtividade == null) {
			if (other.codAtividade != null)
				return false;
		} else if (!codAtividade.equals(other.codAtividade))
			return false;
		return true;
	}
	
}
