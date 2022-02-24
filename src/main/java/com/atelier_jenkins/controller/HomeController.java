package main.java.com.atelier_jenkins.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	// MVC : Controller
	@GetMapping(path = "/")
	public String Home() {
	     
		// return la page html (La vue)
		return "Index";
	}
	
}
