package br.com.torneio.gerenciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneio.gerenciador.repository.TorneioRepository;



@RestController
@RequestMapping("/torneio")
public class TorneioController {
	@Autowired
	TorneioRepository tr;

}
