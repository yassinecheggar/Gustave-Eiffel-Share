package com.upem.action;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.sun.corba.se.impl.presentation.rmi.StubConnectImpl;
import com.upem.dao.IProduit;
import com.upem.dao.IUser;
import com.upem.dao.IUserType;
import com.upem.models.Categorie;
import com.upem.models.Produit;
import com.upem.models.User;
import com.upem.models.UserType;

public class UserAction {


	private IUser stub;
	private IUserType stubuserType;

	public UserAction() {

		try {
			stub=	(IUser)Naming.lookup("rmi://localhost:1099/User");
			stubuserType=(IUserType)Naming.lookup("rmi://localhost:1099/UserType");


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String add(HttpServletRequest request) throws RemoteException {

		User a = new User();
		a.setNom(request.getParameter("LastName"));
		a.setPrenom(request.getParameter("FirstName"));
		a.setLogin(request.getParameter("Email"));
		a.setPasseword(request.getParameter("Password"));
		a.setUserType(2);
		a.setIdUser(0);

		stub.addUser(a);

		return "/views/login.jsp";
	}


	public String login(HttpServletRequest request) throws RemoteException {
		String s= request.getParameter("Email");
		String s2= request.getParameter("Password");
		System.out.println(s);
		System.out.println(s2);
		
		User u = stub.findUserWithLogin(s);

		System.out.println(u);
		if(u!=null) {
			if(u.getPasseword().equals(s2)) {
				HttpSession session = request.getSession();
				session.setAttribute("session", u);
				System.out.println("true");
				return "ok";
			}
		}

		return "../views/login.jsp";
	}


	public String Addpage(HttpServletRequest request) throws RemoteException {
		return "/views/AddUser.jsp";
	}

	public String ListeU(HttpServletRequest request) throws RemoteException {

		Vector<User> vec = stub.Users();
		Vector<UserType> vec2 = stubuserType.Users();
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		request.setAttribute("Users", vec);
		request.setAttribute("type", vec2);
		return "/views/ListeUsers.jsp";
	}

	public String deleteU(HttpServletRequest request) throws RemoteException {

		Vector<User> vec = stub.Users();
		Vector<UserType> vec2 = stubuserType.Users();
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		request.setAttribute("Users", vec);
		request.setAttribute("type", vec2);
		return "/views/deleteUser.jsp";
	}
	
	
	public String delete(HttpServletRequest request) throws RemoteException {

		Vector<User> vec = stub.Users();
		int a= Integer.parseInt(request.getParameter("ed"));
		for (User u : vec) {
			if(u.getIdUser()==a) {
				stub.deleteUser(u);
				return "ok";			}
		}	
		return "notOk";

	}
	
	public String EditeU(HttpServletRequest request) throws RemoteException {

		Vector<User> vec = stub.Users();
		Vector<UserType> vec2 = stubuserType.Users();
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		request.setAttribute("Users", vec);
		request.setAttribute("type", vec2);
		return "/views/EditeU.jsp";
	}
	
	public String Edite(HttpServletRequest request) throws RemoteException {
		Vector<User> vec = stub.Users();
		Vector<UserType>categories = stubuserType.Users();
		request.setAttribute("categorie", categories);
		int a= Integer.parseInt(request.getParameter("ed"));
		System.out.println(a);
		for (User produit : vec) {
			if(produit.getIdUser()==a) {
				request.setAttribute("obj", produit);
				System.out.println("true");
				return "/views/EditeUser.jsp";			

			}
		}
		return "/views/EditeUser.jsp";

	}
	
	public String update(HttpServletRequest request) throws RemoteException {
		int i=0;
		Vector<UserType>usertype = stubuserType.Users();

		for (UserType cu : usertype) {

			if(cu.getType().equals(request.getParameter("cat"))) {
				i = cu.getUserTypeId();
			}
		}
		
		User u = new User();
		u.setIdUser(Integer.parseInt(request.getParameter("idP").toString()));
		u.setLogin(request.getParameter("log"));
		u.setNom(request.getParameter("nom"));
		u.setPrenom(request.getParameter("Pnom"));
		u.setPasseword(request.getParameter("Ps"));
		u.setUserType(i);
		stub.Update(u);

		return "ok";
	}


	



}
