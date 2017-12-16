package com.francisco.pds2.domain;

import java.io.Serializable;

public class Usuario implements Serializable{
	
	private static final long serialVersionUID = 1L;

	private Integer codUsuario;
	private String nome;
	private String email;
	private String cpf;
	private Integer categoria;

	public Usuario() {

	}

	public Usuario(Integer codUsuario, String nome, String email, String cpf/*, CategoriaUsuario categoria*/) {
		super();
		this.codUsuario = codUsuario;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		//this.categoria = (categoria==null) ? null : categoria.getCod();
	}

	public Integer getCodUsuario() {
		return codUsuario;
	}

	public void setCodUsuario(Integer codUsuario) {
		this.codUsuario = codUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	/*
	 public CategoriaUsuario getCategoria() {
		return CategoriaUsuario.toEnum(categoria);
	}

	public void setCategoria(CategoriaUsuario categoria) {
		this.categoria = categoria.getCod();
	}
	 */
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codUsuario == null) ? 0 : codUsuario.hashCode());
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
		Usuario other = (Usuario) obj;
		if (codUsuario == null) {
			if (other.codUsuario != null)
				return false;
		} else if (!codUsuario.equals(other.codUsuario))
			return false;
		return true;
	}
	

	
	
	

}
