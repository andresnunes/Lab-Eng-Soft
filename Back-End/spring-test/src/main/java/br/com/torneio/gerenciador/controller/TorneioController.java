package br.com.torneio.gerenciador.controller;

import javax.validation.Valid;

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

import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.TorneioRepository;



//@RestController expectativa
@Controller       //realidade
@RequestMapping("/torneio")
public class TorneioController {
	@Autowired
	TorneioRepository tr;

	@GetMapping("/view")  //DO ORGANIZADOR LOGADO FUTURAMENTE
	public ModelAndView listarTorneios(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Torneio> torneios = tr.findAll();
		mv.addObject("torneios", torneios);
		return mv;
	}
	
	@RequestMapping("/cadastrar")
	public String formTorneio() {
		return "formTorneio" ;
	}
	
	@PostMapping("/cadastrar")
	public String saveTorneio(@Valid Torneio torneio, BindingResult result, RedirectAttributes attributes) {
		System.out.println("date:" + torneio.getData_inicio());
        if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
        return "redirect:/torneio/cadastrar";
        }
        tr.save(torneio);
        return "redirect:/torneio/view";		
	}
	
	@GetMapping("/deletar")
    public String deleteTorneio(long codigoTorneio){
        Torneio torneio = tr.findById(codigoTorneio);
        tr.delete(torneio);
        return "redirect:/torneio/view";
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
