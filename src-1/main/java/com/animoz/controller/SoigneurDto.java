package com.animoz.controller;

//import java.util.Date;

import java.sql.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;

public class SoigneurDto {

	@NotBlank(message="le nom ne peut pas être vide")
	private String nom;
	
	@NotBlank(message="le nom ne peut pas être vide")
	private String numero;
	
	private Date date;
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
}
