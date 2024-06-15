package com.corsoSpring.restController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.corsoSpring.model.ContoCorrente;
import com.corsoSpring.service.CcService;

import com.fasterxml.jackson.databind.node.ObjectNode;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody; 

@RestController
@RequestMapping("/api/gestioneCc")
public class CcRestController {
	
	
	@Autowired
	private CcService ccService;
	
	@GetMapping("/lista")
	 public List<ContoCorrente> getCc() {
		return ccService.getCc();
	}
	
	//view by id (dettaglio)
		//endpoint http://localhost/api/gestioneCc/dettaglio/ID
		@GetMapping("/dettaglio/{id}")
		public ContoCorrente getCcById(@PathVariable("id") int id) {
			return ccService.getCcById(id);
		}
		
		
		//endpoint http://localhost/api/gestioneCc/salva
		//input (request body) Contocorrente contocorrente
		@PostMapping("/salva")
		public ContoCorrente creaCc(@RequestBody ContoCorrente ccDaSalvare) {
			return ccService.salva(ccDaSalvare);
		}
		
		
		//endpoint http://localhost/api/gestioneCc/elimina/ID
		
		@DeleteMapping("/elimina/{id}")
		public ObjectNode eliminaCc(@PathVariable("id") int id ) {
			 ObjectNode res = ccService.cancella(id);
			 return res;
		}
		
		
		
		
		 

	}

	


