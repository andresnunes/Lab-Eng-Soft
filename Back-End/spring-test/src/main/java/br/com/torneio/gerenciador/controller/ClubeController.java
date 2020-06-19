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

import br.com.torneio.gerenciador.dto.ClubeDto;
import br.com.torneio.gerenciador.form.AtualizaClubeForm;
import br.com.torneio.gerenciador.form.ClubeForm;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.repository.ClubeRepository;



@RequestMapping("/clube")
public class ClubeController {
	@Autowired
	private ClubeRepository clubeRepository ;
		
	
	@GetMapping
	public List<ClubeDto> listaClube(String nomeClube){
		if (nomeClube == null) {
			List<Clube> Clube = clubeRepository.findAll();
			return ClubeDto.converter(Clube);
		} else {
			List<Clube> Clube = clubeRepository.findByNome(nomeClube);
			return ClubeDto.converter(Clube);
		}
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClubeDto> cadastraClube(@RequestBody @Validated ClubeForm form, UriComponentsBuilder uriBuilder) {
		Clube clube = form.converter(clubeRepository);
		clubeRepository.save(clube);
		
		URI uri = uriBuilder.path("/Clube/{id}").buildAndExpand(clube.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClubeDto(clube));
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ClubeDto> atualizaClube(@PathVariable Long id, @RequestBody  AtualizaClubeForm form) {
		Optional<Clube> optional = clubeRepository.findById(id);
		if (optional.isPresent()) {
			Clube Clube = form.atualizar(id, clubeRepository);
			return ResponseEntity.ok(new ClubeDto(Clube));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletaClube(@PathVariable Long id) {
		Optional<Clube> optional = clubeRepository.findById(id);
		if (optional.isPresent()) {
			clubeRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
