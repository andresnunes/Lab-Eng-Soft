package br.com.torneio.gerenciador.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

@Entity
public class Atleta implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty
	@Column(length = 30, nullable = false)
	private String nome;

	//@NotBlank//@NotEmpty // mesmo sem notação, nao permite cadastramento, mesmo com (nullable = true) NAO permite cadastramento em branco
	@Column
	private int idade;

	@ManyToOne @JoinColumn
	private Clube clube;
	private Long pontosGrupo;
	
	
	@OneToMany ( mappedBy = "atletaVencedor", orphanRemoval = true, cascade = CascadeType.ALL)
	private List<Torneio> torneiosVencidos;
	
	@ManyToMany(mappedBy = "atletasParticipantes", cascade = CascadeType.ALL)
	private List<Torneio> torneiosConcorridos;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}	
	public Clube getClube() {
		return clube;
	}
	public void setClube(Clube clube) {
		this.clube = clube;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public int getIdade() {
		return idade;
	}	

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public List<Torneio> getTorneiosVencidos() {
		return torneiosVencidos;
	}

	public void setTorneiosVencidos(List<Torneio> torneiosVencidos) {
		this.torneiosVencidos = torneiosVencidos;
	}

	public List<Torneio> getTorneiosConcorridos() {
		return torneiosConcorridos;
	}

	public void setTorneiosConcorridos(List<Torneio> torneiosConcorridos) {
		this.torneiosConcorridos = torneiosConcorridos;
	}

}
