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
	
	
	
	public ListeAttente() {
		// TODO Auto-generated constructor stub
	}

	
	public ListeAttente(int id, int idUser, int idproduit) {
		super();
		this.id = id;
		this.idUser = idUser;
		this.idproduit = idproduit;
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
	
	
}
