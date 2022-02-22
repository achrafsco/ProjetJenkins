package com.animoz.service;

//import java.sql.Date;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Animal;
import com.animoz.modele.Espece;
import com.animoz.modele.Regime;
import com.animoz.repository.CreateAnimauxRepository;
import com.animoz.repository.CreateSoigneurRepository;
import com.animoz.repository.RechercheAnimalRepository;

@Service
public class CreateAnimauxService {

	@Autowired
	private CreateAnimauxRepository createAnimauxRepository;
	
	private boolean ValidName = true;
	
	public void setAnimauxCreate(String nom, String description, Regime Regime, Espece espece) {

		createAnimauxRepository.CreateAnimaux(nom, description, Regime, espece);
		
	}
	
	public void NameFound(boolean ValidName) {
		this.ValidName = ValidName;
		getNameFound();
	}
	
	public boolean getNameFound() {
		return this.ValidName;
	}
	
}
