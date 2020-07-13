package br.com.torneio.gerenciador.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Partida {
	
	@EmbeddedId
	private PartidaPK partida;

	public PartidaPK getPartida() {
		return partida;
	}

	public void setPartida(PartidaPK partida) {
		this.partida = partida;
	}
	
	/*
	 * public Partidas getPartidaId() { return partida_id; }
	 * 
	 * public void setPartidaId(Partidas partida_id) { this.partida_id = partida_id;
	 * }
	 * 
	 * public Atleta getAtletaAId() { return atleta_a_id; }
	 * 
	 * public void setAtletaAId(Atleta atleta_a_id) { this.atleta_a_id =
	 * atleta_a_id; }
	 * 
	 * public Atleta getAtletaBId() { return atleta_b_id; }
	 * 
	 * public void setAtletaBId(Atleta atleta_b_id) { this.atleta_b_id =
	 * atleta_b_id; }
	 */
	
}
