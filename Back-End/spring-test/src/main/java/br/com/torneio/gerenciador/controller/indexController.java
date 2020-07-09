package br.com.torneio.gerenciador.controller;
//OKstella_front

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class indexController {
	@RequestMapping("/") 
	public String index() { return("redirect:/organizador/login");}	
}
