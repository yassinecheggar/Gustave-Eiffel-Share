package com.upem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upem.action.UserAction;
import com.upem.models.User;


@WebServlet({"/UserAction","/User/*"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserAction action;
	@Override
	public void init() throws ServletException {
		action = new UserAction();
		super.init();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";
		
		if (uri.endsWith("/add")) {
			view = action.add(request);
			response.sendRedirect("../loginP");
		}
		if (uri.endsWith("/Addpage")) {
			view = action.Addpage(request);
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/loginP")) {
			view="/views/login.jsp";
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/login")) {
			view = action.login(request);
			if(view.equals("ok")) {
				response.sendRedirect("../../Produit/home");
			}else {
				response.sendRedirect("../loginP");
			}
			
			
		}
		
		if (uri.endsWith("/ListeU")) {
			view = action.ListeU(request);
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/deleteU")) {
			view = action.deleteU(request);
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/delete")) {
			view = action.delete(request);
			
			response.sendRedirect("../deleteU");
		}
		
		if (uri.endsWith("/EditeU")) {
			view = action.EditeU(request);
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/Edite")) {
			view = action.Edite(request);
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/update")) {
			view = action.update(request);
			if(view.equals("ok")) {
				response.sendRedirect("../EditeU");
			}
			
		}
		
		

		
		
		
	}



}
