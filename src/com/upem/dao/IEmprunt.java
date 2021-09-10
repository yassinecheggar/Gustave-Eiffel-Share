package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.Emprunt;
import com.upem.models.Produit;

public interface IEmprunt extends Remote {
	
	public Emprunt addEmprunt(Emprunt E) throws RemoteException;
	public Vector<Emprunt>allEmprunt()throws RemoteException;;
	public Vector<Emprunt>getEmpruntWithUserId(int UserId)throws RemoteException;;
	public Vector<Emprunt>getEmpruntWithProduit(Produit p)throws RemoteException;;
	public Emprunt Restituer(Emprunt em )throws RemoteException;;
	public Emprunt Delete(Emprunt em)throws RemoteException;
	
	

}
