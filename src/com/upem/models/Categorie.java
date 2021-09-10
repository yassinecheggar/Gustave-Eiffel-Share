package com.upem.models;

import java.io.Serializable;

public class Categorie implements Serializable {

	private static final long serialVersionUID = -9162875627685640283L;
	private int Id ; 
	private String desig;
	
	
	public Categorie(int id, String desig) {
		super();
		Id = id;
		this.desig = desig;
	}
	
	public Categorie() {
		// TODO Auto-generated constructor stub
	}
	
	
	public int getId() {
		return Id;
	}
	public void setId(int id) {
		Id = id;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	
	
	
	
	
}
