package com.animoz.repository;

//import java.sql.Date;

import java.util.Date;

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

import com.animoz.modele.Soigneur;
import com.animoz.service.CreateSoigneurService;

@Repository
public class CreateSoigneurRepository {

	@Autowired
	private EntityManager entityManager;
	
	@Autowired
	private CreateSoigneurService createSoigneurService;
	
	private boolean vCreateSoigneur = false;
	
	@Transactional
	public void CreateSoigneur(String nom, String numero, Date dateDeRecrutement){

		Soigneur soigneur = new Soigneur();
			
		soigneur.setNom(nom);
		soigneur.setNumero(numero);
		soigneur.setDateRecrutement(dateDeRecrutement);
		
		entityManager.persist(soigneur);
		
		
		System.out.println("YEEEEEEEEEEESSSS" + nom);
		
		ValidCreateSoigneur(vCreateSoigneur = true);
		
	}

	public void ValidCreateSoigneur(boolean vCreateSoigneur){
		createSoigneurService.getValidCreateSoigneur(vCreateSoigneur);
	}

	
}
