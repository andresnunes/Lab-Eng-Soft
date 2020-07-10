package br.com.torneio.gerenciador.controller;
//OKstella_front

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import br.com.torneio.gerenciador.model.Atleta;
import br.com.torneio.gerenciador.model.Organizador;
import br.com.torneio.gerenciador.model.Torneio;
import br.com.torneio.gerenciador.repository.AtletaRepository;
import br.com.torneio.gerenciador.repository.OrganizadorRepository;
import br.com.torneio.gerenciador.repository.TorneioRepository;

@Controller
@RequestMapping("{id_organizador}/torneio")
public class TorneioController {
	@Autowired
	TorneioRepository tr;
	@Autowired
	OrganizadorRepository or;
	@Autowired
	AtletaRepository ar;

	@GetMapping("/view")
	public ModelAndView listTorneios(@PathVariable("id_organizador") long id_organizador) throws ParseException {
		ModelAndView mv = new ModelAndView("index");
		Optional<Organizador> organizador = or.findById(id_organizador);
		mv.addObject("organizador", organizador);

		Iterable<Torneio> torneios = tr.findByClube(organizador.get().getClube());
		List<Torneio> torneioView = new ArrayList<Torneio>() ;
		
        for(Torneio torneio : torneios) {     	
            Calendar cal = Convert.convertStringToCalendar("yyyy-MM-dd", torneio.getData_inicio());
    		torneio.setData_inicio(Convert.convertCalendarToString("dd/MM/yyyy", cal));
        	torneioView.add(torneio);
        }
		
		mv.addObject("torneios", torneioView);
		return mv;
	}

	@RequestMapping("/cadastrar")
	public ModelAndView formCadastroTorneio(@PathVariable("id_organizador") long id_organizador) {
		ModelAndView mv = new ModelAndView("FormTorneio");
		Optional<Organizador> organizador = or.findById(id_organizador);
		mv.addObject("organizador", organizador);
		return mv;
	}

	@PostMapping("/cadastrar")
	public String saveTorneio(@PathVariable("id_organizador") long id_organizador, @Valid Torneio torneio,
			BindingResult result, RedirectAttributes attributes) throws ParseException {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id_organizador}/torneio/cadastrar";
		}
		saveTorneioService(id_organizador, torneio);
		return "redirect:/{id_organizador}/torneio/view";
	}

	@ResponseBody
	private void saveTorneioService(long id_organizador, Torneio torneio) {
		Optional<Organizador> organizador = or.findById(id_organizador);
		torneio.setClube(organizador.get().getClube());
		tr.save(torneio);
	}

	@RequestMapping("/deletar")
	public String deleteTorneio(@PathVariable("id_organizador") long id_organizador, long id_torneio) {
		deleteTorneioService(id_torneio);
		return "redirect:/{id_organizador}/torneio/view";
	}

	@ResponseBody
	@DeleteMapping("/deletar/{id_torneio}")
	private void deleteTorneioService(@PathVariable("id_torneio") long id_torneio) {
		Torneio torneio = tr.findById(id_torneio);
		tr.delete(torneio);
	}

	// melhoria, o formulario de cadastro e de edição serem o mesmo?
	// para esconder o formulario post teria que fazer o thymeleaf entender pelo
	// request mapping qual formulario ele teria que renderizar na tela
	@RequestMapping("/editar/{id_torneio}")
	public ModelAndView formEditarTorneio(@PathVariable("id_organizador") long id_organizador,
			@PathVariable("id_torneio") long id_torneio) {
		ModelAndView mv = new ModelAndView("Torneio");
		Optional<Organizador> organizador = or.findById(id_organizador);
		mv.addObject("organizador", organizador);
		Torneio torneio = tr.findById(id_torneio);
		mv.addObject("torneio", torneio);
		List<Atleta> atletas1 = torneio.getAtletasParticipantes();// tr.findByAtletasParticipantes(torneio);
		mv.addObject("atletas1", atletas1);
		List<Atleta> atletas2 = ar.findAll();
		atletas2.removeAll(atletas1);
		mv.addObject("atletas2", atletas2);
		return mv;
	}

	@PostMapping("/editar/{id_torneio}")
	public String updateTorneio(@PathVariable("id_organizador") long id_organizador,
			@PathVariable("id_torneio") long id_torneio, @Valid Torneio torneio, BindingResult result,
			RedirectAttributes attributes) throws ParseException {
		if (result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/{id_organizador}/torneio/editar/{id_torneio}";
		}
		updateTorneioService(id_torneio, torneio);
		return "redirect:/{id_organizador}/torneio/view";
	}

	
	@ResponseBody// @PutMapping("/editar/{id_torneio}")
	private void updateTorneioService(long id_torneio, Torneio torneio) {
		Torneio torneioUpdated = tr.findById(id_torneio);
		torneioUpdated.setData_inicio(torneio.getData_inicio());
		tr.save(torneioUpdated);
	}

	@RequestMapping("/editar/{id_torneio}/atleta/{id_atleta}") // id de atleta em path, pra funcionar no postman
	public String saveAtletaTorneio(@PathVariable("id_organizador") long id_organizador,
			@PathVariable("id_torneio") long id_torneio, @PathVariable("id_atleta") long id_atleta) {
		saveAtletaTorneioService(id_torneio, id_atleta);
		return "redirect:/{id_organizador}/torneio/editar/{id_torneio}";
	}

	@ResponseBody
	private void saveAtletaTorneioService(long id_torneio, long id_atleta) {
		Torneio torneio = tr.findById(id_torneio);
		Atleta atleta = ar.findById(id_atleta);
		List<Atleta> atletas = torneio.getAtletasParticipantes();
		atletas.add(atleta);
		torneio.setAtletasParticipantes(atletas);
		tr.save(torneio);
	}

	@RequestMapping("/editar/{id_torneio}/atleta")
	public String deleteAtletaTorneio(@PathVariable("id_organizador") long id_organizador,
			@PathVariable("id_torneio") long id_torneio, long id_atleta) {
		deleteAtletaTorneioService(id_torneio, id_atleta);
		return "redirect:/{id_organizador}/torneio/editar/{id_torneio}";
	}

	@ResponseBody
	private void deleteAtletaTorneioService(long id_torneio, long id_atleta) {
		Torneio torneio = tr.findById(id_torneio);
		Atleta atleta = ar.findById(id_atleta);
		List<Atleta> atletas = torneio.getAtletasParticipantes();
		atletas.remove(atleta);
		tr.save(torneio);
	}

}
