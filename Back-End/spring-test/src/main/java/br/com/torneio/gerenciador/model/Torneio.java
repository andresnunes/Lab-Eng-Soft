package br.com.torneio.gerenciador.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Torneio implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//LocalDate - alterar a para yymmdd para ter compatibilidade com o banco
	@NotEmpty
	private String data_inicio;
	
	@ManyToOne @JoinColumn
	private Atleta atletaVencedor;
	
	@ManyToOne @JoinColumn
	private Clube clube;
	
	@ManyToMany
	@JoinTable(name="torneio_atleta", joinColumns = {@JoinColumn(name="torneio_id")},inverseJoinColumns = {@JoinColumn(name="atleta_id")})
	private List<Atleta> atletasParticipantes;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getData_inicio() {
		return data_inicio;
	}

	public void setData_inicio(String data_inicio) {
		this.data_inicio = data_inicio;
	}

	public Atleta getAtletaVencedor() {
		return atletaVencedor;
	}

	public void setAtletaVencedor(Atleta atletaVencedor) {
		this.atletaVencedor = atletaVencedor;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public List<Atleta> getAtletasParticipantes() {
		return atletasParticipantes;
	}

	public void setAtletasParticipantes(List<Atleta> atletasParticipantes) {
		this.atletasParticipantes = atletasParticipantes;
	}

}
