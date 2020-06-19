package br.com.torneio.gerenciador.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.torneio.gerenciador.model.Clube;

public class ClubeDto {

	private Long id;
	private String nome;
	private String endereco;
	
	public ClubeDto(Clube clube) {
		this.id = clube.getId();
		this.nome = clube.getNome();
		this.endereco = clube.getEndereco();
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public static List<ClubeDto> converter(List<Clube> atleta){
		return atleta.stream().map(ClubeDto::new).collect(Collectors.toList());
	}
}
