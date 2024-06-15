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

import com.corsoSpring.model.ContoCorrente;
import com.corsoSpring.model.Filiale;
import com.corsoSpring.model.Persona;
import com.corsoSpring.service.CcService;
import com.corsoSpring.service.FilialeService;
import com.corsoSpring.service.PersonaService;

@Controller
@RequestMapping("/gestioneCc")
public class ContiCorrentiController {
	
	@Autowired
	private FilialeService filialeService;
	@Autowired
	private CcService ccService;
	@Autowired
	private PersonaService personaService;
	private Integer idPerModifica;

	@GetMapping 
	public String index(Model model) {
		model.addAttribute("listaCc",ccService.getCc());
		
		return "gestioneCc";
	}
	
	//localhost/gestioneCc/formCc GET
			@GetMapping("/formCc")
			public String getForm (Model model, @RequestParam(name="id", required = false) Integer id) {
ContoCorrente cc = (id == null) ? new ContoCorrente() : ccService.getCcById(id);
idPerModifica = id;

				List<Filiale> filiali = filialeService.getFiliali();
				List<Persona> persone = personaService.getPersone();
				
				model.addAttribute("cc", cc);
				model.addAttribute("filiali", filiali);
				model.addAttribute("persone", persone);

				return "formCc"; 
			}
			
			@PostMapping("/salvaCc")
			public String salvaCc(@ModelAttribute("cc") ContoCorrente ccDaSalvare) {
				if(idPerModifica!=null) {
					ccDaSalvare.setId(idPerModifica);
				ccService.salva(ccDaSalvare);
				}
				else 
					ccService.salva(ccDaSalvare);
					 return "redirect:/gestioneCc";
			}
			
			//localhost/gestioneCc/delete/ID GET
			@GetMapping("/delete")
			public String deleteCcById(@RequestParam(name = "id") int id) { 
				ccService.cancella(id);
				return "redirect:/gestioneCc";
			}


}
