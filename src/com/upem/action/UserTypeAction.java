package com.upem.action;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.upem.dao.IUser;
import com.upem.dao.IUserType;
import com.upem.models.User;
import com.upem.models.UserType;

public class UserTypeAction {
	
	private IUserType stub;
	
	
	public UserTypeAction() {
		try {
			stub=	(IUserType)Naming.lookup("rmi://localhost:1099/UserType");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	public String add(HttpServletRequest request) throws RemoteException {

		UserType ty =new UserType();
		ty.setType(request.getParameter("type"));
		
		UserType x = stub.addUser(ty);
		//stub.addUser(a);

		return "ok";
	}
	public String addP(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		

		return "/views/AddUserType.jsp";
	}
	
	public String ListeT(HttpServletRequest request) throws RemoteException {
		
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		Vector<UserType> vc = stub.Users();
		request.setAttribute("type", vc);

		return "/views/ListeTypes.jsp";
	}
	
	public String ListeModifT(HttpServletRequest request) throws RemoteException {
		
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		Vector<UserType> vc = stub.Users();
		request.setAttribute("type", vc);

		return "/views/EditeTypeT.jsp";
	}
	
	public String Typemodifier(HttpServletRequest request) throws RemoteException {
	
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		System.out.println();
		Vector<UserType> vc = stub.Users();
		System.out.println(request.getParameter("ed")); 
		for (UserType userType : vc) {
			int a = Integer.parseInt( request.getParameter("ed"));
			if(userType.getUserTypeId()== a) {
				
				request.setAttribute("ut", userType);
			}
		}

		return "/views/EditeType.jsp";
	}
	
	
	
	
	public String update(HttpServletRequest request) throws RemoteException {
		int i=0;
		Vector<UserType>usertype = stub.Users();
		
		UserType u = new UserType();
		u.setType(request.getParameter("type"));
		u.setUserTypeId(Integer.parseInt(request.getParameter("id")));
		
		stub.Update(u);
		
		return "ok";
	}
	
	
	public String delete(HttpServletRequest request) throws RemoteException {
		int i=0;
		Vector<UserType>usertype = stub.Users();
		
		UserType u = new UserType();
		u.setType(request.getParameter("type"));
		u.setUserTypeId(Integer.parseInt(request.getParameter("ed")));
		
		stub.deleteUser(u);
		
		return "ok";
	}
	
	

}
