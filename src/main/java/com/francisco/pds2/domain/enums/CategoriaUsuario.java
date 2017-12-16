package com.francisco.pds2.domain.enums;
public enum CategoriaUsuario {
	
	SERVIDOR(1, "Servidor do campus"),
	ALUNO(2, "Aluno matriculado"),
	VISITANTE(3, "Comunidade externa");
	
	private int cod;
	private String descricao;
	
	private CategoriaUsuario(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static CategoriaUsuario toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (CategoriaUsuario x : CategoriaUsuario.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
