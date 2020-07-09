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
	
