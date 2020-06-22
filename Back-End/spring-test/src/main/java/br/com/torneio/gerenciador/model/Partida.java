package br.com.torneio.gerenciador.model;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class Partida {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private LocalTime hora;
	private LocalTime data;
	
	//Criar valore da partida
	private TipoPartida tipoPartida;
	
	@ManyToOne
	private List<Atleta> atleta;
	
	@ManyToMany
	private Torneio torneio;
	
	@OneToMany
	private Atleta vencendor;
	
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
	public void setAtleta(List<Atleta> atleta) {
		this.atleta = atleta;
	}
	public Torneio getTorneio() {
		return torneio;
	}
	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
	}
	public Atleta getVencendor() {
		return vencendor;
	}
	public void setVencendor(Atleta vencendor) {
		this.vencendor = vencendor;
	}
}
