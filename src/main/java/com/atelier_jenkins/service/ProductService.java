package main.java.com.atelier_jenkins.service;

import main.java.com.atelier_jenkins.modele.Product;
import main.java.com.atelier_jenkins.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public List<Product> getProductList(){



		return productRepository.getProductList();
	}
	
}
