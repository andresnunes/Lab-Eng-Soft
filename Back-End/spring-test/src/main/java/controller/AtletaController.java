package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Atleta;
import repository.AtletaRepository;
import dto.AltetaDto;

@RequestMapping("/atleta")
public class AtletaController {

	@Autowired
	private AtletaRepository atletaRepository;
	
	@GetMapping	
	public List<AtletaDto> listaAtleta(String nomeAtleta){
		if (nomeAtleta == null) {
			List<Atleta> atleta = atletaRepository.findAll();
		} else {
			List<Atleta> atleta = atletaRepository.findByNome(nomeAtleta);
		}
		List<Atleta> atleta = atletaRepository.findAll();
		return AtletaDto.converter(atleta);
	}
	
	@PostMapping
	public void cadastraAtleta() {
		
	}
}
