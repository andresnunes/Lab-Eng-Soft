package br.com.torneio.gerenciador.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Clube {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	

	//@NotEmpty = @Valid do javax
	@Column(length = 20, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String cnpj;
	
	@Column(length = 30, nullable = false)
	private String email;
	
	@Column(length = 50, nullable = false)
	private String endereco;
	
	@OneToMany ( mappedBy="clube", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Atleta> atletas;
	
	@OneToOne //por enquanto um clube tem um organizador - EM CASO OneToMany ver comentario no model. Clube
	@JoinColumn
	private Organizador organizador;
	
	@OneToMany( mappedBy="clube", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Torneio> torneios;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public List<Atleta> getAtletas() {
		return atletas;
	}
	public void setAtletas(List<Atleta> atletas) {
		this.atletas = atletas;
	}
	public Organizador getOrganizador() {
		return organizador;
	}
	public void setOrganizador(Organizador organizador) {
		this.organizador = organizador;
	}
	public List<Torneio> getTorneios() {
		return torneios;
	}
	public void setTorneios(List<Torneio> torneios) {
		this.torneios = torneios;
	}
	

}
