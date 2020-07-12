package br.com.torneio.gerenciador.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.repository.AtletaRepository;

public class AtualizaAtletaForm {
	
	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String dataNascimento;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Atleta atualizar(Long id, AtletaRepository atletaRepository) {
		Atleta atleta = atletaRepository.getOne(id);
		
		atleta.setNome(this.nome);
		atleta.setDataNascimento(this.dataNascimento);
		
		return atleta;
	
	}

}
