package br.com.torneio.gerenciador.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;

public class AtletaDto {

	private Long id;
	private String nome;
	private Clube clube;
	
	public AtletaDto(Atleta atleta) {
		this.id = atleta.getId();
		this.nome = atleta.getNome();
		this.clube = atleta.getClube();
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	public static List<AtletaDto> converter(List<Atleta> atleta){
		return atleta.stream().map(AtletaDto::new).collect(Collectors.toList());
	}
	
	
}
