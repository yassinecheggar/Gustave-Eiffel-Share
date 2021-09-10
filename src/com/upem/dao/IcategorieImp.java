package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.upem.jdbc.Database;
import com.upem.models.Categorie;
import com.upem.models.UserType;

public class IcategorieImp extends UnicastRemoteObject implements Icategorie{


	private Database db;
	protected IcategorieImp(Database db) throws RemoteException {
		super();
		this.db=db;
	}

	@Override
	public Categorie addCategorie(Categorie u) throws RemoteException {
		if(db.Insert("categorie",0,u.getDesig())>0) return u;
		return null;
	}

	@Override
	public Vector<Categorie> categories() throws RemoteException {
		
		return  mapping(db.select("categorie"));
	}

	@Override
	public Categorie deleteCategorie(Categorie u) throws RemoteException {
		if(db.Delete("categorie", "idcategorie", u.getId())>0) {
			return u;
		}
		return null;
	}

	@Override
	public Categorie EditCategorie(Categorie u) throws RemoteException {
		if(db.Update("categorie", u.getId(),u.getDesig())>0) {
			return u;
		}
		return null;
	}

	//////////////////////////////////////mapping//////////////////////////

	public Vector<Categorie>mapping(String data[][]){
		Vector<Categorie> users = new Vector<>();

		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				users.add(mapRow(data[i]));
			}
		}
		return users;
	}

	public Categorie mapRow(String row[]) {
		int yp=0;
		try {
			yp =Integer.parseInt(row[0]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Categorie(yp, row[1]);
	}


}
