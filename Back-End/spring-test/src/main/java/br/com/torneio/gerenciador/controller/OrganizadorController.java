package br.com.torneio.gerenciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneio.gerenciador.repository.OrganizadorRepository;



@RestController
@RequestMapping("/organizador")
public class OrganizadorController {
	@Autowired
	OrganizadorRepository or;
}
