package br.com.torneio.gerenciador.form;
//OKstella_front

import javax.validation.constraints.NotEmpty;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;

public class OrganizadorForm {

	@NotEmpty
	private String email;
	@NotEmpty
	private String senha;
	
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	public Organizador converter(OrganizadorRepository or) {
		Organizador organizador = or.findByEmail(email).get();
		return organizador;
	}
	
	
}
