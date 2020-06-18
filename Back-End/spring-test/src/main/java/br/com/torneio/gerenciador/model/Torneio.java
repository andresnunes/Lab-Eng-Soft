package br.com.torneio.gerenciador.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import java.time.LocalTime;

public class Torneio {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	private LocalTime data_inicio;
	private LocalTime data_final;
	@ManyToOne
	private Clube clube;
	@ManyToOne
	private Atleta vencedor;
	
	
	public LocalTime getData_inicio() {
		return data_inicio;
	}
	public void setData_inicio(LocalTime data_inicio) {
		this.data_inicio = data_inicio;
	}
	
	public LocalTime getData_final() {
		return data_final;
	}
	public void setData_final(LocalTime data_final) {
		this.data_final = data_final;
	}
	
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	
	public Atleta getVencedor() {
		return vencedor;
	}
	public void setVencedor(Atleta vencedor) {
		this.vencedor = vencedor;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
