package com.animoz.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.animoz.modele.Animal;

@Controller
public class HomeController {

	// MVC : Controller
	@GetMapping(path = "/")
	public String Home() {
	     
		// return la page html (La vue)
		return "Index";
	}
	
}
