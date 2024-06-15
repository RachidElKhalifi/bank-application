package com.corsoSpring.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@RequestMapping("/")
//localhost:8080
public class IndexController {

	//localhost:8080?nome=Mario
	@GetMapping 
	public String getPage(
			Model model, 
			@RequestParam(name = "nome", required = false, defaultValue = ",inserisci un nome nella barra degli indirizzi,\n esempio:localhost:8080/?nome=Mario") String nome
//			@RequestParam(name = "nome", required = false, defaultValue = ", inserisci un nome nella barra degli indirizzi,"+  '/n' +"es.(?nome=mario)") String nome
			) {
		 
		model.addAttribute("nomeDaSalutare", nome);
		return "index";
	}
	
	
}
