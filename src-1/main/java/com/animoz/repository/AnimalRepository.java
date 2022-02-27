package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;

@Repository
public class AnimalRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Animal> getListAnimaux(){
		
		return entityManager.createQuery("select a from Animal a", Animal.class)
				.getResultList();
	}
	
}
