package com.upem.models;

import java.io.Serializable;

public class User implements Serializable {
	
	private static final long serialVersionUID = 6165588694108622842L;
	private int idUser;
	private String login;
	private String Passeword;
	private int UserType;
	private String nom;
	private String prenom;
	
	
public User() {
	
}
	
	
	public User(int idUser, String login, String passeword, int userType, String nom, String prenom) {
	super();
	this.idUser = idUser;
	this.login = login;
	Passeword = passeword;
	UserType = userType;
	this.nom = nom;
	this.prenom = prenom;
	
}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPasseword() {
		return Passeword;
	}
	public void setPasseword(String passeword) {
		Passeword = passeword;
	}
	public int getUserType() {
		return UserType;
	}
	public void setUserType(int userType) {
		UserType = userType;
	}
	
	

}
