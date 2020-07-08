package br.com.torneio.gerenciador.form;

//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.NotNull;

import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.repository.ClubeRepository;

public class ClubeForm {

	//@NotNull @NotEmpty
	private String nome;
	
	//@NotNull @NotEmpty
	private String cnpj;
	
	//@NotNull @NotEmpty
	private String email;
	
	//@NotNull @NotEmpty
	private String endereco;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Clube converter(ClubeRepository clubeRepository) {
		Clube clube = clubeRepository.findByNomeClube(nome).get(0);
		return clube;
	}
	
}
