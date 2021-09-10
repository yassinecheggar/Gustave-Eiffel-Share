package com.upem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upem.action.CategorieAction;

/**
 * Servlet implementation class CategorieController
 */
@WebServlet({"/CategorieController","/Categorie/*"})
public class CategorieController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CategorieAction action;
   
   
public void init() throws ServletException {
	action = new CategorieAction();
	super.init();
}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";
		
		if (uri.endsWith("/AddC")) {
			view = action.addC(request);
			System.out.println("lola");
			request.getRequestDispatcher(view).forward(request, response);	
		}
		
		if (uri.endsWith("/Add")) {

			view = action.add(request);
			if(view.equals("ok")) {
				response.sendRedirect("ListC");
			}	
		}
		
		if (uri.endsWith("/ListC")) {

			view = action.ListeC(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/EditC")) {
			action.ListeC(request);
			view="/views/EditeListeCategorie.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		
		if (uri.endsWith("/Edite")) {

			view = action.Catmodifier(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}
		
		if (uri.endsWith("/update")) {

			view = action.update(request);

			response.sendRedirect("ListC");	
		}
		
		if (uri.endsWith("/deleteC")) {

			view = action.ListeC(request);
			request.getRequestDispatcher("/views/deleteCategorie.jsp").forward(request, response);	
		}

		if (uri.endsWith("/delete")) {

			view = action.delete(request);
			response.sendRedirect("deleteC");
		}
		
		
	}

	
}
