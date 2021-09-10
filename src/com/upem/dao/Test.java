package com.upem.dao;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.time.LocalDate;
import java.util.Vector;

import com.upem.jdbc.DataSource;
import com.upem.jdbc.Database;
import com.upem.jdbc.MySQLDataSource;
import com.upem.models.Categorie;
import com.upem.models.Emprunt;
import com.upem.models.Produit;
import com.upem.models.User;
import com.upem.models.UserType;

public class Test {

	public static void main(String[] args) {

		DataSource ds =  new MySQLDataSource("rest");
		Database db = new Database(ds);
		
		
		try {
			LocateRegistry.createRegistry(1099);
			IEmprunt em = new IEmpruntImp(db);
			IUser ie = new IUserImp(db);
			IUserType it = new IUserTypeImp(db);
			IProduit p = new IProduitImp(db);
			Icategorie cat = new IcategorieImp(db);
			User a = new User(1, "cheggar13@gmail.com", "123", 1, "yassine", "cheggar");
			ie.Update(a);
			
			Naming.rebind("rmi://localhost:1099/Produit", p);
			Naming.rebind("rmi://localhost:1099/Emprunt", em);
			Naming.rebind("rmi://localhost:1099/User", ie);
			Naming.rebind("rmi://localhost:1099/UserType", it);
			Naming.rebind("rmi://localhost:1099/categorie",cat);
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		/*
		Vector<Emprunt>emprunts= em.getEmpruntWithProduit(emp.get(3));
		Emprunt po = emprunts.get(0);
		po.setDateRestitution(LocalDate.parse("2017-05-05"));
		em.Restituer(po);
		Vector<Emprunt>emprun= em.allEmprunt();
		for (Emprunt P : emprun) {
		
			
			System.out.println(P.getUser() +" "+ P.getDateEmprunt() +" " + P.getDateRestitution()+ " "+P.getIdProduit() );
		}
		
		Vector<Emprunt>emp= em.allEmprunt();
		em.Delete(emp.get(emp.size()-2));
		*/
		
		//LocalDate localDate = LocalDate.parse("2019-02-02");
		//Emprunt Em = new Emprunt(1,localDate,localDate,1);
		//em.addEmprunt(Em);
		//User a = new User(5, "yassinen", "02", 2);
		//System.out.println(ie.findUserWithLogin("yassinen").getIdUser()); 
		//UserType z = new UserType(4, "admo");
		//it.deleteUser(z);
		
		
		
	}

}
