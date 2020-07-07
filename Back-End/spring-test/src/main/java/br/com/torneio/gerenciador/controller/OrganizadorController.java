package br.com.torneio.gerenciador.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;

//@RestController
@Controller
@RequestMapping("/organizador")
public class OrganizadorController {
	@Autowired
	OrganizadorRepository or;
	
	@RequestMapping("/login")
	public String login() { return("login");}
	
	@PostMapping("/login")       //futuramente so logar quanto tiver login E senha e aparecer msgm notempty
	public String getOrganizador(/*@Valid dto? pra gerar um login valido?,*/ Organizador organizador){
		Optional<Organizador> organizador1 = or.findByEmail(organizador.getEmail());
		if(organizador1.isPresent()) {  //melhorar validação
			if(organizador1.get().getSenha().intern()==organizador.getSenha().intern()) {
				return "redirect:/"+ organizador1.get().getId() +"/torneio/view";}
			
			}
		return "redirect:/organizador/login";
	}
	/*TEMPORARIAMENTE INABILITADO POIS O CADASTRO DE CLUBE CADASTRA UM ORGANIZADOR SO*/
	@RequestMapping("/signup")
	public String signup() { return("formOrganizador");}
	
	@PostMapping("/signup") 
	public String saveOrganizador(@Valid Organizador organizador, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            System.out.println("Verifique os campos");
            return "redirect:/organizador/signup";
        }
		or.save(organizador);	
		return "redirect:/"+ organizador.getId() +"/torneio/view";
	}
	
}
