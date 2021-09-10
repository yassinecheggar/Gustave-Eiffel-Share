package com.upem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upem.action.EProduitAction;


@WebServlet({"/EProduitController","/EProduit/*"})
public class EProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EProduitAction action;

	public EProduitController() {
		action = new EProduitAction();


	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";


		if (uri.endsWith("/list")) {
			view = action.listP(request);
			System.out.println("lola");
			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/Produit")) {
			view = action.produitinfo(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}
		
		if (uri.endsWith("/Pannier")) {
			view = action.pannier(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/addPanier")) {
			view = action.Addp(request);

			response.sendRedirect("../EProduit/list");	
		}
		
		if (uri.endsWith("/loginC")) {
			view = action.loginC(request);
			if(view.equals("ok")==false) {
				response.sendRedirect("../Login");
			}
			response.sendRedirect("../list");
		}

		if (uri.endsWith("/add")) {

			view = action.adduser(request);
			response.sendRedirect("../Login");	
		}

		if (uri.endsWith("/Login")) {
			view ="/MyViews/login.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}

		if (uri.endsWith("/Register")) {
			view = "/MyViews/AddUser.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}


		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
