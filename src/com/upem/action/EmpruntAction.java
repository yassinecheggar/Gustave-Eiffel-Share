package com.upem.action;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import com.upem.dao.IEmprunt;
import com.upem.dao.IProduit;
import com.upem.dao.IUser;
import com.upem.dao.IUserType;
import com.upem.models.Categorie;
import com.upem.models.Emprunt;
import com.upem.models.Produit;
import com.upem.models.User;
import com.upem.models.UserType;

public class EmpruntAction {

	
	private IEmprunt stub;
	private IProduit stubProduit;
	private IUser stubUser;
	
	public EmpruntAction() {
		try {
			stub=	(IEmprunt)Naming.lookup("rmi://localhost:1099/Emprunt");
			stubProduit=(IProduit)Naming.lookup("rmi://localhost:1099/Produit");
			stubUser=	(IUser)Naming.lookup("rmi://localhost:1099/User");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	
	public String Ajouteur(HttpServletRequest request) throws RemoteException {
		System.out.println("im here");
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
	
		Vector<User> users= stubUser.Users();
		Vector<Produit> produits=stubProduit.getProduits();
		System.out.println("im here");
		request.setAttribute("us",users );
		request.setAttribute("Prod",produits );

		return "/views/AddEmpruntAdmin.jsp";
	}
	
	public String add(HttpServletRequest request) throws RemoteException {
		Emprunt e= new Emprunt();
		e.setIdProduit(Integer.parseInt(request.getParameter("idproduit")));
		e.setUser(Integer.parseInt(request.getParameter("idUser")));
		String date = request.getParameter("bday");
		//convert String to LocalDate
		LocalDate localDate = LocalDate.parse(date);
		e.setDateEmprunt(localDate);
		stub.addEmprunt(e);

		return "ok";
	}
	
	
	public String ListeE(HttpServletRequest request) throws RemoteException {

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		Vector<User> users= stubUser.Users();
		Vector<Produit> produits=stubProduit.getProduits();
		Vector<Emprunt> vc = stub.allEmprunt();
		
		request.setAttribute("Emp", vc);
		request.setAttribute("prod", produits);
		request.setAttribute("us", users);
		for (Emprunt emprunt : vc) {
			System.out.println(emprunt.getUser());
		}

		return "/views/ListeEmprunt.jsp";
	}
	
	public String ListeH(HttpServletRequest request) throws RemoteException {

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		Vector<User> users= stubUser.Users();
		Vector<Produit> produits=stubProduit.getProduits();
		Vector<Emprunt> vc = stub.getEmpruntWithUserId(U.getIdUser());
		
		request.setAttribute("Emp", vc);
		request.setAttribute("prod", produits);
		request.setAttribute("us", users);
		for (Emprunt emprunt : vc) {
			System.out.println(emprunt.getUser());
		}

		return "/views/History.jsp";
	}
}
