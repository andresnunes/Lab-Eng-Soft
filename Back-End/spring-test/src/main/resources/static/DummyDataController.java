package br.com.torneio.gerenciador.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
//import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.ClubeRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.TorneioRepository;
//import br.com.torneio.gerenciador.repository.TorneioRepository;
//import br.com.torneio.gerenciador.repository.TorneioRepository;



@Controller
public class DummyDataController {
		@Autowired
		AtletaRepository ar;
		@Autowired
		ClubeRepository cr;
		@Autowired
		OrganizadorRepository or;
		@Autowired
		TorneioRepository tr;
		
		@RequestMapping("/") // futura home com link pra os outros controllers
		public String index() { return("login");}
		
		@RequestMapping("/teste1")
		public void  teste1() {
			//TESTAGEM DO CRUD, insertOK, read?, update?, delete? EM TABELAS 1..n n..1 1..1			
		
			Clube clube1 = new Clube();
			clube1.setNome("Nipo");
			clube1.setCnpj("123456789");
			clube1.setEmail("nipo@email.com");
			clube1.setEndereco("Rua tal, n 12");
			//clube1.setOrganizador(organizador1); //att. INVERTI ///o correto pois o atributo organizador_id esta na tabela do clube
			
			Organizador organizador1 = new Organizador();
			organizador1.setCpf("963852741");
			organizador1.setEmail("organizador1@email.com");
			organizador1.setNome("Leoncio Nipo");
			organizador1.setSenha("123");
			organizador1.setClube(clube1);
			or.save(organizador1);	
			
			Organizador organizador2 = new Organizador();
			organizador2.setCpf("741852963");
			organizador2.setEmail("organizador2@email.com");
			organizador2.setNome("Rafaela Palmeiras");
			organizador2.setSenha("123");
			//organizador2.setClube(clube2); O BANCO NAO SALVA ESSE ATRIBUTO APAGAR setClube, certo clube1.setOrganizador(organizador1);
			or.save(organizador2);			
			Clube clube2 = new Clube();
			clube2.setNome("Palmeiras");
			clube2.setCnpj("987654321");
			clube2.setEmail("palmeiras@email.com");
			clube2.setEndereco("Rua x, n 64");
			clube2.setOrganizador(organizador2);
			
			cr.save(clube1); // Um clube pode trocar de organizardor futuramente? no caso onetoone ira sobrescrever se um novo organizador se cadastrar
			cr.save(clube2); // quando um organizador for cadastrado ele sera instruido a se associar a um clube OU cadastrar um nove clube

			
			
			Atleta atleta1 = new Atleta();
			atleta1.setNome("Stella");
			atleta1.setIdade(23);
			atleta1.setClube(clube1);
			ar.save(atleta1);
			Atleta atleta2 = new Atleta();
			atleta2.setNome("Gabiru");
			atleta2.setIdade(36);
			atleta2.setClube(clube1);
			ar.save(atleta2);
			Atleta atleta3 = new Atleta();
			atleta3.setNome("Andre");
			atleta3.setIdade(15);
			atleta3.setClube(clube2);
			ar.save(atleta3);
			Atleta atleta4 = new Atleta();
			atleta4.setNome("Murillo");
			atleta4.setIdade(30);
			atleta4.setClube(clube1);
			ar.save(atleta4);
			Atleta atleta5 = new Atleta();
			atleta5.setNome("Fabio");
			atleta5.setIdade(11);
			atleta5.setClube(clube2);					
			ar.save(atleta5);
			
			
			Torneio torneio1 = new Torneio();
			torneio1.setClube(clube1);
			torneio1.setData_inicio(LocalDate.parse("2020-09-15"));
			tr.save(torneio1);
			Torneio torneio2 = new Torneio();
			torneio2.setClube(clube1);
			torneio2.setData_inicio(LocalDate.parse("2020-12-20"));
			tr.save(torneio2);
			Torneio torneio3 = new Torneio();
			torneio3.setClube(clube1);
			torneio3.setData_inicio(LocalDate.parse("2020-10-01"));
			tr.save(torneio3);
			
			//setando atributos não not null
			torneio2.setAtleta_vencedor(atleta4);
			torneio3.setAtleta_vencedor(atleta1);
			tr.save(torneio2);
			tr.save(torneio3);

			//return ar.findAll();
		}

		@RequestMapping("/teste2")
		public void teste2() {
			//TESTAGEM DO CRUD, insertOK, read?, update?, delete? EM TABELAS n..n
			//return "redirect:/atletas";
			
			//TESTE DE BUSCAS
			//Iterable<Atleta> atletas = ar.findByTorneio(torneio1);

			//fazer implementação e descrever essa função la? ou deixar no controler?
			//List<Atleta> atletas_torneio1 = torneio1.getAtletas_participantes();
			//Iterable<Atleta> atletas_torneio1 = ar.findByTorneio(torneio1);
			/*Torneio torneio1 = tr.findById(1);
			List<Atleta> atletas_torneio1 = torneio1.getAtletas_participantes();
			
			Atleta atleta1 = ar.findById(1);
			atletas_torneio1.add(atleta1);
			torneio1.setAtletas_participantes(atletas_torneio1);
			tr.save(torneio1);*/
			//adicionar valor a lista
			
			Torneio torneio1 = tr.findById(1);			
			Atleta atleta1 = ar.findById(1); Atleta atleta2 = ar.findById(2); Atleta atleta3 = ar.findById(3);	
			
			List<Atleta> atletas_torneio1 = torneio1.getAtletas_participantes();
			atletas_torneio1.add(atleta1);		
			atletas_torneio1.add(atleta2);
			atletas_torneio1.add(atleta3);
			
			torneio1.setAtletas_participantes(atletas_torneio1);
			
			tr.save(torneio1);    
			
			Torneio torneio2 = tr.findById(2);			
			Atleta atleta4 = ar.findById(4); Atleta atleta5 = ar.findById(5); 
			
			List<Atleta> atletas_torneio2 = torneio2.getAtletas_participantes();
			atletas_torneio2.add(atleta4);		
			atletas_torneio2.add(atleta5);
			atletas_torneio2.add(atleta3);
			
			torneio2.setAtletas_participantes(atletas_torneio2);
			
			tr.save(torneio2);  
			
			/*
			Atleta atleta2 = ar.findById(2);                                            //   PARA ADICIONAR ATLETAS NA LISTA DE UM TORNEIO ESSA FORMA NAO É EFICAZ, 

			List<Torneio> torneios_atleta2 = atleta2.getTorneios_concorridos();         //   pois a tabela mapeada é a 'torneio' pelo atributo 'atletas_participantes'
			torneios_atleta2.add(torneio1);			                                    //E NAO A TABELA TORNEIO
			
			atleta2.setTorneios_concorridos(torneios_atleta2);                          //utilizar a logica acima, pois se adiciona atletas em um torneio, 
			                                                                            // pois o nosso programa so tem o painel do organizador e ele tem acesso ao torneio 
			torneio1.setAtleta_vencedor(atleta2);                                 //e a uma base de atletas, 2.0 poderia ter o login do atleta e ele iria se inscrever em torneios
			
			ar.save(atleta2);	*/	
			
			//FAZER LOGICA PRA RECUSAR ATLETA JÁ CADASTRADO NO TORNEIO
			
			/*
			 * 
			 * select * from ATLETA ;
			select * from CLUBE ;
			select * from ORGANIZADOR ;
			select * from TORNEIO;
			select * from TORNEIO_ATLETA ;
			 * */
			
		}
}

