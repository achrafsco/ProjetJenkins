package com.atelier_jenkins.controller;

import javax.validation.constraints.NotBlank;

public class ProductDto {

	@NotBlank(message="le nom ne peut pas être vide")
	private int nom;

	private String name;

	private int price;

	public int getNom() {
		return nom;
	}

	public void setNom(int nom) {
		this.nom = nom;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

}
