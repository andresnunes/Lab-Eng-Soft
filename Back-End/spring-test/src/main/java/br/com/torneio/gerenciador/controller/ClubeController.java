package br.com.torneio.gerenciador.controller;
//OKstella_front

import java.text.ParseException;
import java.util.ArrayList;
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
import br.com.torneio.gerenciador.form.OrganizadorForm2;
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
            //attributes.addFlashAttribute("mensagem", "Verifique os campos");
            attributes2.addFlashAttribute("mensagem", "Verifique os campos");
            return ("redirect:/clube/signup");
        }
		//BUSCAR EMAIL NO BANCO, SE REPETIDO
		//BUSCAR CNPJ NO BANCO, SE REPETIDO
		List<Clube> clubes = cr.findAll();
		for(Clube clubeBanco : clubes) {
			if(clubeBanco.getCnpj().intern()==clube.getCnpj().intern()) {
				attributes2.addFlashAttribute("mensagem", "CNPJ já cadastrado");
				return  ("formClube");
			}
			if(clubeBanco.getEmailClube().intern()==clube.getEmailClube().intern()) {
				attributes2.addFlashAttribute("mensagem", "Email já cadastrado");
	            return ("redirect:/clube/signup");
			}	
		}
		//BUSCAR EMAIL NO BANCO, SE REPETIDO
		//BUSCAR CPF NO BANCO, SE REPETIDO
		List<Organizador> organizadores = or.findAll();
		for(Organizador organizadorBanco : organizadores) {
			if(organizadorBanco.getCpf().intern()==organizador.getCpf().intern()) {
				attributes2.addFlashAttribute("mensagem", "CPF já cadastrado");
	            return  ("redirect:/clube/signup"); 
			}
			if(organizadorBanco.getEmail().intern()==organizador.getEmail().intern()) {
				attributes2.addFlashAttribute("mensagem", "Email já cadastrado");
	            return  ("redirect:/clube/signup");
			}	
		}
		saveClubeService(clube, organizador);	
		return ("redirect:/"+ organizador.getId() +"/torneio/view");
	}
	@ResponseBody
	private void saveClubeService(Clube clube, Organizador organizador) {
		cr.save(clube);	
		organizador.setClube(clube);
		or.save(organizador);
	}
	
	@RequestMapping("/{id_organizador}/editar")
	public ModelAndView formClube(@PathVariable("id_organizador") long id_organizador) throws ParseException{
		ModelAndView mv = new ModelAndView("Clube");
		Organizador organizador = or.findById(id_organizador);
		mv.addObject("organizador",organizador);
		Clube clube = organizador.getClube();
		mv.addObject("clube",clube);
		Iterable<Torneio> torneios = clube.getTorneios();
		mv.addObject("torneios", Convert.ordenarTorneioDataBS(torneios));
		
		
		//Iterable<Torneio> torneiosV =  torneios;
		List<Torneio> torneiosVencidos = new ArrayList<Torneio>();
		
		for(Torneio torneio : torneios){
			Optional<Atleta> av = Optional.ofNullable(torneio.getAtletaVencedor());
		
			//se torneio tem um vencedor
			if(av.isPresent() && av.get().getClube()==clube) {
				torneiosVencidos.add(torneio);
			}			
		}
		mv.addObject("torneiosVencidos", torneiosVencidos);
		return mv;	
	}
	//redirecionamento para ficha do torneio
	@RequestMapping("/{id_organizador}/editar/{id_torneio}")
	public String formClubeR(@PathVariable("id_organizador") long id_organizador, @PathVariable long id_torneio) {
		return"redirect:/{id_organizador}/torneio/editar/"+id_torneio;		
	}
	

	@PostMapping("/{id_organizador}/editar")
	public String updateClube(@PathVariable("id_organizador") long id_organizador, @Valid Clube clube, BindingResult result, RedirectAttributes attributes, @Valid OrganizadorForm2 organizador, BindingResult result2, RedirectAttributes attributes2){
		if(result.hasErrors() || result2.hasErrors()){
            attributes2.addFlashAttribute("mensagem", "Verifique os campos"); //!
            return "redirect:/clube/{id_organizador}/editar";
        }
		//BUSCAR CNPJ NO BANCO, SE REPETIDO, e ele nao for da entidade que eu to querendo atualizar
		//BUSCAR EMAIL NO BANCO, SE REPETIDO
		List<Clube> clubes = cr.findAll();
		//clubes.remove(clube);
		clubes.remove(or.findById(id_organizador).getClube());
		for(Clube clubeBanco : clubes) {
			if(clubeBanco.getCnpj().intern()==clube.getCnpj().intern()) {
				attributes2.addFlashAttribute("mensagem", "CNPJ já cadastrado");
				return "redirect:/clube/{id_organizador}/editar";
			}
			if(clubeBanco.getEmailClube().intern()==clube.getEmailClube().intern()) {
				attributes2.addFlashAttribute("mensagem", "Email já cadastrado");
	            return "redirect:/clube/{id_organizador}/editar";
			}	
		}
		Organizador organizadorUpdated = or.findById(id_organizador);
		updateClubeService(clube, organizadorUpdated.getClube().getId(), organizador, id_organizador);	
		return "redirect:/"+ id_organizador +"/torneio/view";
	}
	@ResponseBody 
	private void updateClubeService(Clube clube, long codigoClube, OrganizadorForm2 organizador, long codigoOrganizador) {
		
		Clube clubeUpdate = cr.findById(codigoClube);
		clubeUpdate.setCnpj(clube.getCnpj());
		clubeUpdate.setEmailClube(clube.getEmailClube());
		clubeUpdate.setEndereco(clube.getEndereco());
		clubeUpdate.setNomeClube(clube.getNomeClube());
		//clubeUpdate.setOrganizador(organizadorUpdate.getId()); no caso many to one
		
		Organizador organizadorUpdate = or.findById(codigoOrganizador); 
		//organizadorUpdate.setCpf(organizador.getCpf());
		//organizadorUpdate.setEmail(organizador.getEmail());
		organizadorUpdate.setNome(organizador.getNome());
		organizadorUpdate.setSenha(organizador.getSenha());
		//organizadorUpdate.get().setClube(clubeUpdate.getId());
		
		//mais seguro essa trabalhera de codigo porque se criar algum campo no banco que nao entrar no formulario nao precisa ficar arrumando
		//organizador.setId(codigoOrganizador);	NAO NAO NAO
		//or.save(organizador);                 NAO
		
		//or.save(organizadorUpdate); //??nao precisa dar save??
		cr.save(clubeUpdate);	
	}
}
	
