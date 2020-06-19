package br.com.torneio.gerenciador.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.repository.ClubeRepository;

public class AtletaForm {
	@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	@NotNull @NotEmpty 
	private int idade;
	
	@NotNull @NotEmpty
	private String nomeClube;
	
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

	public String getNomeClube() {
		return nomeClube;
	}

	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}
	
	public Atleta converter(ClubeRepository clubeRepository) {
		Clube clube = clubeRepository.findByNome(nomeClube).get(0);
		return new Atleta(nome, idade, clube);
	}

}
