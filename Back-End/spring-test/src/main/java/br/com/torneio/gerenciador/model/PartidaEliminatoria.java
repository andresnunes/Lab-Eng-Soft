package br.com.torneio.gerenciador.model;

import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

public class PartidaEliminatoria {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private LocalTime hora;
	private LocalTime data;
	
	@OneToMany
	private Atleta atleta1;
	
	@OneToMany
	private Atleta atleta2;
	
	@ManyToOne
	private Torneio torneio;
	
	@OneToMany
	private Atleta vencendor;
	
	private Long nivelPartida;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public Atleta getAtleta1() {
		return atleta1;
	}
	public void setAtleta1(Atleta atleta1) {
		this.atleta1 = atleta1;
	}
	public Atleta getAtleta2() {
		return atleta2;
	}
	public void setAtleta2(Atleta atleta2) {
		this.atleta2 = atleta2;
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
	public Long getNivelPartida() {
		return nivelPartida;
	}
	public void setNivelPartida(Long nivelPartida) {
		this.nivelPartida = nivelPartida;
	}
	
}
