package br.com.torneio.gerenciador.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.ClubeRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;


@Controller
@RequestMapping("/clube")
public class ClubeController {
	@Autowired
	private ClubeRepository cr;
	@Autowired
	private OrganizadorRepository or;
	
	@RequestMapping("/signup")
	public String signup() {
		return "formClube";
	}
	

	@PostMapping("/signup") 
	public String saveClube(@Valid Clube clube, BindingResult result, RedirectAttributes attributes, @Valid Organizador organizador, BindingResult result2, RedirectAttributes attributes2){
		if(result.hasErrors() || result2.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos"); //!
            return "redirect:/clube/signup";
        }
		saveClubeService(clube, organizador);	
		return "redirect:/"+ organizador.getId() +"/torneio/view";
	}
	@ResponseBody
	private void saveClubeService(Clube clube, Organizador organizador) {
		cr.save(clube);	
		organizador.setClube(clube);
		or.save(organizador);
	}
	

	@RequestMapping("/{id_organizador}/editar")
	public ModelAndView formClube(@PathVariable("id_organizador") long id_organizador){
		ModelAndView mv = new ModelAndView("Clube");
		Optional<Organizador> organizador = or.findById(id_organizador);
		mv.addObject("organizador",organizador);
		Clube clube = organizador.get().getClube();
		mv.addObject("clube",clube);
		
		List<Torneio> torneios = clube.getTorneios();
		mv.addObject("torneios", torneios);
		return mv;
		
		/*
		List<Torneio> torneiosVencidos= new ArrayList<Torneio>();
        for(Torneio torneioVencido : torneios) {
        	Atleta atleta = torneioVencido.getAtletaVencedor();
        	if(atleta != null && (torneioVencido.getAtletaVencedor().getClube()==clube)) {
        		torneiosVencidos.add(torneioVencido);
        	}
        	System.out.println("atleta vencedor:"+torneioVencido.getAtletaVencedor());
        	
        }
        mv.addObject("torneiosVencidos", torneiosVencidos);

		//List<Atleta> atletas = cr.findByNomeClube(nomeClube)
		//Atleta atleta = ar.findById(id_atleta);
        //List<Torneio> torneiosVencidos = atleta.getTorneiosVencidos();
		//mv.addObject("torneiosVencidos", torneiosVencidos)
		 
			<p>Torneios vencidos:</p>
				<li th:each="torneiosVencidos: ${clube.torneios}">
				<a th:href="${(#mvc.url('CC#formClube').arg(0,organizador.get().getId())).build()}">
					<span th:text="'Data: '+${torneiosVencidos.data_inicio}"></span>					
				</a></li> 
		 
		 * ;*/

	}
	
	@RequestMapping("/{id_organizador}/editar/{id_torneio}")
	public String formClubeR(@PathVariable("id_organizador") long id_organizador, @PathVariable long id_torneio) {
		return"redirect:/{id_organizador}/torneio/editar/"+id_torneio;		
	}
	
	@PostMapping("/{id_organizador}/editar")
	public String updateClube(@PathVariable("id_organizador") long id_organizador, @Valid Clube clube, BindingResult result, RedirectAttributes attributes, @Valid Organizador organizador, BindingResult result2, RedirectAttributes attributes2){
		if(result.hasErrors() || result2.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos"); //!
            return "redirect:/{id_organizador}/editar";
        }
		updateClubeService(clube, organizador);	
		return "redirect:/"+ id_organizador +"/torneio/view";
	}
	@ResponseBody
	private void updateClubeService(Clube clube, Organizador organizador) {
		//Organizador organizadorUpdate = or.findById(organizador.getId()); //TIRAR OPTIONAL
		cr.save(clube);	
		//or.save(organizador);
	}



}

/*

@GetMapping("/{id}")
public ResponseEntity<Torneio> getTorneioById(@PathVariable(value="id") long id){
	Optional<Torneio> torneio = tr.findById(id);
	if(!torneio.isPresent()){
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
	} return new ResponseEntity<Torneio>(torneio.get(), HttpStatus.OK);
	
}
/*
 * //FURURAMENTE VERIFICAR A PERSISTENCIA SEGURA DOS DADOS PRA HOJE, OK
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
*/
