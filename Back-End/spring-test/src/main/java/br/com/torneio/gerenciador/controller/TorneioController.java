package br.com.torneio.gerenciador.controller;

import java.util.Optional;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.TorneioRepository;



//@RestController expectativa
@Controller       //realidade
@RequestMapping("{id_organizador}/torneio")
public class TorneioController {
	@Autowired
	TorneioRepository tr;
	@Autowired
	OrganizadorRepository or;

	@GetMapping("/view")  //DO ORGANIZADOR LOGADO FUTURAMENTE
	public ModelAndView listarTorneios(@PathVariable("id_organizador") long id_organizador){
		ModelAndView mv = new ModelAndView("index");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);
		
		Iterable<Torneio> torneios = tr.findAll();
		mv.addObject("torneios", torneios);
		System.out.println("O organizador de id " + organizador.get().getId() + " acessou o painel de torneios"); 
		return mv;
	}

	@RequestMapping("/cadastrar")
	public String formTorneio(@PathVariable("id_organizador") long id_organizador) {
		System.out.println("O organizador de id " + id_organizador +" acessou o formulario de cadastro de torneio"); 
		return "formTorneio" ;
	}
	
	@PostMapping("/cadastrar")
	public String saveTorneio(@PathVariable("id_organizador") long id_organizador, @Valid Torneio torneio, BindingResult result, RedirectAttributes attributes) {
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            System.out.println("O organizador de id " + id_organizador +" falhou em postar um novo torneio"); 
        return "redirect:/{id_organizador}/torneio/cadastrar";
        }
        Optional<Organizador> organizador = or.findById(id_organizador);
        torneio.setClube(organizador.get().getClube());
        tr.save(torneio);
        System.out.println("O organizador de id " + id_organizador +" postou um novo torneio com data em " + torneio.getData_inicio()); 
        System.out.println("Clube sediador do torneio:" + organizador.get().getClube());
        return "redirect:/{id_organizador}/torneio/view";		
	}
	
	/*
	CRIAR PAINEL DE CLUBES "cadastre seu clube!" ira cadastrar clube e um organizador obrigatoriamente, 
	no futuro no many to many, varios organizadores poderão fazer parte de um clube > futuramente ORGANIZADOR ACESSA CLUBE,
	HOJE, organizador loga e tem acesso aos torneios.	
	*/
	
	//@PathVariable("id_organizador") long id_organizador, QUANDO TORNEIO TIVER OBRIGATORIAMENTE UM CLUBE
	@GetMapping("/deletar")
    public String deleteTorneio(long codigoTorneio){
        Torneio torneio = tr.findById(codigoTorneio);
        tr.delete(torneio);
        return "redirect:/{id_organizador}/torneio/view";
    }
	/*
	@RequestMapping("/editar")
	public ModelAndView updateFormTorneio(long codigoTorneio) {
		Torneio torneio = tr.findById(codigoTorneio);
		ModelAndView mv = new ModelAndView("UpdateFormTorneio");
		mv.addObject("torneio.data", torneio.getData_inicio());
		return mv;

	}	
	@PutMapping("/editar")
	public String updateTorneio(long codigoTorneio) {
		Torneio torneio = tr.findById(codigoTorneio);
		tr.save(torneio);
		return "redirect:/torneio/view";
	}
	
	//GERAR LISTAGEM https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html
	
	*/
	
	
	
	
	
	
}
