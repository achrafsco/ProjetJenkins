package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Animal;
import com.animoz.service.RechercheAnimalService;

@Repository
public class RechercheAnimalRepository {

		@Autowired
		private EntityManager entityManager;
		
		@Autowired
		private RechercheAnimalService rechercheAnimalService;
		
		private String nom;
		
		private Animal animal;
		
		public Animal getAnimalRecherche(){
		
		try {
				
			animal = entityManager.createQuery("select a from Animal a where a.nom = :nom", Animal.class).setParameter("nom", this.nom).getSingleResult();
			
		} catch(NoResultException e){
			//model.addAttribute("NomAnimal", null);
			NotFound();
			System.out.println("Cet animal n'existe pas !");
		}
			
			return animal;
					
		}

		public void NotFound() {
			
			rechercheAnimalService.NotFound(true);
		}
		
		public void setNomAnimalRecherche(String nom) {
			this.nom = nom;
		}
		
}
