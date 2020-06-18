package br.com.torneio.gerenciador.model;

import java.time.LocalTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

public class Partida {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	@ManyToMany
	@JoinTable(name = "Atleta1_Partida",
    joinColumns = { @JoinColumn(name = "idAtleta") },
    inverseJoinColumns = { @JoinColumn(name = "idPartida") })
	private Atleta atleta1;
	@ManyToMany
	@JoinTable(name = "Atleta2_Partida",
    joinColumns = { @JoinColumn(name = "idAtleta") },
    inverseJoinColumns = { @JoinColumn(name = "idPartida") })
	private Atleta atleta2;
	private LocalTime hora;
	private LocalTime data;
	
	
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
}
