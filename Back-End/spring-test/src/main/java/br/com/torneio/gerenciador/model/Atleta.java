package br.com.torneio.gerenciador.model;

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
public class Atleta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotEmpty //= @Valid do javax 
	@Column(length = 30, nullable = false)
	private String nome;
	
	
	//@Column @NotEmpty 
	private int idade;

	@ManyToOne @JoinColumn
	private Clube clube;
	private Long pontosGrupo;
	
	
	//dar update pra ver torneio vencido e torneio concorrido
	@OneToMany ( mappedBy = "atletaVencedor", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Torneio> torneiosVencidos;
	

	@ManyToMany(mappedBy = "atletasParticipantes", cascade = CascadeType.ALL)
	private List<Torneio> torneiosConcorridos;

	public Atleta() {
		
	}
		

	public Atleta(String nome, int idade, Clube clube) {
		this.nome = nome;
		this.idade = idade;
		this.clube = clube;
	}

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
