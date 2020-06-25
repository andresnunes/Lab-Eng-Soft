package br.com.torneio.gerenciador.model;

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Torneio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@ManyToOne @JoinColumn
	private Atleta atleta_vencedor;
	
	@ManyToOne @JoinColumn
	private Clube clube;
	
	private LocalDate data_inicio;
	
	//MANYTOMANY LISTA DE ATLETAS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Atleta getAtleta_vencedor() {
		return atleta_vencedor;
	}

	public void setAtleta_vencedor(Atleta atleta_vencedor) {
		this.atleta_vencedor = atleta_vencedor;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

}
