package com.francisco.pds2.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Local  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//RETIRAR ESSA ANOTAÇÃO?
	private Integer codLocal;
	private String nome;
	private String descricao;
	private Integer capacidadeMax;
	
	
	@JsonIgnore
	@OneToOne
	@JoinColumn(name="atividade_id")
	/*@MapsId*/
	private Atividade atividade;
	
	public Local () {
		
	}

	public Local(Integer codLocal, String nome, String descricao, Integer capacidadeMax, Atividade atividade) {
		super();
		this.codLocal = codLocal;
		this.nome = nome;
		this.descricao = descricao;
		this.capacidadeMax = capacidadeMax;
		this.atividade = atividade;
	}

	public Integer getCodLocal() {
		return codLocal;
	}

	public void setCodLocal(Integer codLocal) {
		this.codLocal = codLocal;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCapacidadeMax() {
		return capacidadeMax;
	}

	public void setCapacidadeMax(Integer capacidadeMax) {
		this.capacidadeMax = capacidadeMax;
	}



	public Atividade getAtividade() {
		return atividade;
	}

	public void setAtividade(Atividade atividade) {
		this.atividade = atividade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codLocal == null) ? 0 : codLocal.hashCode());
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
		Local other = (Local) obj;
		if (codLocal == null) {
			if (other.codLocal != null)
				return false;
		} else if (!codLocal.equals(other.codLocal))
			return false;
		return true;
	}
}
