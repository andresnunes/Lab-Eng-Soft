package br.com.torneio.gerenciador.controller;
//OKstella_front

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.torneio.gerenciador.form.OrganizadorForm;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.repository.OrganizadorFormRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;

@Controller
@RequestMapping("/organizador")
public class OrganizadorController {
	@Autowired
	OrganizadorFormRepository ofr;
	
	@RequestMapping("/login")
	public String login() { return("login");}
	
	@PostMapping("/login")
	public String getOrganizador(@Valid OrganizadorForm organizador, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos"); //!
            return "redirect:/organizador/login";
        }
		Optional<Organizador> organizador1 = ofr.findByEmail(organizador.getEmail());
		if(organizador1.isPresent() && 
				organizador1.get().getSenha().intern()==organizador.getSenha().intern()) { 
			return "redirect:/"+ organizador1.get().getId() +"/torneio/view";
		}
		return "redirect:/organizador/login";
	}
}
