package com.corsoSpring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsoSpring.model.Citta;
import com.corsoSpring.service.CittaService;
import com.fasterxml.jackson.databind.node.ObjectNode;

@RestController
@RequestMapping("/api/gestioneCitta")
public class CittaRestController {
	
	@Autowired
	private CittaService cittaService;
	
	@GetMapping("/lista")
	public List<Citta> getCitta() {
		return cittaService.getCitta();
		
	}

	//view by id (dettaglio)
		//endpoint http://localhost/api/gestioneCitta/dettaglio/ID
		@GetMapping("/dettaglio/{id}")
		public Citta getCittaById(@PathVariable("id") int id) {
			return cittaService.getCittaById(id);
		}
		
		
		//endpoint http://localhost/api/gestioneCitta/salva
		//input (request body) Citta citta
		@PostMapping("/salva")
		public Citta creaCitta(@RequestBody Citta cittaDaSalvare) {
			return cittaService.salva(cittaDaSalvare);
		}
		
		
		//endpoint http://localhost/api/gestioneCitta/elimina/ID
		
		@DeleteMapping("/elimina/{id}")
		public ObjectNode eliminaCitta(@PathVariable("id") int id ) {
			 ObjectNode res = cittaService.cancella(id);
			 return res;
		}
	}

