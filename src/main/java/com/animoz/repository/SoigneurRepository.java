package com.animoz.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.animoz.modele.Soigneur;

@Repository
public class SoigneurRepository {

	@Autowired
	private EntityManager entityManager;
	
	public List<Soigneur> getListSoigneur(){
		
		return entityManager.createQuery("select s from soigneur s ORDER BY s.nom ASC", Soigneur.class)
				.getResultList();
	}
	
	@Transactional
	public void SupprSoigneur(String soigneur) {
		
		entityManager.createNativeQuery("DELETE FROM soigneur WHERE nom = (nom) VALUES (?)")
	      .setParameter(1, soigneur)
	      .executeUpdate();
	}
}
