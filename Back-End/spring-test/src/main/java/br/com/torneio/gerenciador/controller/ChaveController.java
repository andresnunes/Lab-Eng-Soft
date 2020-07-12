package br.com.torneio.gerenciador.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.PartidaPK;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.TorneioRepository;

@Controller
@RequestMapping("/chave")
public class ChaveController {
	
	@Autowired
	private TorneioRepository tr;
	
	
	

	@GetMapping()
	public ModelAndView getParidas(@PathVariable("id_torneio") long id_torneio){
		ModelAndView mv = new ModelAndView("formChaves");
		Optional<Torneio> torneio = tr.findById(id_torneio);
        mv.addObject("torneio", torneio);          
		
		return mv;
		
	}
	
	@PutMapping("{id}")
	public void putPartidas(PartidaPK parida) {
		
	}
	
	
}
