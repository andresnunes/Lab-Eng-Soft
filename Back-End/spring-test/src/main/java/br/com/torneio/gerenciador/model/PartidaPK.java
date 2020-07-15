package br.com.torneio.gerenciador.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable 
public class PartidaPK implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne @JoinColumn
	private Partidas id;
	
	@ManyToOne @JoinColumn
	private Atleta atleta_a;
	
	@ManyToOne @JoinColumn
	private Atleta atleta_b;

	public PartidaPK(Atleta atleta_a, Atleta atleta_b) {
		this.atleta_a = atleta_a;
		this.atleta_b = atleta_b;
	}
	
	public Long getPartidaId() {
		return serialVersionUID;
	}

	public void setPartidaId(Partidas partida) {
		this.id = partida;
	}
	
	public Atleta getAtletaAId() {
		return atleta_a;
	}

	public void setAtletaAId(Atleta atleta_a) {
		this.atleta_a = atleta_a;
	}
	
	public Atleta getAtletaBId() {
		return atleta_b;
	}

	public void setAtletaBId(Atleta atleta_b) {
		this.atleta_b = atleta_b;
	}
	
}
