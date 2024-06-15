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

import com.corsoSpring.model.Banca;
import com.corsoSpring.service.BancaService;
import com.fasterxml.jackson.databind.node.ObjectNode;
 

@RestController
@RequestMapping("/api/gestioneBanche")
public class BancheRestController {
	
	@Autowired
	private BancaService bancaService;
	  
	//lista banche
	//endpoint http://localhost/api/gestioneBanche/lista
	@GetMapping("/lista") 
	public List<Banca> getBanche() {
		return bancaService.getBanche();
	}
	
	
	//view by id (dettaglio)
	//endpoint http://localhost/api/gestioneBanche/dettaglio/ID
	@GetMapping("/dettaglio/{id}")
	public Banca getBancaById(@PathVariable("id") int id) {
		return bancaService.getBancaById(id);
	}
	
	
	//endpoint http://localhost/api/gestioneBanche/salva
	//input (request body) Banca banca
	@PostMapping("/salva")
	public Banca creaBanca(@RequestBody Banca bancaDaSalvare) {
		return bancaService.salva(bancaDaSalvare);
	}
	
	
	//endpoint http://localhost/api/gestioneBanche/elimina/ID
	@DeleteMapping("/elimina/{id}")
	public ObjectNode eliminaBanca(@PathVariable("id") int id ) {
		 ObjectNode res = bancaService.cancella(id);
		 return res;
	}
	
	
	
	
	 

}
