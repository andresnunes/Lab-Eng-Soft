package br.com.torneio.gerenciador.model;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class PartidaGrupo {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	@ManyToOne
	private Torneio torneio;
	
	private LocalTime hora;
	private LocalDateTime data;
	
	private List<String> listAtletas = new ArrayList<String>();
	private List<String> listPrimeiros = new ArrayList<String>();
	private List<String> listSegundos = new ArrayList<String>();
	
//	@ManyToOne
//	private Atleta atleta1;
//	
//	@ManyToOne
//	private Atleta atleta2;
//	
//	@ManyToOne
//	private Atleta atleta3;
	
//	
//	@ManyToOne
//	private Atleta vencedor1;
//	
//	@ManyToOne
//	private Atleta vencedor2;
	
	
	public PartidaGrupo() {
		
	}
	
	
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
	public Torneio getTorneio() {
		return torneio;
	}
	public void setTorneio(Torneio torneio) {
		this.torneio = torneio;
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
	public Atleta getAtleta3() {
		return atleta3;
	}
	public void setAtleta3(Atleta atleta3) {
		this.atleta3 = atleta3;
	}
	public Atleta getVencedor1() {
		return vencedor1;
	}
	public void setVencedor1(Atleta vencedor1) {
		this.vencedor1 = vencedor1;
	}
	public Atleta getVencedor2() {
		return vencedor2;
	}
	public void setVencedor2(Atleta vencedor2) {
		this.vencedor2 = vencedor2;
	}	
	
	public List<PartidasGrupo> CriaGrupo(List){
		
	}
}
