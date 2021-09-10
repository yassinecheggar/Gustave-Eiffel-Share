package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.Produit;

public interface IProduit extends Remote {
	
	public Produit addProduit(Produit P)throws RemoteException;
	public Produit Update(Produit P)throws RemoteException;
	public Vector<Produit> getProduits()throws RemoteException;
	public Vector<Produit> getProduit(String desig)throws RemoteException;
	public Produit deleteProduit(Produit P)throws RemoteException;
	public Vector<Produit> ProduitDisonible()throws RemoteException;
	public Vector<Produit> ProduitIndisonible()throws RemoteException;
	
	

}
