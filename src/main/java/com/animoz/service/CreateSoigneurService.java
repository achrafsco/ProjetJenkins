package com.animoz.service;

//import java.sql.Date;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Animal;
import com.animoz.repository.CreateSoigneurRepository;
import com.animoz.repository.RechercheAnimalRepository;

@Service
public class CreateSoigneurService {

	@Autowired
	private CreateSoigneurRepository createSoigneurRepository;
	
	private boolean vCreateSoigneur;
	
	public void setSoigneurCreate(String nom, String numero, Date dateDeRecrutement) {

		this.vCreateSoigneur = false;
		createSoigneurRepository.CreateSoigneur(nom, numero, dateDeRecrutement);
		
	}

	public void getValidCreateSoigneur(boolean vCreateSoigneur) {
		this.vCreateSoigneur = vCreateSoigneur;
	}
	
	public boolean getValidCreate() {
		return this.vCreateSoigneur;
	}
	
	public void InitValidCreate() {
		this.vCreateSoigneur = false;
	}
}
