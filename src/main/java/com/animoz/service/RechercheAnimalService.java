package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Animal;
import com.animoz.modele.Soigneur;
import com.animoz.repository.RechercheAnimalRepository;

@Service
public class RechercheAnimalService {

		private Boolean notFound = false;

		@Autowired
		private RechercheAnimalRepository rechercheAnimalRepository;
		
		public Animal getAnimalRecherche(){
			
			return rechercheAnimalRepository.getAnimalRecherche();
			
		}
		
		public void setNomAnimalRecherche(String nom) {
			
			this.notFound = false;
			rechercheAnimalRepository.setNomAnimalRecherche(nom);
			
		}
		
		public void NotFound(Boolean notFound) {
			System.out.println("############ Verif boolean ########### ->" + notFound);
			this.notFound = notFound;
		}
		
		public Boolean AppelNotFound() {
			return notFound;
		}

	
}
