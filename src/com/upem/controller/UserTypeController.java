package com.upem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upem.action.UserTypeAction;


@WebServlet({"/UserTypeController","/UserT/*"})
public class UserTypeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserTypeAction action;

	@Override
	public void init() throws ServletException {
		action = new UserTypeAction();
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";

		if (uri.endsWith("/AddU")) {
			view = action.addP(request);
			System.out.println("lola");
			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/Add")) {

			view = action.add(request);
			if(view.equals("ok")) {
				response.sendRedirect("ListT");
			}	
		}

		if (uri.endsWith("/ListT")) {

			view = action.ListeT(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/EditT")) {

			view = action.ListeModifT(request);
			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/Edite")) {

			view = action.Typemodifier(request);

			request.getRequestDispatcher(view).forward(request, response);	
		}

		if (uri.endsWith("/update")) {

			view = action.update(request);

			response.sendRedirect("ListT");	
		}


		if (uri.endsWith("/deleteT")) {

			view = action.ListeModifT(request);
			request.getRequestDispatcher("/views/deleteUserT.jsp").forward(request, response);	
		}

		if (uri.endsWith("/delete")) {

			view = action.delete(request);
			response.sendRedirect("ListT");
		}



	}




}
