package br.com.torneio.gerenciador.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.repository.ClubeRepository;

public class AtualizaClubeForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String cnpj;
	
	@NotNull @NotEmpty
	private String email;
	
	@NotNull @NotEmpty
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

	public Clube atualizar(Long id, ClubeRepository clubeRepository) {
		Clube clube = clubeRepository.getOne(id);
		
		clube.setNome(this.nome);
		clube.setCnpj(this.cnpj);
		clube.setEmail(this.email);
		clube.setEndereco(this.endereco);

		
		return clube;
	}
}
