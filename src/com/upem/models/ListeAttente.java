package com.upem.models;

import java.io.Serializable;
import java.time.LocalDate;

public class ListeAttente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2614990984268392944L;
	private int id;
	private int idUser;
	private int idproduit;
	private LocalDate date;
	
	
	public ListeAttente() {
		// TODO Auto-generated constructor stub
	}
	public ListeAttente(int id, int idUser, int idproduit, LocalDate date) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idproduit = idproduit;
		this.date = date;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public int getIdproduit() {
		return idproduit;
	}
	public void setIdproduit(int idproduit) {
		this.idproduit = idproduit;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
}
