package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.Commentaire;
import com.upem.models.Emprunt;

public interface IComment extends Remote {

	public Commentaire addCommentaire(Commentaire E) throws RemoteException;
	public Vector<Commentaire> getCommentaires() throws RemoteException;
	public Commentaire supCommentaire(Commentaire E) throws RemoteException;
	public Commentaire updateCommentaire(Commentaire E) throws RemoteException;
	public Vector<Commentaire> getCommentaireUser(int user) throws RemoteException;
	public Vector<Commentaire> getCommentaireProduit(int prod) throws RemoteException;
	
}
