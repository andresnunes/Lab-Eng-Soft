package br.com.torneio.gerenciador.model;
//OKstella_front

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotEmpty;

@Entity
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) 
	private long id;
	
	@NotEmpty
	@Column(length = 20, nullable = false, name = "nome")
	private String nomeClube;
	
	@NotEmpty
	@Column(nullable = false)
	private String cnpj;
	
	@NotEmpty
	@Column(length = 30, nullable = false, name	= "email")
	private String emailClube;
	
	@NotEmpty
	@Column(length = 50, nullable = false)
	private String endereco;
	
	@OneToMany ( mappedBy="clube", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Atleta> atletas;
	
	@OneToOne ( mappedBy="clube", cascade=javax.persistence.CascadeType.ALL) //por enquanto um clube tem um organizador - EM CASO OneToMany ver comentario no model. Clube
	private Organizador organizador;
	
	@OneToMany( mappedBy="clube", orphanRemoval = true, cascade=javax.persistence.CascadeType.ALL)
	private List<Torneio> torneios;
	
	public String getNomeClube() {
		return nomeClube;
	}
	public void setNomeClube(String nomeClube) {
		this.nomeClube = nomeClube;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEmailClube() {
		return emailClube;
	}
	public void setEmailClube(String emailClube) {
		this.emailClube = emailClube;
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
