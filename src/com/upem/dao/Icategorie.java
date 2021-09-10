package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.Categorie;

public interface Icategorie extends Remote {

	
	public Categorie addCategorie (Categorie u) throws RemoteException;
	public Vector <Categorie> categories() throws RemoteException;
	public Categorie deleteCategorie(Categorie u) throws RemoteException;
	public Categorie EditCategorie(Categorie u) throws RemoteException;
	
	}
