package br.com.torneio.gerenciador.controller;

import java.util.List;
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

import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
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
	@Autowired
	AtletaRepository ar;

	@GetMapping("/view")
	public ModelAndView listTorneios(@PathVariable("id_organizador") long id_organizador){
		ModelAndView mv = new ModelAndView("index");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);
		
		Iterable<Torneio> torneios = tr.findByClube(organizador.get().getClube());
		mv.addObject("torneios", torneios);
		System.out.println("O organizador de id " + organizador.get().getId() + " acessou o painel de torneios"); 
		return mv;
	}

	@RequestMapping("/cadastrar")
	public ModelAndView formCadastroTorneio(@PathVariable("id_organizador") long id_organizador) {
		ModelAndView mv = new ModelAndView("FormTorneio");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);
		System.out.println("O organizador de id " + id_organizador +" acessou o formulario de cadastro de torneio"); 
		return mv;
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

	@GetMapping("/deletar")
    public String deleteTorneio(@PathVariable("id_organizador") long id_organizador, long codigoTorneio){
        Torneio torneio = tr.findById(codigoTorneio);
        tr.delete(torneio);
        return "redirect:/{id_organizador}/torneio/view";
    }

	// melhoria, o formulario de cadastro e de edição serem o mesmo?
	//para esconder o formulario post teria que fazer o thymeleaf entender pelo request mapping qual formulario ele teria que renderizar na tela
	//nao temos tempo, ô rolé, fica pra proxima versão
	@RequestMapping("/editar/{id_torneio}") // se tiver tempo mais facil criar outro html com o put no form e tentar puxar os dados
	public ModelAndView formEditarTorneio(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio")  long id_torneio) {
		ModelAndView mv = new ModelAndView("Torneio");
		Optional<Organizador> organizador = or.findById(id_organizador);
        mv.addObject("organizador", organizador);         
		Torneio torneio = tr.findById(id_torneio);
		mv.addObject("torneio", torneio);
		List<Atleta> atletas1 = torneio.getAtletasParticipantes();//tr.findByAtletasParticipantes(torneio);
		mv.addObject("atletas1", atletas1);
		List<Atleta> atletas2 = ar.findAll();
		atletas2.removeAll(atletas1);
		mv.addObject("atletas2", atletas2);
		return mv;
	}
	
	//metodo PUT, nao upava, resolver depois	
	@PostMapping("/editar/{id_torneio}")
	public String updateTorneio(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio") long id_torneio, @Valid Torneio torneio, BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()){
            attributes.addFlashAttribute("mensagem", "Verifique os campos");
            System.out.println("O organizador de id " + id_organizador +" falhou em editar o torneio de id " + torneio.getId()); 
        return "redirect:/{id_organizador}/torneio/editar/{id_torneio}";
        }	
		Torneio torneioUpdated = tr.findById(id_torneio);
		torneioUpdated.setData_inicio(torneio.getData_inicio());
        tr.save(torneioUpdated);
        System.out.println("O organizador de id " + id_organizador +" atualizou torneio com data em " + torneio.getData_inicio()); 
        return "redirect:/{id_organizador}/torneio/view";	
	}

	
	@RequestMapping("/editar/{id_torneio}/atleta/{id_atleta}") //id de atleta em path, pra funcionar no postman
	public String saveAtletaTorneio(@PathVariable("id_organizador") long id_organizador, @PathVariable("id_torneio") long id_torneio, @PathVariable("id_atleta") long id_atleta) {
		Torneio torneio = tr.findById(id_torneio);
		Atleta atleta = ar.findById(id_atleta);
		List<Atleta> atletas = torneio.getAtletasParticipantes(); 
		atletas.add(atleta);
		System.out.println(atletas);
		torneio.setAtletasParticipantes(atletas);
		tr.save(torneio);
		return "redirect:/{id_organizador}/torneio/editar/{id_torneio}";
	}

	//GERAR LISTAGEM https://www.thymeleaf.org/doc/tutorials/2.1/thymeleafspring.html
	
	//https://stackoverflow.com/questions/24256051/delete-or-put-methods-in-thymeleaf	
	
	
	
	
	
	
}
