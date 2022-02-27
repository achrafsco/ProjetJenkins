package com.animoz.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.animoz.service.CreateSoigneurService;

@Controller
public class ModifierSoigneursController {

	@Autowired
	private CreateSoigneurService createSoigneurService;
	
	/*@PostMapping(path = "/animaux")
	public String ModifSoigneur(@ModelAttribute("animal") SoigneurDto soigneur, Model model) {
		
		
		return "ListeAnimaux";
	}*/
}
