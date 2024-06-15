package com.corsoSpring.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsoSpring.model.Banca;
import com.corsoSpring.service.BancaService;
 

@Controller
@RequestMapping("/gestioneBanche")
public class BancheController {
	
	@Autowired
	private BancaService bancaService;
	
	private Integer idPerModifica;
	
	@GetMapping 
	public String index(Model model) {	
		model.addAttribute("listaBanche", bancaService.getBanche());
		return "gestioneBanche";
	}
	 

	//localhost/gestioneBanche/formBanca GET
		@GetMapping("/formBanca")
		public String getForm (Model model, @RequestParam(name="id", required = false) Integer id) {
			idPerModifica=id;
			Banca banca = (id == null) ? new Banca() : bancaService.getBancaById(id);
			model.addAttribute("banca", banca);
			return "formBanca";
		}
		
		//localhost/gestioneBanche/salvaBanca POST
		@PostMapping("/salvaBanca")
		public String saveBanca
		(@ModelAttribute("banca") Banca bancaDaSalvare) {
			if(idPerModifica!=null) {
				bancaDaSalvare.setId(idPerModifica);
				bancaService.salva(bancaDaSalvare);
				return "redirect:/gestioneBanche";
			}
			else {
				bancaService.salva(bancaDaSalvare);
				return "redirect:/gestioneBanche";
			}
				
		
		}
		
		//localhost/gestioneBanche/delete/ID GET
		@GetMapping("/delete")
		public String deleteBancaById(@RequestParam(name = "id") int id) { 
			bancaService.cancella(bancaService.getBancaById(id));
			return "redirect:/gestioneBanche";
		}

		

	}
		
