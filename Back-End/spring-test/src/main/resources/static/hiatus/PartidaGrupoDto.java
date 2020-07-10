package br.com.torneio.gerenciador.dto;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.model.PartidaEliminatoria;

public class PartidaGrupoDto {
	private Torneio torneio;
	
	private Atleta atleta1;
	private Atleta atleta2;
	private Atleta atleta3;
	
	private Atleta vencedor1;
	private Atleta vencedor2;
	
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
}
