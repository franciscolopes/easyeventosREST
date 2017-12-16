package com.francisco.pds2.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Evento implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private Integer codEvento;
	
	private String nome;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInicio;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataFim;
	private String descricao;
	
	
	
	@OneToMany(mappedBy="evento")
	private List<Atividade> atividades = new ArrayList<>(); 
	
	public Evento() {
		
	}

	public Evento(Integer codEvento, String nome, Date dataInicio, Date dataFim, String descricao) {
		super();
		this.codEvento = codEvento;
		this.nome = nome;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.descricao = descricao;
	}

	
	public Integer getCodEvento() {
		return codEvento;
	}

	public void setCodEvento(Integer codEvento) {
		this.codEvento = codEvento;
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
	
	public List<Atividade> getAtividades() {
		return atividades;
	}

	public void setAtividades(List<Atividade> atividades) {
		this.atividades = atividades;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codEvento == null) ? 0 : codEvento.hashCode());
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
		Evento other = (Evento) obj;
		if (codEvento == null) {
			if (other.codEvento != null)
				return false;
		} else if (!codEvento.equals(other.codEvento))
			return false;
		return true;
	}
	
	/*-----------DETERMINA PRESENA MINIMA DA ATIVIDADE-----------*/
	public int getPresencaMinima() {
		int qtdeAtividades = getAtividades().size();
		int presencaMin = Math.round((qtdeAtividades * 75))/100;
		return presencaMin;
	}
	/*-----------DETERMINA PRESENA MINIMA DA ATIVIDADE-----------*/
	
	
}
