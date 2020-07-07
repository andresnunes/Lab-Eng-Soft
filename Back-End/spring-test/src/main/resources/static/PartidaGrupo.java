package br.com.torneio.gerenciador.model;

import java.time.LocalDateTime;
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

public class PartidaGrupo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private LocalTime hora;
	private LocalDateTime data;
	
	@OneToMany
	private Atleta atleta1;
	
	@OneToMany
	private Atleta atleta2;
	
	@OneToMany
	private Atleta atleta3;
	
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
	public LocalDateTime getData() {
		return data;
	}
	public void setData(LocalDateTime data) {
		this.data = data;
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
