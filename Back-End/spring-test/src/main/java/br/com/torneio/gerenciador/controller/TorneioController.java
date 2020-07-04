package br.com.torneio.gerenciador.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.torneio.gerenciador.repository.PartidaGrupoRepository;
import br.com.torneio.gerenciador.model.PartidaGrupo;
import br.com.torneio.gerenciador.dto.PartidaGrupoDto;

@RestController
@RequestMapping("/torneio")
public class TorneioController {
	
	@Autowired
	private PartidaGrupoRepository partidaGrupoRepository;
	
	@GetMapping("/grupos")
	public List<PartidaGrupoDto> listaGrupos(){
		List<PartidaGrupo> partidas = partidaGrupoRepository;
		return PartidaGrupoDto.converter(partidas);
	}
	
}
