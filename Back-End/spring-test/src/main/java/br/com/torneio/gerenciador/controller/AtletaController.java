package br.com.torneio.gerenciador.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.ClubeRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.dto.AtletaDto;
import br.com.torneio.gerenciador.form.AtletaForm;
import br.com.torneio.gerenciador.form.AtualizaAtletaForm;

//@RestController
@Controller
@RequestMapping("{id_organizador}/atleta")
public class AtletaController {

	@Autowired
	private AtletaRepository ar;
	@Autowired
	OrganizadorRepository or;	
	@Autowired
	private ClubeRepository cr;
	
	
	@RequestMapping("/cadastrar")
	public ModelAndView formCadastroAtleta(@PathVariable("id_organizador") long id_organizador) {
		ModelAndView mv = new ModelAndView("formAtleta");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);          
		Iterable<Atleta> atletas = ar.findByClube(organizador.get().getClube());		
		mv.addObject("atletas", atletas);
		return mv;
	}
	
	//rever os @valids e os do html 0,organizador.get().getId()
	@PostMapping("/cadastrar")
	public String saveAtleta(@PathVariable("id_organizador") long id_organizador, @Valid Atleta atleta, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
        return "redirect:/atleta/cadastrar";
        }
        Optional<Organizador> organizador = or.findById(id_organizador);
        atleta.setClube(organizador.get().getClube());
        ar.save(atleta);
        return "redirect:/{id_organizador}/atleta/cadastrar";	
	}
	
	
	@GetMapping("/deletar")
    public String deleteAtleta(@PathVariable("id_organizador") long id_organizador, long codigoAtleta){
        Atleta atleta = ar.findById(codigoAtleta);
        ar.delete(atleta);
        return "redirect:/{id_organizador}/atleta/cadastrar";
    }
	
	
	@RequestMapping("/editar/{id_atleta}") // se tiver tempo mais facil criar outro html com o put no form e tentar puxar os dados
	public ModelAndView formEditarAtleta(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_atleta")  long id_atleta) {
		ModelAndView mv = new ModelAndView("Atleta");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);         
		Atleta atleta = ar.findById(id_atleta);
		mv.addObject("atleta", atleta);
		return mv;
	}


	//metodo PUT, nao upava, resolver depois	
	@PostMapping("/editar/{id_atleta}")
	public String updateAtleta(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_atleta") long id_atleta, @Valid Atleta atleta, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            System.out.println("O organizador de id " + id_organizador +" falhou em editar o atleta de id " + atleta.getId()); 
            return "redirect:/{id_organizador}/atleta/editar/{id_atleta}";
        }	
		Atleta atletaUpdated = ar.findById(id_atleta);
		atletaUpdated.setNome(atleta.getNome());
		atletaUpdated.setIdade(atleta.getIdade());
        ar.save(atletaUpdated);
        System.out.println("O organizador de id " + id_organizador +" atualizou atleta de id " + id_atleta); 
        return "redirect:/{id_organizador}/torneio/view";	
	}	


	/*
	@GetMapping
	public List<AtletaDto> listaAtleta(String nomeAtleta){
		if (nomeAtleta != null) {
			List<Atleta> atleta = atletaRepository.findByNome(nomeAtleta);
			return AtletaDto.converter(atleta);
		}
		List<Atleta> atleta = atletaRepository.findAll();
		return AtletaDto.converter(atleta);
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
	}*/
}
