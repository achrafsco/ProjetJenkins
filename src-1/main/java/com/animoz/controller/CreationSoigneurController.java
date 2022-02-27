package com.animoz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.animoz.service.CreateSoigneurService;
import com.animoz.service.RechercheAnimalService;

@Controller
public class CreationSoigneurController {
	
	@Autowired
	private CreateSoigneurService createSoigneurService;
	
	// MVC : Controller
	@GetMapping(path = "/createsoigneur")
	public String getCreateSoigneur(@ModelAttribute("soigneur") SoigneurDto soigneur, Model model) {
		// return la page html (La vue)
		
		// createSoigneurService.setSoigneurCreate(soigneur.getNom(), soigneur.getNumero(), soigneur.getDateDeRecrutement()); //animal.getNom()
		
		//model.addAttribute("NomAnimal", rechercheAnimalService.getAnimalRecherche());
		
		//System.out.println("###### Date => " + soigneur.getDaterecrutement());
		
		// System.out.println("###### Date => " + soigneur.getDate());
		
		createSoigneurService.InitValidCreate();
		
		if (createSoigneurService.getValidCreate() == true) {
			
			model.addAttribute("Validation", "Creation validée !");
			System.out.println("###### TRUE ");
		} else {
			System.out.println("###### ELSE ");
			model.addAttribute("Validation", null);
			
		}
		
		System.out.println("###### Validation => " + createSoigneurService.getValidCreate());
		
		return "CreationSoigneur";
	}
	
	
	// MVC : Controller
	@PostMapping(path = "/createsoigneur")
	public String setCreateSoigneur(@Validated @ModelAttribute("soigneur") SoigneurDto soigneur, BindingResult bindingResult, Model model) {
	    
		if(bindingResult.hasErrors()) {
			return getCreateSoigneur(soigneur, model);
	    	 
	     }
		
		
		
		// model.addAttribute("NomAnimal", null);
		createSoigneurService.setSoigneurCreate(soigneur.getNom(), soigneur.getNumero(), soigneur.getDate()); //animal.getNom()
		
		System.out.println("###### Validation => " + createSoigneurService.getValidCreate());
		
		if (createSoigneurService.getValidCreate() == true) {
			
			model.addAttribute("Validation", "Creation validée !");
			System.out.println("###### TRUE ");
		} else {
			System.out.println("###### ELSE ");
			model.addAttribute("Validation", null);
			
		}
		// System.out.println("###### Date => " + soigneur.getDateDeRecrutement());
		
		// getCreateSoigneur(soigneur);
		
		// return la page html (La vue)
		return "CreationSoigneur";
	}
	
}
