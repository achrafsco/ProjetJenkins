package com.animoz.repository;

//import java.sql.Date;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;
import com.animoz.modele.Soigneur;
import com.animoz.service.CreateAnimauxService;
import com.animoz.service.CreateSoigneurService;

@Repository
public class CreateAnimauxRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CreateAnimauxService createAnimauxService;
	
	private List<Animal> animalNom;
	
	private boolean ValidName = true;

	@Transactional
	public void CreateAnimaux(String nom, String description, Regime regime, Espece espece){

		this.ValidName = true;
		
		animalNom = entityManager.createQuery("select a from Animal a", Animal.class).getResultList();


		for(Animal NameAnimal : animalNom) {
			System.out.println(NameAnimal.getNom() + "//" + nom);
			
			String ListNom = NameAnimal.getNom();
			if(NameAnimal.getNom().equals(nom)) {
				System.out.println(" !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!! ");
				NameFound();
				this.ValidName = false;
				break;
			}
			
		}
		
		if (this.ValidName == true) {
			
			Animal animal = new Animal();
			
				animal.setNom(nom);
				animal.setDescription(description);
				animal.setRegime(regime);
				animal.setEspece(espece);
			
			entityManager.persist(animal);	
			
			System.out.println("YEEEEEEEEEEESSSS" + nom);	
			
		}
		
		NameFound();
		
	}

	public void NameFound(){
		createAnimauxService.NameFound(this.ValidName);
		System.out.println("Le nom est deja existant ! ");
	}

	
}
