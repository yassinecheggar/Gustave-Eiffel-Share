package com.upem.models;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class Produit  implements Serializable{

	private static final long serialVersionUID = 995035251603076238L;
	private int id;
	private String desig;
	private String statut;
	private String	etat;
	private String commentaire;
	private String imagepath;
	private int categorie;
	private int idUser;
	
	public Produit() {
	
		
	}

	
	public int getIdUser() {
		return idUser;
	}


	public void setIdUser(int idUser) {
		this.idUser = idUser;
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

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getImagepath() {
		return imagepath;
	}

	public void setImagepath(String imagepath) {
		this.imagepath = imagepath;
	}



	

	public int getCategorie() {
		return categorie;
	}

	public void setCategorie(int categorie) {
		this.categorie = categorie;
	}

	
	public Produit(int id, String desig, String statut, String etat, String commentaire, String imagepath,
			int categorie, int idUser) {
		super();
		this.id = id;
		this.desig = desig;
		this.statut = statut;
		this.etat = etat;
		this.commentaire = commentaire;
		this.imagepath = imagepath;
		this.categorie = categorie;
		this.idUser = idUser;
	}


	@Override
	public String toString() {
		return "Produit [id=" + id + ", desig=" + desig + ", statut=" + statut + ", etat=" + etat + ", commentaire="
				+ commentaire + ", imagepath=" + imagepath + ", emprunter=" 
				+"]";
	}

	

	
	
}
