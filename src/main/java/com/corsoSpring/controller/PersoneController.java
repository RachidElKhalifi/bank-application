package com.corsoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsoSpring.model.Citta;
import com.corsoSpring.model.Persona;
import com.corsoSpring.service.CittaService;
import com.corsoSpring.service.PersonaService;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequestMapping("/gestioneUtenti")
public class PersoneController {
	
	@Autowired
	private PersonaService personaService;
	@Autowired
	private CittaService cittaService;
	private Integer idPerModifica;

	@GetMapping
	public String index(Model model) {
		model.addAttribute("listaPersone",personaService.getPersone());
		return "gestioneUtenti";
	}
	
	//localhost/gestioneUtenti/formUtente GET
		@GetMapping("/formUtente")
		public String getForm (Model model, @RequestParam(name="id", required = false) Integer id) {
			Persona persona = (id == null) ? new Persona() : personaService.getPersonaById(id);
			idPerModifica = id;

			List<Citta> cities = cittaService.getCitta();
			
			model.addAttribute("persona", persona);
			
			model.addAttribute("cities", cities);
			return "formUtente"; 
		}
		
		
		@PostMapping("/salvaPersona")
		public String salvaPersona(@ModelAttribute("persona") Persona personaDaSalvare) {
			if(idPerModifica!=null) {
				personaDaSalvare.setId(idPerModifica);
				personaService.salva(personaDaSalvare);
			return "redirect:/gestioneUtenti";
			}
			else {
				personaService.salva(personaDaSalvare);
			return "redirect:/gestioneUtenti";
			}
		}
		//localhost/gestioneCitta/delete/ID GET
		@GetMapping("/delete")
		public String deletePersonaById(@RequestParam(name = "id") int id) { 
			personaService.cancella(personaService.getPersonaById(id));
			return "redirect:/gestioneUtenti";
		}

		
	
	
	
}
