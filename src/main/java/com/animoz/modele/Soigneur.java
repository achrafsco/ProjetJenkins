package com.animoz.modele;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Soigneur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String numero;
	private String nom;
	
	@Temporal(TemporalType.DATE)
	private Date dateRecrutement;
	
	public Long getId() {
		
		return id;
		
	}

	public void setId(Long id) {
		
		this.id = id;
		
	}
	
	public String getNumero() {
		
		return numero;
		
	}
	
	public void setNumero(String numero) {
		
		this.numero = numero;
		
	}

	public String getNom() {
		
		return nom;
		
	}

	public void setNom(String nom) {
		
		this.nom = nom;
		
	}
	
	public Date getDateRecrutement() {
		
		return dateRecrutement;
		
	}

	public void setDateRecrutement(Date dateRecrutement) {
		
		this.dateRecrutement = dateRecrutement;
		
	}
	
}
