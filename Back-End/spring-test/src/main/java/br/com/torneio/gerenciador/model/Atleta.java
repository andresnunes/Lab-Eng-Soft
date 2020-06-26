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

@Entity
public class Atleta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	//@NotEmpty = @Valid do javax 
	@Column(length = 30, nullable = false)
	private String nome;
	
	//@Column   
	private int idade;

	@ManyToOne @JoinColumn
	private Clube clube;
	
	@OneToMany ( mappedBy = "atleta_vencedor", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Torneio> torneios_vencidos;
	

	@ManyToMany(mappedBy = "atletas_participantes", cascade = CascadeType.ALL)
	private List<Torneio> torneios_concorridos;

	
	public Atleta() {
		
	}
	
	public Atleta(String nome,int idade, Clube clube) {
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

	public List<Torneio> getTorneios_vencidos() {
		return torneios_vencidos;
	}

	public void setTorneios_vencidos(List<Torneio> torneios_vencidos) {
		this.torneios_vencidos = torneios_vencidos;
	}

	public List<Torneio> getTorneios_concorridos() {
		return torneios_concorridos;
	}

	public void setTorneios_concorridos(List<Torneio> torneios_concorridos) {
		this.torneios_concorridos = torneios_concorridos;
	}
	
}
