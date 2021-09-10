package com.upem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upem.action.EmpruntAction;


@WebServlet({"/EmpruntContoller" , "/Emprunt/*"})
public class EmpruntContoller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private EmpruntAction action; 

	@Override
	public void init() throws ServletException {
		action= new EmpruntAction();
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";

		if (uri.endsWith("/AddE")) {
			view = action.Ajouteur(request);
			System.out.println("lola");
			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/Add")) {

			view = action.add(request);
			if(view.equals("ok")) {
				//response.sendRedirect("ListT");
			}	
		}

		if (uri.endsWith("/EditE")) {
			action.ListeE(request);
			view ="/views/EditeEmprunt.jsp";
			request.getRequestDispatcher(view).forward(request, response);	
		}
		if (uri.endsWith("/ListeE")) {

			view = action.ListeE(request);
			request.getRequestDispatcher(view).forward(request, response);	

		}

		if (uri.endsWith("/ListeH")) {

			view = action.ListeH(request);
			request.getRequestDispatcher(view).forward(request, response);	

		}



	}

}
