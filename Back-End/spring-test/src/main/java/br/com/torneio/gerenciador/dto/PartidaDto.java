package br.com.torneio.gerenciador.dto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Partida;
import br.com.torneio.gerenciador.model.TipoPartida;

public class PartidaDto {

	private Long id;
	private LocalTime hora;
	private LocalTime data;
	private TipoPartida tipoPartida;
	private List<Atleta> atleta;
	
	public PartidaDto(Partida partida) {
		this.id = partida.getId();
		this.hora = partida.getHora();
		this.data = partida.getData();
		this.tipoPartida = partida.getTipoPartida();
		this.atleta = partida.getAtleta();
	}
	
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public LocalTime getData() {
		return data;
	}
	public void setData(LocalTime data) {
		this.data = data;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}	
	public TipoPartida getTipoPartida() {
		return tipoPartida;
	}
	public void setTipoPartida(TipoPartida tipoPartida) {
		this.tipoPartida = tipoPartida;
	}
	
	public List<Atleta> getAtleta() {
		return atleta;
	}
	
	public static List<PartidaDto> converter(List<Partida> partida){
		return partida.stream().map(PartidaDto::new).collect(Collectors.toList());
	}
}
