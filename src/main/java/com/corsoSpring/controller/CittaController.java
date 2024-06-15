package com.corsoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsoSpring.service.CittaService;
import org.springframework.ui.Model;
import com.corsoSpring.model.Citta;

@Controller
@RequestMapping("/gestioneCitta")
public class CittaController {
	
	@Autowired
	private CittaService cittaService;
	
	private Integer idPerModifica;
	
	@GetMapping
	public String index(Model model) {
		model.addAttribute("listaCitta", cittaService.getCitta());
		return "gestioneCitta";		
	}
	
	//localhost/gestioneCitta/formCitta GET
	@GetMapping("/formCitta")
	public String getForm (Model model, @RequestParam(name="id", required = false) Integer id) {
		Citta citta = (id == null) ? new Citta() : cittaService.getCittaById(id);
		idPerModifica = id;
		model.addAttribute("citta", citta);
		return "formCitta";
	}
	
	//localhost/gestioneCitta/salvaCitta POST    metodo salva originale
//	@PostMapping("/salvaCitta")
//	public String saveCitta(@ModelAttribute("citta") Citta cittaDaSalvare) {
//		cittaService.salva(cittaDaSalvare);
//		return "redirect:/gestioneCitta";
//	}
	
	//localhost/gestioneCitta/salvaCitta POST    metodo modificato che fa da save e da update
		@PostMapping("/salvaCitta")
		public String saveCitta(@ModelAttribute("citta") Citta cittaDaSalvare) {
			if(idPerModifica!=null) {
				cittaDaSalvare.setId(idPerModifica);
				cittaService.salva(cittaDaSalvare);
			return "redirect:/gestioneCitta";
			}
			else {
			cittaService.salva(cittaDaSalvare);
			return "redirect:/gestioneCitta";
			}
		}

	//localhost/gestioneCitta/delete/ID GET
	@GetMapping("/delete")
	public String deleteCittaById(@RequestParam(name = "id") int id) { 
		cittaService.cancella(cittaService.getCittaById(id));
		return "redirect:/gestioneCitta";
	}
}
	
