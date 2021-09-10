package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Vector;

import com.upem.jdbc.Database;
import com.upem.models.ListeAttente;

public class IListeAttentImp extends UnicastRemoteObject implements IListeAttente{

	private Database db;
	protected IListeAttentImp(Database db) throws RemoteException {
		super();
		this.db=db;
	}

	private static final long serialVersionUID = 1L;

	
	public ListeAttente addtoListeAttente(ListeAttente L) throws RemoteException {
		if( db.Insert("listeattente", L.getId(),L.getIdUser(),L.getIdproduit(),L.getDate())>0)return L;
		return null;
	}

	
	public Vector<ListeAttente> geListeAttent() throws RemoteException {
		
		return mapping(db.select("listeattente"));
	}

	@Override
	public ListeAttente deletFromListe(ListeAttente L) throws RemoteException {
		if(db.Delete("listeattente", "id", L.getId())>0)return L;
		return null;
	}
	
	
	
	
	////////////////mapping//////////////////////////////////////////
	public Vector<ListeAttente>mapping(String data[][]){
		Vector<ListeAttente> attentes = new Vector<>();

		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				attentes.add(mapRow(data[i]));
			}
		}
		return attentes;
	}

	public ListeAttente mapRow(String row[]) {
		int yp=0 ,ya=0,yo=0 ;
		LocalDate d1 = null;
		
		try {
			yp =Integer.parseInt(row[0]);
			ya = Integer.parseInt(row[1]);
			yo =Integer.parseInt(row[2]);
			
			d1 =LocalDate.parse(row[3]);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ListeAttente(yp,ya ,yo,d1);
	}

}
