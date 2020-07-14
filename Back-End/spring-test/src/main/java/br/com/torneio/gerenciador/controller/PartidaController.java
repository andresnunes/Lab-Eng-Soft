package br.com.torneio.gerenciador.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.PartidaRepository;
import br.com.torneio.gerenciador.repository.PartidasRepository;
import br.com.torneio.gerenciador.repository.TorneioRepository;

@Controller
@RequestMapping("{id_organizador}/{id_torneio}/chaves")
public class PartidaController {
	@Autowired
	OrganizadorRepository or;
	@Autowired
	PartidaRepository pr;
	@Autowired
	PartidasRepository psr;
	@Autowired
	AtletaRepository ar;
	@Autowired
	TorneioRepository tr;
	
	@RequestMapping("/view")
	public ModelAndView listChaves(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio") long id_torneio) throws ParseException {
		ModelAndView mv = new ModelAndView("chaves");
		Organizador organizador = or.findById(id_organizador);
		mv.addObject("organizador", organizador);  		
		Torneio torneio = tr.findById(id_torneio);
		mv.addObject("torneio", torneio); 		
		List<Atleta> atletas1 = torneio.getAtletasParticipantes();	
		mv.addObject("atletas1", atletas1);

		return mv;
	}

	@RequestMapping("/vencedor")
	public String saveAtletaVencedor(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio") long id_torneio, long codigoAtleta){
	Torneio torneio = tr.findById(id_torneio);
	torneio.setAtletaVencedor(ar.findById(codigoAtleta));
	tr.save(torneio);
		return "redirect:view";
	}
}
