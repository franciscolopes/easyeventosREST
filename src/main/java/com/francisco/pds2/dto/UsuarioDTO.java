package com.francisco.pds2.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import com.francisco.pds2.domain.Usuario;

public class UsuarioDTO implements Serializable {
	 private static final long serialVersionUID = 1L;
	 
		private Integer codUsuario;
		
		@NotEmpty(message="Preenchimento obrigatório")
		@Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
		private String nome;
		
		
		@NotEmpty(message="Preenchimento obrigatório")
		@Email(message="Email inválido")
		private String email;
		
		
		public UsuarioDTO() {
		}

		public UsuarioDTO(Usuario obj) {
			codUsuario = obj.getCodUsuario();
			nome = obj.getNome();
			email = obj.getEmail();
			
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
		
}
