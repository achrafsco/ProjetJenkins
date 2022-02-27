package com.animoz.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Consumer;

import javax.persistence.NoResultException;

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
import org.springframework.web.servlet.ModelAndView;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Soigneur;
import com.animoz.service.AnimalService;
import com.animoz.service.RechercheAnimalService;
import com.animoz.service.SoigneurService;

@Controller
public class ListeAnimalController {

	@Autowired
	private AnimalService animalService;
	
	@Autowired
	private SoigneurService soigneurService;
	
	@Autowired
	private RechercheAnimalService rechercheAnimalService;
	
	//Boolean errors = false;
	
	
	// Exo 3 (utiliser que la method get - essayer)
	// MVC : Controller
	@GetMapping(path = "/animaux")
	public String afficherListeAnimaux(@ModelAttribute("animal") AnimalDto animal, Model model) {
		
		List<Animal> animaux = animalService.getListeAnimaux();
		
	    model.addAttribute("ListAnimaux", animaux); 
		// return la page html (La vue)
		return "ListeAnimaux";
	}
	
	// MVC : Controller
	@PostMapping(path = "/animaux")
	public String afficherListeAnimauxPost(@ModelAttribute("animal") AnimalDto animal, Model model) {
		
		List<Animal> animaux = animalService.getListeAnimaux();
	    
		List<Soigneur> soigneur = soigneurService.getListSoigneur();
		
		List<Soigneur> soigneurNom = new ArrayList<Soigneur>();
		
		/*LocalDate dateNow = LocalDate.now();
		
		DateTimeFormatter Format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		String dateNowF = dateNow.format(Format);*/
		
		if (animal.getnomSoigneur() != null) {
			soigneurService.SupprSoigneur(animal.getnomSoigneur());
		}
		
		for (Soigneur S : soigneur) {
			
			// System.out.println(S.getNumero().substring(4) + " // " + animal.getEspeceID());
			
			if(S.getNumero().substring(4).equals(animal.getEspeceID())) {
				soigneurNom.add(S);
			}

		}
		
	    
	    // System.out.println(animal.getNom());
		
	    // System.out.println("##### Soigneur => " + animal.getnomSoigneur());
		
	    model.addAttribute("ListAnimaux", animaux); 
	    
	    model.addAttribute("nom", animal.getNom());
	    
	    model.addAttribute("description", animal.getDescription());
	    
	    model.addAttribute("regime", animal.getRegime());
	    
	    model.addAttribute("especeNom", animal.getEspeceNom());
	    
	    model.addAttribute("soigneur", soigneurNom);
	    
	    // model.addAttribute("dateRecrutement", dateNowF);
	     
		// return la page html (La vue)
		return "ListeAnimaux";
	}
	
	// MVC : Controller
	@GetMapping(path = "/animal")
	public String afficherResultatAnimal(@ModelAttribute("animal") AnimalDto animal, Model model) {
		// return la page html (La vue)
		
		System.out.println("############ RECHERCHE ########### -> " + rechercheAnimalService.getAnimalRecherche());
		
		if(rechercheAnimalService.AppelNotFound() == true) {
			
			model.addAttribute("NomAnimal", null);
			
			model.addAttribute("notFound", "L'animal : { " + animal.getNom() + " } est introuvable !");
			
			System.out.println("############ NOT FOUND ###########");
			
		} else {
		
			model.addAttribute("NomAnimal", rechercheAnimalService.getAnimalRecherche());
			
		}

		//model.addAttribute("NomAnimal", rechercheAnimalService.getAnimalRecherche());
		
		return "ListeAnimauxRecherche";
	}
	
	// MVC : Controller
	@PostMapping(path = "/animal")
	public String RecupererAnimal(@Validated @ModelAttribute("animal") AnimalDto animal, BindingResult bindingResult, Model model) {
	     
		if(bindingResult.hasErrors()) {
			model.addAttribute("NomAnimal", null); 
			return afficherResultatAnimal(animal, model);
	     }
	    
		//model.addAttribute("NomAnimal", null);
		rechercheAnimalService.setNomAnimalRecherche(animal.getNom()); //animal.getNom()
	     
	    afficherResultatAnimal(animal, model);
	     
		// return la page html (La vue)
		return "ListeAnimauxRecherche";
	}

}
