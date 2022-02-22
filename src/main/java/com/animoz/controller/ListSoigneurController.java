package com.animoz.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.animoz.modele.Soigneur;
import com.animoz.service.SoigneurService;

@Controller
public class ListSoigneurController {

	@Autowired
	private SoigneurService soigneurService;
	
	
	@GetMapping(path = "/soigneur")
	public String afficherListeSoigneurs(Model model) {
		
		List<Soigneur> ListSoigneurs = soigneurService.getListSoigneur();
		
	      
		model.addAttribute("ListSoigneurs", ListSoigneurs);

		
		// return la page html (La vue)
		return "ListeSoigneurs.html";
	}
}
