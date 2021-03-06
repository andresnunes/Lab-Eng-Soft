package br.com.torneio.gerenciador.form;

import java.util.Optional;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.repository.ClubeRepository;

public class AtletaForm {
	//@NotNull @NotEmpty @Length(min = 3)
	private String nome;
	
	//@NotNull @NotEmpty 
	private String dataNascimento;
	
	//@NotNull @NotEmpty
	private Long clube_id;
	
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

	public Long getNomeClube() {
		return clube_id;
	}

	public void setNomeClube(Long clube_id) {
		this.clube_id = clube_id;
	}
	
	public Atleta converter(ClubeRepository clubeRepository) {
		Optional<Clube> clube = clubeRepository.findById(clube_id);
		return new Atleta(nome, dataNascimento, clube.get());
	}

}
