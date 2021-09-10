package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.Vector;

import com.upem.jdbc.Database;
import com.upem.models.Emprunt;
import com.upem.models.Produit;

public class IEmpruntImp extends UnicastRemoteObject implements IEmprunt{

	



	private static final long serialVersionUID = 1L;
	private Database db;

	protected IEmpruntImp( Database db) throws RemoteException {
		super();
		 this.db = db;
	}

	public Emprunt addEmprunt(Emprunt E) {
		
		
		db.Insert("emprunt", E.getIdEmprunt(),E.getIdProduit(),E.getDateEmprunt(),"0000-00-00",E.getUser());
		return E;
	}

	public Vector<Emprunt> allEmprunt() {

		return mapping(db.select("emprunt"));
	}

	public Vector<Emprunt> getEmpruntWithUserId(int UserId) {

		return mapping(db.select("emprunt", "user", UserId));
	}

	public Vector<Emprunt> getEmpruntWithProduit(Produit p) {

		return mapping(db.select("emprunt", "produit", p.getId()));
	}

	

	public Emprunt Restituer(Emprunt em) {
		
		db.Update("emprunt",em.getIdEmprunt(),em.getIdProduit(),em.getDateEmprunt(),em.getDateRestitution(),em.getUser());
		return null;
	}
///////mapping///////////////////////////////////////////////////////////////////////
	public Vector<Emprunt>mapping(String data[][]){
		Vector<Emprunt> emprunt = new Vector<>();

		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				emprunt.add(mapRow(data[i]));
			}
		}
		return emprunt;
	}

	public Emprunt mapRow(String row[]) {
		int yp=0 ,ya=0,yo=0 ;
		LocalDate d1 = null;
		LocalDate d2= null;
		try {
			yp =Integer.parseInt(row[0]);
			ya = Integer.parseInt(row[1]);
			d1 = LocalDate.parse(row[2]);
			d2 =LocalDate.parse(row[3]);
			yo =Integer.parseInt(row[4]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Emprunt(yp,ya, d1, d2, yo);
	}

	@Override
	public Emprunt Delete(Emprunt em) {
		db.Delete("emprunt", "idemprunt", em.getIdEmprunt());
		return em;
	}

}
