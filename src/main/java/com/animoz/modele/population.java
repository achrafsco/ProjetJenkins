package com.animoz.modele;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class population {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int nombreIndividus;
	
	@ManyToOne
	@JoinColumn(name = "animal_id")
	private Animal animal;
	
	
	public Animal getAnimal() {
		return animal;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public int getNombreIndividus() {
		return nombreIndividus;
	}

	public void setNombreIndividus(int id) {
		this.nombreIndividus = id;
	}
}
