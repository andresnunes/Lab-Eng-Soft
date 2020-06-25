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
		
		@RequestMapping("/dummydata")
		public void dummy() {
			//TESTAGEM DO CRUD, insertOK, read?, update?, delete?
			Organizador organizador1 = new Organizador();
			//organizador1.setClube(clube1);
			organizador1.setCpf("963852741");
			organizador1.setEmail("organizador1@email.com");
			organizador1.setNome("Leoncio");
			organizador1.setSenha("123");
			or.save(organizador1);
			
			Organizador organizador2 = new Organizador();
			//organizador2.setClube(clube2);
			organizador2.setCpf("741852963");
			organizador2.setEmail("organizador2@email.com");
			organizador2.setNome("Rafaela");
			organizador2.setSenha("123");
			or.save(organizador2);
			
			Clube clube1 = new Clube();
			clube1.setNome("Nipo");
			clube1.setCnpj("123456789");
			clube1.setEmail("nipo@email.com");
			clube1.setEndereco("Rua tal, n 12");
			clube1.setOrganizador(organizador1);
			
			Clube clube2 = new Clube();
			clube2.setNome("Palmeiras");
			clube2.setCnpj("987654321");
			clube2.setEmail("palmeiras@email.com");
			clube2.setEndereco("Rua x, n 64");
			clube2.setOrganizador(organizador2);
			cr.save(clube1);
			cr.save(clube2);

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
			List<Atleta> atletas_torneio1 = torneio1.getAtletas_participantes();


			torneio1.setAtletas_participantes(atletas_torneio1);
			tr.save(torneio1);
			Torneio torneio2 = new Torneio();
			torneio2.setClube(clube1);
			torneio2.setData_inicio(LocalDate.parse("2020-12-20"));
			tr.save(torneio2);
			Torneio torneio3 = new Torneio();
			torneio3.setClube(clube1);
			torneio3.setData_inicio(LocalDate.parse("2020-10-01"));
			tr.save(torneio3);
			
			torneio2.setAtleta_vencedor(atleta4);
			torneio3.setAtleta_vencedor(atleta1);
			tr.save(torneio2);
			tr.save(torneio3);
			//return "redirect:/atletas";
			
			
			
		}
	}

