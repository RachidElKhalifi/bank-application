package com.corsoSpring.controller;
 

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.corsoSpring.model.Banca;
import com.corsoSpring.model.Citta;
import com.corsoSpring.model.Filiale;
import com.corsoSpring.model.Persona;
import com.corsoSpring.service.BancaService;
import com.corsoSpring.service.CittaService;
import com.corsoSpring.service.FilialeService;
import com.corsoSpring.service.PersonaService;
 

@Controller
@RequestMapping("/gestioneFiliali")
public class FilialiController {
	
	@Autowired
	private FilialeService filialeService;
	@Autowired
	private BancaService bancaService;
	@Autowired
	private CittaService cittaService;
	@Autowired
	private PersonaService personaService;
	private Integer idPerModifica;

	
	@GetMapping 
	public String index(Model model) {
		model.addAttribute("listaFiliali",filialeService.getFiliali());
		
		return "gestioneFiliali";
	}
	
	//localhost/gestioneFiliali/formFiliale GET
			@GetMapping("/formFiliale")
			public String getForm (Model model, @RequestParam(name="id", required = false) Integer id) {
				Filiale filiale = (id == null) ? new Filiale() : filialeService.getFilialeById(id);
				idPerModifica = id;
				List<Banca> banche = bancaService.getBanche();
				List<Citta> cities = cittaService.getCitta();
				List<Persona> persone = personaService.getPersone();

				model.addAttribute("filiale", filiale);
				model.addAttribute("banche", banche);
				model.addAttribute("cities", cities);
				model.addAttribute("persone", persone);

				return "formFiliale"; 
			}
			
			@PostMapping("/salvaFiliale")
			public String salvaFiliale(@ModelAttribute("filiale") Filiale filialeDaSalvare) {
				if(idPerModifica!=null) {
					filialeDaSalvare.setId(idPerModifica); 
					filialeService.salva(filialeDaSalvare); 
					 return "redirect:/gestioneFiliali";
				}
				else
					filialeService.salva(filialeDaSalvare); 
				 return "redirect:/gestioneFiliali";	
			}
			//localhost/gestioneFiliali/delete/ID GET
			@GetMapping("/delete")
			public String deleteFilialeById(@RequestParam(name = "id") int id) { 
				filialeService.cancella(id);
				return "redirect:/gestioneFiliali";
			}


}
