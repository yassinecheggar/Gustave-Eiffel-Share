package com.upem.action;

import java.rmi.RemoteException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.rpc.ServiceException;

import com.service.dao.Achat;
import com.service.dao.AchatServiceLocator;
import com.upem.models.CompteUtilisateur;
import com.upem.models.Pannier;
import com.upem.models.Produit;
import com.upem.models.User;

public class EProduitAction {

	private Achat stub;


	public EProduitAction() {
		try {
			stub =  new AchatServiceLocator().getAchat();

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String listP(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("session");
		request.setAttribute("user", u);
		System.out.println(u.getIdUser());
		Pannier[] p = stub.panniersWithiDuser(u.getIdUser());

		request.setAttribute("pannier", p);
		request.setAttribute("Pro", stub.getdata()); 

		return "/MyViews/home.jsp";
	}
	
	
	public String pannier(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("session");
		request.setAttribute("user", u);
		
		Pannier[] p = stub.panniersWithiDuser(u.getIdUser());
		request.setAttribute("produit", stub.produits());
		request.setAttribute("pannier", p);
		request.setAttribute("Pro", stub.getdata()); 

		return "/MyViews/Pannier.jsp";
	}

	public String produitinfo(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("session");
		request.setAttribute("user", u);
		Pannier[] p = stub.panniersWithiDuser(u.getIdUser());

		request.setAttribute("pannier", p);
		
		
		int a = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("comment", stub.commentaires(a));
		for (Produit P : stub.getdata()) {
			if(P.getId() == a) {
				request.setAttribute("Pro", P);
				return "/MyViews/Produit.jsp";
			}
		}

		return "/MyViews/Err.jsp";


	}


	public String adduser(HttpServletRequest request) throws RemoteException {

		User a = new User();

		a.setNom(request.getParameter("LastName"));
		a.setPrenom(request.getParameter("FirstName"));
		a.setLogin(request.getParameter("Email"));
		a.setPasseword(request.getParameter("Password"));
		a.setUserType(9);
		a.setIdUser(0);
		stub.adduser(a);
		CompteUtilisateur C = new CompteUtilisateur();
		C.setCurrency(request.getParameter("select"));
		C.setIduser(stub.finduserWithlogin(request.getParameter("Email")).getIdUser());
		C.setSold(3000);
		stub.ajouterCompte(C);

		return "/MyViews/Produit.jsp";
	}

	public String loginC(HttpServletRequest request) throws RemoteException {

		String s= request.getParameter("Email");
		String s2= request.getParameter("Password");
		System.out.println(s);
		System.out.println(s2);
		User u = stub.finduserWithlogin(s);

		if(u!=null) {
			if(u.getPasseword().equals(s2)) {
				HttpSession session = request.getSession();
				session.setAttribute("session", u);
				System.out.println("true");
				return "ok";
			}
		}



		return "no";
	}





	public String Addp(HttpServletRequest request) throws RemoteException {

		int a = Integer.parseInt(request.getParameter("id"));
		Pannier p = new  Pannier();
		p.setIdProduit(a);
		p.setStatus("incomplet");
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("session");
		p.setIdUser(u.getIdUser());
		stub.ajouteurAuPannier(p);

		return "/MyViews/home.jsp";
	}


}
