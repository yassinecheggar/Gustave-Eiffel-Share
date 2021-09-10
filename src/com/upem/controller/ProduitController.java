package com.upem.controller;



import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;

import com.upem.action.ProduitAction;
import com.upem.dao.IProduit;
import com.upem.models.Produit;
import com.upem.models.User;

@WebServlet( { "/ProduitController", "/Produit/*" })
public class ProduitController  extends HttpServlet{


	private static final long serialVersionUID = 1L;
	ProduitAction action ;

	public void init() throws ServletException {
		action = new ProduitAction();
		super.init();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		String view = "/views/Error.jsp";

		if (uri.endsWith("/allProduit")) {
			view = action.allProduit(request);
			System.out.println("Tru");
			request.getRequestDispatcher(view).forward(request, response);
		}
		if (uri.endsWith("/home")) {
			view = action.home(request);
			
			
			request.getRequestDispatcher(view).forward(request, response);

		}
		if (uri.endsWith("/AddP")) {
			view = action.addP(request);
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			request.getRequestDispatcher(view).forward(request, response);
		}

		if (uri.endsWith("/Add")) {
			view = action.add(request);
			if(view.equals("ok")) {
				response.sendRedirect("../AddP");
			}
		}

		if (uri.endsWith("/ListeP")) {
			view = action.ListeP(request);
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			request.getRequestDispatcher(view).forward(request, response);
		}

		if (uri.endsWith("/delete")) {
			view = action.delete(request);
			if(view.equals("ok")) {
				response.sendRedirect("../deleteP");
			}

		}

		if(uri.endsWith("/deleteP")) {
			view = action.deleteP(request);
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if(uri.endsWith("/deletePu")) {
			view = action.deletePu(request);
			
			request.getRequestDispatcher(view).forward(request, response);
		}

		if(uri.endsWith("/EditeP")) {
			view = action.EditeP(request);
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if(uri.endsWith("/EditePu")) {
			view = action.EditePu(request);
			
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
				response.sendRedirect("../EditeP");
			}

		}

		if (uri.endsWith("/Emprunter")) {
			view = action.emprunter(request);
			if(view.equals("ok")) {
				response.sendRedirect("home");
			}
		}
		
		
		if (uri.endsWith("/Dash")) {
			view = action.Dash(request);
			
			HttpSession session = request.getSession();
			User U = (User)session.getAttribute("session");
			request.setAttribute("user",U );
			
			request.getRequestDispatcher(view).forward(request, response);
		}
		
		if (uri.endsWith("/Restituer")) {
			view = action.restituer(request);
			request.getRequestDispatcher(view).forward(request, response);

		}
		
		if (uri.endsWith("/InfoProduit")) {
			view = action.infoP(request);
			request.getRequestDispatcher(view).forward(request, response);

		}
		

		if (uri.endsWith("/Restitu")) {
			view = action.restitu(request);
			response.sendRedirect("home");

		}
		
		if (uri.endsWith("/ListeAtt")) {
			view = action.attent(request);
			response.sendRedirect("home");

		}
		
		if (uri.endsWith("/Cat")) {
			view = action.cat(request);
			request.getRequestDispatcher(view).forward(request, response);

		}
		
		if (uri.endsWith("/dellnoti")) {
			view = action.dellnoti(request);
			response.sendRedirect("home");


		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uri = req.getRequestURI();

		String view = "/views/Error.jsp";
		if (uri.endsWith("/Addfile")) {

			String string = getServletContext().getRealPath("data");
			String[] parts = string.split(".metadata");
			String part1 = parts[0] +"Web\\WebContent\\data"; 
			System.out.println(part1);

			view = action.addpost(req ,part1);

			if(view.equals("ok")) {

				resp.sendRedirect("../ListeP");

			}
		}


	}




}
