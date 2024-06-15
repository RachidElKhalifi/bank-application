package com.corsoSpring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsoSpring.model.Persona;
import com.corsoSpring.service.PersonaService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 

@RestController
@RequestMapping("/api/gestioneUtenti")
public class PersoneRestController {
	
	
	@Autowired
	private PersonaService personaService;
	
	@GetMapping("/lista")
	 public List<Persona> getPersone() {
		return personaService.getPersone();
	}
	
	//view by id (dettaglio)
		//endpoint http://localhost/api/gestioneUtenti/dettaglio/ID
		@GetMapping("/dettaglio/{id}")
		public Persona getBancaById(@PathVariable("id") int id) {
			return personaService.getPersonaById(id);
		}
		
		
		//endpoint http://localhost/api/gestioneUtenti/salva
		//input (request body) Persona persona
		@PostMapping("/salva")
		public Persona creaPersona(@RequestBody Persona personaDaSalvare) {
			return personaService.salva(personaDaSalvare);
		}
		
		
		//endpoint http://localhost/api/gestioneUtenti/elimina/ID
		
		@DeleteMapping("/elimina/{id}")
		public ObjectNode eliminaPersona(@PathVariable("id") int id ) {
			 ObjectNode res = personaService.cancella(id);
			 return res;
		}	 

	}

	


