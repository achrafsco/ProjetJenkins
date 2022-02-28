package main.java.com.atelier_jenkins.modele;

import javax.persistence.*;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private Float price;
	@Transient
	private Float updatedPrice;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Float getUpdatedPrice() {
		return updatedPrice;
	}

	public void setUpdatedPrice(Float updatedPrice) {
		this.updatedPrice = updatedPrice;
	}

}
