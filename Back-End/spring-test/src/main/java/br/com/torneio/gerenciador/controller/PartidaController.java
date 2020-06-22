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

import br.com.torneio.gerenciador.dto.PartidaDto;
import br.com.torneio.gerenciador.form.PartidaForm;
import br.com.torneio.gerenciador.model.Partida;
import br.com.torneio.gerenciador.repository.PartidaRepository;


@RequestMapping("/partida")
public class PartidaController {
	
	@Autowired
	private PartidaRepository partidaRepository;
	
	
	@GetMapping
	public List<PartidaDto> listapartida(){
		
		List<Partida> partida = partidaRepository.findAll();
		return PartidaDto.converter(partida);
		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<PartidaDto> cadastrapartida(@RequestBody @Validated PartidaForm form, UriComponentsBuilder uriBuilder) {
		Partida partida = form.converter();
		partidaRepository.save(partida);
		
		URI uri = uriBuilder.path("/partida/{id}").buildAndExpand(partida.getId()).toUri();
		return ResponseEntity.created(uri).body(new PartidaDto(partida));
		
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<PartidaDto> atualizapartida(@PathVariable Long id, @RequestBody  AtualizaPartidaForm form) {
		Optional<Partida> optional = partidaRepository.findById(id);
		if (optional.isPresent()) {
			Partida partida = form.atualizar(id, partidaRepository);
			return ResponseEntity.ok(new PartidaDto(partida));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> deletapartida(@PathVariable Long id) {
		Optional<Partida> optional = partidaRepository.findById(id);
		if (optional.isPresent()) {
			partidaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
}
