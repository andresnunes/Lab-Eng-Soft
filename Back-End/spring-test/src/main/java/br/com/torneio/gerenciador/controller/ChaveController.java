package br.com.torneio.gerenciador.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.torneio.gerenciador.model.PartidaPK;
import br.com.torneio.gerenciador.model.Torneio;

@Controller
@RequestMapping("/chave")
public class ChaveController {

	@GetMapping()
	public List<ParidaPK> getParidas(Torneio torneio){
		return; 
		
	}
	
	@PutMapping("{id}")
	public void putPartidas(PartidaPK parida) {
		
	}
	
	
}
