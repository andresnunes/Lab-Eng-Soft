package br.com.torneio.gerenciador.controller;
//OKstella_front

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
	@Autowired
	OrganizadorRepository or;
	
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
	
	@RequestMapping("/{id_organizador}/editar")
	public ModelAndView formOrganizador(@PathVariable("id_organizador") long id_organizador) {
		ModelAndView mv = new ModelAndView("Organizador");
		Organizador organizador = or.findById(id_organizador);
		mv.addObject("organizador",organizador);
		return mv;		
	}
	
	@PostMapping("/{id_organizador}/editar")
	public String updateOrganizador(@PathVariable("id_organizador") long id_organizador, @Valid Organizador organizador, BindingResult result, RedirectAttributes attributes){
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos"); //!
            return "redirect:/organizador/{id_organizador}/editar";
        }
		//BUSCAR EMAIL NO BANCO, SE REPETIDO
		//BUSCAR CPF NO BANCO, SE REPETIDO
		List<Organizador> organizadores = or.findAll();
				organizadores.remove(or.findById(id_organizador)); //VERIFICAR ESSA LOGICA, porque ele pode cadastrar com o mesmo cpf/email o organizador do proprio clube, caso outro organizador de outro clube quiser se atualizar ou cadastrar com o cpf de OUTRO organizador ele nao consegue
		for(Organizador organizadorBanco : organizadores) {
			if(organizadorBanco.getCpf().intern()==organizador.getCpf().intern()) {
				attributes.addFlashAttribute("mensagem", "CPF já cadastrado");
	            return "redirect:/organizador/{id_organizador}/editar";
			}
			if(organizadorBanco.getEmail().intern()==organizador.getEmail().intern()) {
				attributes.addFlashAttribute("mensagem", "Email já cadastrado");
	            return "redirect:/organizador/{id_organizador}/editar";
			}	
		}
		updateOrganizadorService(organizador, id_organizador);	
		return "redirect:/"+ id_organizador +"/torneio/view";
	}
	@ResponseBody 
	private void updateOrganizadorService(Organizador organizador, long codigoOrganizador) {
		Organizador organizadorUpdate = or.findById(codigoOrganizador); 
		organizadorUpdate.setCpf(organizador.getCpf());
		organizadorUpdate.setEmail(organizador.getEmail());
		organizadorUpdate.setNome(organizador.getNome());
		organizadorUpdate.setSenha(organizador.getSenha());
		//organizadorUpdate.get().setClube(clubeUpdate.getId());
		

		or.save(organizadorUpdate);
	}
}
