package com.animoz.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Animal {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nom;
	private String description;
	
	@ManyToOne
	@JoinColumn(name = "espece_id")
	private Espece espece;
	
	 @Enumerated(EnumType.STRING)
	private Regime regime;
	
	 public Espece getEspece() {
		 
		 return espece;
	 }
	 
	 public void setEspece(Espece espece) {
		 
		this.espece = espece;
		 
	 }
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		
		this.description = description;
		
	}
	
	public Regime getRegime() {
		
		return regime;
		
	}
	
	public void setRegime(Regime leRegime) {
		
		this.regime = leRegime;
		
	}
	
}
