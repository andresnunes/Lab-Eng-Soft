package br.com.torneio.gerenciador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import java.time.LocalDate;

@Entity
public class Torneio {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	
	private LocalDate data_inicio;
	// private LocalTime data_final; torneio acaba em 1 dia , verificar
	// posteriormente no crUd como ira ser a atualização desse LocalTime aqui

	//@ManyToOne // (optional = false)
	//@JoinColumn
	//private Clube clube;

	// @ManyToOne um torneio tem 1 atleta vencedor por isso mudei, sugiro a criação
	// da lista atletas participantes
	@OneToOne
	private Atleta vencedor;

	public LocalDate getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(LocalDate data_inicio) {
		this.data_inicio = data_inicio;
	}
/*
	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}*/

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
