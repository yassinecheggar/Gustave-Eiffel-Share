package com.upem.action;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.upem.dao.IUserType;
import com.upem.dao.Icategorie;
import com.upem.models.Categorie;
import com.upem.models.User;
import com.upem.models.UserType;

public class CategorieAction {

	private Icategorie stub;

	public CategorieAction() {
		try {
			stub=	(Icategorie)Naming.lookup("rmi://localhost:1099/categorie");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}


	public String addC(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );

		return "/views/AddCategorie.jsp";
	}


	public String add(HttpServletRequest request) throws RemoteException {

		Categorie ty = new  Categorie();
		ty.setDesig(request.getParameter("type"));

		Categorie x = stub.addCategorie(ty);
		//stub.addUser(a);

		return "ok";
	}


	public String ListeC(HttpServletRequest request) throws RemoteException {

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		Vector<Categorie> vc = stub.categories();
		request.setAttribute("type", vc);

		return "/views/ListeCategorie.jsp";
	}


	public String Catmodifier(HttpServletRequest request) throws RemoteException {

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		System.out.println();
		Vector<Categorie> vc = stub.categories();
		
		for (Categorie userType : vc) {
			int a = Integer.parseInt( request.getParameter("ed"));
			if(userType.getId()== a) {

				request.setAttribute("ut", userType);
			}
		}

		return "/views/EditeCategorie.jsp";
	}
	
	public String update(HttpServletRequest request) throws RemoteException {
		int i=0;
		
		
		Categorie u = new Categorie();
		u.setDesig(request.getParameter("type"));
		u.setId(Integer.parseInt(request.getParameter("id")));
		
		stub.EditCategorie(u);
		
		return "ok";
	}
	
	public String delete(HttpServletRequest request) throws RemoteException {
		int i=0;
		
		
		Categorie u = new Categorie();
		u.setDesig(request.getParameter("type"));
		u.setId(Integer.parseInt(request.getParameter("ed")));
		
		stub.deleteCategorie(u);
		
		return "ok";
	}








}
