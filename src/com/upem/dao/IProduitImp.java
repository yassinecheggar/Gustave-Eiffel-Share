package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.upem.jdbc.Database;
import com.upem.models.Produit;

public class IProduitImp  extends UnicastRemoteObject implements IProduit{


	protected IProduitImp(Database db) throws RemoteException {
		super();
		 this.db = db;
		
	}

	private static final long serialVersionUID = 1L;
	private Database db;
	
	
	


	public Produit addProduit(Produit P) {
		if(db.Insert("produit",P.getId(), P.getDesig(),P.getStatut(),P.getEtat(),P.getCommentaire(),P.getImagepath(),P.getCategorie(),P.getIdUser()) >1) {
			return P;
		}
		
		return null;
	}

	
	public Vector<Produit> getProduits() {
		
		
		return mapping(db.select("produit"));
	}
	
	
	public Vector<Produit> ProduitDisonible() {
		
		return mapping(db.select("produit", "statut", "Disponible"));
	}
	
	@Override
	public Vector<Produit> ProduitIndisonible() {
		// TODO Auto-generated method stub
		return mapping(db.select("produit", "statut", "Indisponible"));
	}
	
	// ///////////////////////mapping////////////////////////////////////
	public Vector<Produit>mapping(String data[][]){
		Vector<Produit> produits = new Vector<>();
		
		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				produits.add(mapRow(data[i]));
			}
		}
		return produits;
	}
	
	public Produit mapRow(String row[]) {
		int yp=0 ,ya=0 , yb=0;
		//LocalDate d1 = null;
		//LocalDate d2= null;
		try {
			yp =Integer.parseInt(row[0]);
			ya=Integer.parseInt(row[6]);
			yb=Integer.parseInt(row[7]);
			//d1 = LocalDate.parse(row[6]);
			//d2 =LocalDate.parse(row[7]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new Produit(yp, row[1], row[2], row[3], row[4], row[5],ya,yb);
	}

	public Vector<Produit> getProduit(String desig) {
		
		return mapping(db.select("produit", "designation", desig)); 
	}

	public Produit deleteProduit(Produit P) {
		db.Delete("produit", "idproduit", P.getId());
		return P;
	}


	@Override
	public Produit Update(Produit P) throws RemoteException {
		db.Update("produit", P.getId(),P.getDesig(),P.getStatut(),P.getEtat(),P.getCommentaire(),P.getImagepath(),P.getCategorie(),P.getIdUser());
		return P;
	}

}
