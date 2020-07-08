package br.com.torneio.gerenciador.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.repository.AtletaRepository;

public class AtualizaAtletaForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private int idade;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public Atleta atualizar(Long id, AtletaRepository atletaRepository) {
		Atleta atleta = atletaRepository.getOne(id);
		
		atleta.setNome(this.nome);
		atleta.setIdade(this.idade);
		
		return atleta;
	
	}

}
