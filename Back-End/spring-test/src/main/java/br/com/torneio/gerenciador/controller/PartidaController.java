package br.com.torneio.gerenciador.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.torneio.gerenciador.dto.AtletaDto;
import br.com.torneio.gerenciador.form.AtletaForm;
import br.com.torneio.gerenciador.form.AtualizaAtletaForm;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.ClubeRepository;

@RequestMapping("/partida")
public class PartidaController {
	
	
	@GetMapping
	public List<AtletaDto> listaAtleta(String nomeAtleta){
		if (nomeAtleta == null) {
			List<Atleta> atleta = atletaRepository.findAll();
			return AtletaDto.converter(atleta);
		} else {
			List<Atleta> atleta = atletaRepository.findByNome(nomeAtleta);
			return AtletaDto.converter(atleta);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<AtletaDto> cadastraAtleta(@RequestBody @Validated AtletaForm form, UriComponentsBuilder uriBuilder) {
		Atleta atleta = form.converter(clubeRepository);
		atletaRepository.save(atleta);
		
		URI uri = uriBuilder.path("/atleta/{id}").buildAndExpand(atleta.getId()).toUri();
		return ResponseEntity.created(uri).body(new AtletaDto(atleta));
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<AtletaDto> atualizaAtleta(@PathVariable Long id, @RequestBody  AtualizaAtletaForm form) {
		Optional<Atleta> optional = atletaRepository.findById(id);
		if (optional.isPresent()) {
			Atleta atleta = form.atualizar(id, atletaRepository);
			return ResponseEntity.ok(new AtletaDto(atleta));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletaAtleta(@PathVariable Long id) {
		Optional<Atleta> optional = atletaRepository.findById(id);
		if (optional.isPresent()) {
			atletaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
