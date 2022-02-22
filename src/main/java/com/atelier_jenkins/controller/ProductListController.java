package com.atelier_jenkins.controller;

import com.atelier_jenkins.modele.Product;
import com.atelier_jenkins.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Controller
public class ProductListController {

	@Autowired
	private ProductService productService;
	
	//Boolean errors = false;
	
	
	// Exo 3 (utiliser que la method get - essayer)
	// MVC : Controller
	@GetMapping(path = "/products")
	public String afficherListeProduits(@ModelAttribute("products") ProductDto product, Model model) {
		List<Product> products = productService.getProductList();
		model.addAttribute("ProductList", products);
		// return la page html (La vue)
		return "ProductList";
	}

}
