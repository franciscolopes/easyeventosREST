package com.francisco.pds2.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Inscricao implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private InscricaoPK id = new InscricaoPK(); 
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date dataInscricao;
	private Boolean presente;
	private String codigoCertificado;

	public Inscricao() {
		
	}

	public Inscricao(Usuario usuario, Atividade atividade, Date dataInscricao, Boolean presente, String codigoCertificado) {
		super();
		id.setUsuario(usuario);
		id.setAtividade(atividade);
		this.dataInscricao = dataInscricao;
		this.presente = presente;
		this.codigoCertificado = codigoCertificado;
	}

	@JsonIgnore
	public Usuario getUsuario() {
		return id.getUsuario();
	}
	
	
	public void setUsuario(Usuario usuario) {
		id.setUsuario(usuario);
	}
	
	@JsonIgnore
	public Atividade getAtividade() {
		return id.getAtividade();
	}
	
	public void setAtividade(Atividade atividade) {
		id.setAtividade(atividade);
	}
	
	
	public InscricaoPK getId() {
		return id;
	}

	public void setId(InscricaoPK id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Inscricao other = (Inscricao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	/*-----------QRCODE-----------*/
	public Integer getBaseQrcode() {
		Integer baseQrcode = getUsuario().getCodUsuario();
		return baseQrcode;
	}
	/*-----------QRCODE-----------*/

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Evento: ");
		builder.append(getId().getAtividade().getEvento().getNome());
		builder.append(", Atividade: ");
		builder.append(getId().getAtividade().getNome());
		builder.append(", Data de inscricao: ");
		builder.append(sdf.format(dataInscricao));
		builder.append("\n");
		return builder.toString();
	}

	
}
