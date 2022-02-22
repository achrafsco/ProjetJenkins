package com.atelier_jenkins.service;

import com.atelier_jenkins.modele.Product;
import com.atelier_jenkins.repository.ProductRepository;
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
