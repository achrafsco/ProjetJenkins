package com.atelier_jenkins.repository;

import com.atelier_jenkins.modele.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Product> getProductList(){
		
		return entityManager.createQuery("select p from Product p", Product.class)
				.getResultList();
	}
	
}
