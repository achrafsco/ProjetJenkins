package com.animoz.controller;

import javax.validation.constraints.NotBlank;

import com.animoz.modele.Espece;
import com.animoz.modele.Regime;

public class AnimalDto {

	@NotBlank(message="le nom ne peut pas être vide")
	private String nom;
	
	private String description;
	
	private Regime regime;
	
	private Long espece;
	
	private String especeNom;
	
	private String especeID;
	
	private String nomSoigneur;
	
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
	
	public void setRegime(Regime regime) {
		this.regime = regime;
	}
	
	public Long getEspece() {
		return espece;
	}
	
	public void setEspece(int espece) {
		Long E = Long.valueOf(espece);
		this.espece = E;
	}
	
	public String getEspeceNom() {
		return especeNom;
	}
	
	public void setEspeceNom(String especeNom) {
		this.especeNom = especeNom;
	}
	
	public void setEspeceID(String especeID) {
		this.especeID = especeID;
	}
	
	public String getEspeceID() {
		return especeID;
	}
	
	public void setnomSoigneur(String nomSoigneur) {
		this.nomSoigneur = nomSoigneur;
	}
	
	public String getnomSoigneur() {
		return nomSoigneur;
	}
}
