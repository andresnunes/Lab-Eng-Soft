package br.com.torneio.gerenciador.controller;


import java.util.List;
import java.util.Optional;

import javax.persistence.CascadeType;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.TorneioRepository;


@Controller
@RequestMapping("{id_organizador}/atleta")
public class AtletaController {

	@Autowired
	private AtletaRepository ar;
	@Autowired
	OrganizadorRepository or;	
	@Autowired
	TorneioRepository tr;
	
	@RequestMapping("/cadastrar")
	public ModelAndView formCadastroAtleta(@PathVariable("id_organizador") long id_organizador) {
		ModelAndView mv = new ModelAndView("formAtleta");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);          
		Iterable<Atleta> atletas = ar.findByClube(organizador.get().getClube());		
		mv.addObject("atletas", atletas); 
		return mv;
	}
	
	@PostMapping("/cadastrar")
	public String saveAtleta(@PathVariable("id_organizador") long id_organizador, @Valid Atleta atleta, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            return "redirect:/{id_organizador}/atleta/cadastrar";
        }
        saveAtletaService(atleta, id_organizador);
        return "redirect:/{id_organizador}/atleta/cadastrar";	
	}
	@ResponseBody
	private void saveAtletaService(Atleta atleta, long id_organizador) {
        Optional<Organizador> organizador = or.findById(id_organizador);
        Atleta atletaSave = new Atleta();
        atletaSave.setIdade((atleta.getIdade()));
        atletaSave.setNome(atleta.getNome());
	    atletaSave.setClube(organizador.get().getClube());
	    ar.save(atletaSave);
	}

	@RequestMapping("/deletar")
    public String deleteAtleta(@PathVariable("id_organizador") long id_organizador, long codigoAtleta){
		deleteAtletaService(codigoAtleta);
        return "redirect:/{id_organizador}/atleta/cadastrar";
    }
	@ResponseBody
	@DeleteMapping
	private void deleteAtletaService(long codigoAtleta){
		Atleta atleta = ar.findById(codigoAtleta);
        List<Torneio> torneiosConcorridos = atleta.getTorneiosConcorridos();
        List<Torneio> torneiosVencidos = atleta.getTorneiosVencidos();
        for(Torneio torneio : torneiosConcorridos) {
        	List<Atleta> atletas = torneio.getAtletasParticipantes();
    		atletas.remove(atleta);
            tr.save(torneio);
        }
        for(Torneio torneio : torneiosVencidos) {
        	List<Atleta> atletas = torneio.getAtletasParticipantes();
    		atletas.remove(atleta);
            tr.save(torneio);
        }
        atleta.setTorneiosConcorridos(null); //ou criar um outro obj atleta pra atualizar o obj e herdando null
        atleta.setTorneiosVencidos(null);
        ar.delete(atleta);		
	}
	
	
	
	
	@RequestMapping("/editar/{id_atleta}")
	public ModelAndView formEditarAtleta(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_atleta")  long id_atleta) {
		ModelAndView mv = new ModelAndView("Atleta");
		
		Optional<Organizador> organizador = or.findById(id_organizador);
		Atleta atleta = ar.findById(id_atleta);
        List<Torneio> torneiosConcorridos = atleta.getTorneiosConcorridos();
        List<Torneio> torneiosVencidos = atleta.getTorneiosVencidos();
		
        mv.addObject("organizador", organizador);       		
		mv.addObject("torneiosConcorridos", torneiosConcorridos);
		mv.addObject("torneiosVencidos", torneiosVencidos);
		mv.addObject("atleta", atleta);
		return mv;
	}
	@PostMapping("/editar/{id_atleta}")
	public String updateAtleta(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_atleta") long id_atleta, @Valid Atleta atleta, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            System.out.println("O organizador de id " + id_organizador +" falhou em editar o atleta de id " + atleta.getId()); 
            return "redirect:/{id_organizador}/atleta/editar/{id_atleta}";
        }	
		updateAtletaService(id_atleta,atleta); 
        return "redirect:/{id_organizador}/atleta/cadastrar";	
	}
	@ResponseBody
	private void updateAtletaService(long id_atleta, Atleta atleta) {
		Atleta atletaUpdated = ar.findById(id_atleta);
		atletaUpdated.setNome(atleta.getNome());
		atletaUpdated.setIdade(atleta.getIdade());
        ar.save(atletaUpdated); 		
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
