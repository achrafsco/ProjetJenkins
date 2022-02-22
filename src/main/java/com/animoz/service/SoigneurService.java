package com.animoz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.animoz.modele.Animal;
import com.animoz.modele.Soigneur;
import com.animoz.repository.AnimalRepository;
import com.animoz.repository.SoigneurRepository;

@Service
public class SoigneurService {

	@Autowired
	private SoigneurRepository soigneurRepository;
	
	public List<Soigneur> getListSoigneur(){
		return soigneurRepository.getListSoigneur();
	}
	
	public void SupprSoigneur(String soigneur) {
		soigneurRepository.SupprSoigneur(soigneur);
	}
}
