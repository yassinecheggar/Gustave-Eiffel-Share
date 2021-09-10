package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.ListeAttente;

public interface IListeAttente extends Remote{

	public ListeAttente addtoListeAttente(ListeAttente L)throws RemoteException;
	public Vector<ListeAttente> geListeAttent()throws RemoteException;
	public ListeAttente deletFromListe(ListeAttente L)throws RemoteException;
	
}
