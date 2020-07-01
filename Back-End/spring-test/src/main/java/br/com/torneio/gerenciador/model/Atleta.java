package br.com.torneio.gerenciador.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Atleta {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private int idade;
	@ManyToOne
	private Clube clube;
	private Long pontosGrupo;
	
	
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
	
	public Long getPontosGrupo() {
		return pontosGrupo;
	}

	public void setPontosGrupo(Long pontosGrupo) {
		this.pontosGrupo = pontosGrupo;
	}

}
