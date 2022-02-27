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

import com.animoz.modele.Espece;
import com.animoz.service.CreateAnimauxService;
import com.animoz.service.CreateSoigneurService;
import com.animoz.service.RechercheAnimalService;

@Controller
public class CreationAnimauxController {
	
	@Autowired
	private CreateAnimauxService createAnimauxService;
	
	// MVC : Controller
	@GetMapping(path = "/createanimaux")
	public String getCreateAnimaux(@ModelAttribute("createanimaux") AnimalDto animal, Model model) {
		// return la page html (La vue)
		
		//animal.getNom()
		
		//model.addAttribute("NomAnimal", rechercheAnimalService.getAnimalRecherche());
		if(createAnimauxService.getNameFound() == false) {
					
			// model.addAttribute("NomAnimal", null);
			
			model.addAttribute("notFound", "L'animal : { " + animal.getNom() + " } est deja existant !");
			
			System.out.println("############ NOT FOUND ###########");
			
		} else {
			
		}
		
		return "CreationAnimaux";
	}
	
	
	// MVC : Controller
	@PostMapping(path = "/createanimaux")
	public String setCreateAnimaux(@Validated @ModelAttribute("createanimaux") AnimalDto animal, BindingResult bindingResult, Model model) {
	    
		if(bindingResult.hasErrors()) {
			// return getCreateSoigneur(animal);
	    	 
	     }
		
		model.addAttribute("notFound", "");
		
		Espece espece = new Espece();
		
		espece.setId(animal.getEspece());
		
		createAnimauxService.setAnimauxCreate(animal.getNom(), animal.getDescription(), animal.getRegime(), espece);
		//model.addAttribute("NomAnimal", null);
		//createSoigneurService.setSoigneurCreate(soigneur.getNom(), soigneur.getNumero(), soigneur.getDateDeRecrutement()); //animal.getNom()
	    
		getCreateAnimaux(animal, model);
		
		// return la page html (La vue)
		return "CreationAnimaux";
	}
	
}
