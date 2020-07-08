package br.com.torneio.gerenciador.controller;


import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.torneio.gerenciador.model.Clube;
import br.com.torneio.gerenciador.model.Organizador;
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
