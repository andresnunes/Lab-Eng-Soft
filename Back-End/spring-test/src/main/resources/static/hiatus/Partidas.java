package br.com.torneio.gerenciador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Partidas {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//LocalDate
	@NotEmpty
	private String data_partida;
	
	@ManyToOne @JoinColumn
	private Torneio torneio;
	
	private int atleta_a_sets_vencidos;
	private int atleta_b_sets_vencidos;
	private int atleta_a_pontos_set_1;
	private int atleta_a_pontos_set_2;
	private int atleta_a_pontos_set_3;
	private int atleta_a_pontos_set_4;
	private int atleta_a_pontos_set_5;
	private int atleta_b_pontos_set_1;
	private int atleta_b_pontos_set_2;
	private int atleta_b_pontos_set_3;
	private int atleta_b_pontos_set_4;
	private int atleta_b_pontos_set_5;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData_partida() {
		return data_partida;
	}

	public void setData_partida(String data_partida) {
		this.data_partida = data_partida;
	}

	public int getAtletaASets() {
		return atleta_a_sets_vencidos;
	}
	
	public void setAtletaASets(int atleta_a_sets_vencidos) {
		this.atleta_a_sets_vencidos = atleta_a_sets_vencidos;
	}
	
	public int getAtletaBSets() {
		return atleta_b_sets_vencidos;
	}
	
	public void setAtletaBSets(int atleta_b_sets_vencidos) {
		this.atleta_b_sets_vencidos = atleta_b_sets_vencidos;
	}
	
	public int getPontosAtletaASet1() {
		return atleta_a_pontos_set_1;
	}
	
	public void setPontosAtletaASet1(int atleta_a_pontos_set_1) {
		this.atleta_a_pontos_set_1 = atleta_a_pontos_set_1;
	}
	
	public int getPontosAtletaASet2() {
		return atleta_a_pontos_set_2;
	}
	
	public void setPontosAtletaASet2(int atleta_a_pontos_set_2) {
		this.atleta_a_pontos_set_2 = atleta_a_pontos_set_2;
	}
	
	public int getPontosAtletaASet3() {
		return atleta_a_pontos_set_3;
	}
	
	public void setPontosAtletaASet3(int atleta_a_pontos_set_3) {
		this.atleta_a_pontos_set_3 = atleta_a_pontos_set_3;
	}
	
	public int getPontosAtletaASet4() {
		return atleta_a_pontos_set_4;
	}
	
	public void setPontosAtletaASet4(int atleta_a_pontos_set_4) {
		this.atleta_a_pontos_set_4 = atleta_a_pontos_set_4;
	}
	
	public int getPontosAtletaASet5() {
		return atleta_a_pontos_set_5;
	}
	
	public void setPontosAtletaASet5(int atleta_a_pontos_set_5) {
		this.atleta_a_pontos_set_5 = atleta_a_pontos_set_5;
	}
	
	public int getPontosAtletaBSet1() {
		return atleta_b_pontos_set_1;
	}
	
	public void setPontosAtletaBSet1(int atleta_b_pontos_set_1) {
		this.atleta_b_pontos_set_1 = atleta_b_pontos_set_1;
	}
	
	public int getPontosAtletaBSet2() {
		return atleta_b_pontos_set_2;
	}
	
	public void setPontosAtletaBSet2(int atleta_b_pontos_set_2) {
		this.atleta_b_pontos_set_2 = atleta_b_pontos_set_2;
	}
	
	public int getPontosAtletaBSet3() {
		return atleta_b_pontos_set_3;
	}
	
	public void setPontosAtletaBSet3(int atleta_b_pontos_set_3) {
		this.atleta_b_pontos_set_3 = atleta_b_pontos_set_3;
	}
	
	public int getPontosAtletaBSet4() {
		return atleta_b_pontos_set_4;
	}
	
	public void setPontosAtletaBSet4(int atleta_b_pontos_set_4) {
		this.atleta_b_pontos_set_4 = atleta_b_pontos_set_4;
	}
	
	public int getPontosAtletaBSet5() {
		return atleta_b_pontos_set_5;
	}
	
	public void setPontosAtletaBSet5(int atleta_b_pontos_set_5) {
		this.atleta_b_pontos_set_5 = atleta_b_pontos_set_5;
	}
}
