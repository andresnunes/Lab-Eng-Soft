package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import model.Atleta;
import repository.AtletaRepository;

public class AtletaController {

	@Autowired
	private AtletaRepository atletaRepository;
	
	@RequestMapping("/atleta")
	public List<Atleta> lista(){
		List<Atleta> atleta = atletaRepository.findAll();
		return atleta;
	}
}
