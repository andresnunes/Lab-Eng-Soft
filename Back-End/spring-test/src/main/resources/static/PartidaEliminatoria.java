package br.com.torneio.gerenciador.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class PartidaEliminatoria {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private Long id;
	
	private LocalTime hora;
	private LocalTime data;
	
	@ManyToOne
	private Atleta atleta1;
	
	@ManyToOne
	private Atleta atleta2;
	
	@ManyToOne
	private Torneio torneio;
	
	@ManyToOne
	private Atleta vencendor;
	
	private Long nivelPartida;
	
	public PartidaEliminatoria() {
		
	}
	
	public PartidaEliminatoria(Atleta atleta1, Atleta atleta2) {
		this.atleta1 = atleta1;
		this.atleta2 = atleta2;
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

	public List<PartidaEliminatoria> CriaEliminatoria(List<PartidaGrupo> partidasGrupo){
	    
		List<Atleta> atletasPrimeiro = new ArrayList<Atleta>();
	    List<Atleta> atletasSegundo = new ArrayList<Atleta>();

	    
	    //Collection.sort(partidasGrupo, compardor)
	    partidasGrupo.forEach((partida)->{
	    	atletasPrimeiro.add(partida.getVencedor1());
	        atletasSegundo.add(partida.getVencedor2());
	    });
	    
	    Comparator<Atleta> compareByPontos = (Atleta a1, Atleta a2) 
	    				-> a1.getPontosGrupo().compareTo(a2.getPontosGrupo());
	    
	    Collections.sort(atletasPrimeiro, compareByPontos);
	    Collections.sort(atletasSegundo, compareByPontos.reversed());
	    
	    List<PartidaEliminatoria> partidaEliminatoria = new ArrayList<PartidaEliminatoria>();
	    
	    for (int i=0; i < atletasPrimeiro.size(); i++ ){
	    	partidaEliminatoria.add(new PartidaEliminatoria(atletasPrimeiro.get(i), atletasSegundo.get(i)));
	    }
	    
	    return partidaEliminatoria;
	}
}
