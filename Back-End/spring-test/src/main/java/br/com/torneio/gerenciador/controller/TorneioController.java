package br.com.torneio.gerenciador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.TorneioRepository;



@RestController
@RequestMapping("/torneio")
public class TorneioController {
	@Autowired
	TorneioRepository tr;

	@GetMapping("/view")  //DO ORGANIZADOR LOGADO FUTURAMENTE
	public ModelAndView listarTorneios(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Torneio> torneios = tr.findAll();
		mv.addObject("torneios", torneios);
		return mv;
	}
}
