package com.upem.models;

import java.io.Serializable;

public class Notification implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8224011624574526507L;
	
	private int id;
	private String desig;
	private int produit;
	private int user;
	
	public Notification() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesig() {
		return desig;
	}
	public void setDesig(String desig) {
		this.desig = desig;
	}
	public int getProduit() {
		return produit;
	}
	public void setProduit(int produit) {
		this.produit = produit;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	public Notification(int id, String desig, int produit, int user) {
		super();
		this.id = id;
		this.desig = desig;
		this.produit = produit;
		this.user = user;
	}
	
	
	
	
}
