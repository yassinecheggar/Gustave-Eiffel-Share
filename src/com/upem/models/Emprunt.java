package com.upem.models;

import java.io.Serializable;
import java.time.LocalDate;

public class Emprunt implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2808825266489000896L;
	private int idEmprunt ;
	private int idProduit;
	private  LocalDate DateEmprunt;
	private  LocalDate DateRestitution;
	private  int User;
	
	
	public Emprunt() {
		// TODO Auto-generated constructor stub
	}

	public Emprunt(int idEmprunt, int idProduit, LocalDate dateEmprunt, LocalDate dateRestitution, int user) {
		super();
		this.idEmprunt = idEmprunt;
		this.idProduit = idProduit;
		DateEmprunt = dateEmprunt;
		DateRestitution = dateRestitution;
		User = user;
	}
	
	public Emprunt( int idProduit, LocalDate dateEmprunt, LocalDate dateRestitution, int user) {
		super();
		
		this.idProduit = idProduit;
		DateEmprunt = dateEmprunt;
		DateRestitution = dateRestitution;
		User = user;
	}


	public int getIdEmprunt() {
		return idEmprunt;
	}


	public void setIdEmprunt(int idEmprunt) {
		this.idEmprunt = idEmprunt;
	}


	public int getIdProduit() {
		return idProduit;
	}


	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}


	public LocalDate getDateEmprunt() {
		return DateEmprunt;
	}


	public void setDateEmprunt(LocalDate dateEmprunt) {
		DateEmprunt = dateEmprunt;
	}


	public LocalDate getDateRestitution() {
		return DateRestitution;
	}


	public void setDateRestitution(LocalDate dateRestitution) {
		DateRestitution = dateRestitution;
	}


	public int getUser() {
		return User;
	}


	public void setUser(int user) {
		User = user;
	}
	
	
	
	
}
