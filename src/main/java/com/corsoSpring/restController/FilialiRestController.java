package com.corsoSpring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsoSpring.model.Filiale;
import com.corsoSpring.service.FilialeService;
import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 

@RestController
@RequestMapping("/api/gestioneFiliali")
public class FilialiRestController {
	
	
	@Autowired
	private FilialeService filialeService;
	
	@GetMapping("/lista")
	 public List<Filiale> getFiliali() {
		return filialeService.getFiliali();
	}
	
	//view by id (dettaglio)
		//endpoint http://localhost/api/gestioneFiliali/dettaglio/ID
		@GetMapping("/dettaglio/{id}")
		public Filiale getFilialeById(@PathVariable("id") int id) {
			return filialeService.getFilialeById(id);
		}
		
		
		//endpoint http://localhost/api/gestioneFiliali/salva
		//input (request body) Filiale filiale
		@PostMapping("/salva")
		public Filiale creaFiliale(@RequestBody Filiale filialeDaSalvare) {
			return filialeService.salva(filialeDaSalvare);
		}
		
		
		//endpoint http://localhost/api/gestioneFiliali/elimina/ID
		
		@DeleteMapping("/elimina/{id}")
		public ObjectNode eliminaFiliale(@PathVariable("id") int id ) {
			 ObjectNode res = filialeService.cancella(id);
			 return res;
		}
	}

	


