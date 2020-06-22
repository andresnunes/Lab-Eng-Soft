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
import br.com.torneio.gerenciador.model.PartidaGrupo;
import br.com.torneio.gerenciador.repository.PartidaEliminatoriaRepository;


@RequestMapping("/partida")
public class PartidaController {
	
		
}
