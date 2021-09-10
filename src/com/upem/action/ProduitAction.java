package com.upem.action;


import java.io.File;
import java.io.IOException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Vector;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.upem.dao.IComment;
import com.upem.dao.IEmprunt;
import com.upem.dao.IListeAttente;
import com.upem.dao.INotification;
import com.upem.dao.IProduit;
import com.upem.dao.IUser;
import com.upem.dao.Icategorie;
import com.upem.models.Categorie;
import com.upem.models.Commentaire;
import com.upem.models.Emprunt;
import com.upem.models.ListeAttente;
import com.upem.models.Notification;
import com.upem.models.Produit;
import com.upem.models.User;
import com.oreilly.servlet.MultipartRequest;


public class ProduitAction {
	private IProduit stub; 
	private Icategorie stubCateg; 
	private IEmprunt stubEmprunt; 
	private IComment stubcom;
	private IUser stubuser;
	private IListeAttente stublist;
	private INotification stubnotif;
	public ProduitAction() {

		try {

			stub=(IProduit)Naming.lookup("rmi://localhost:1099/Produit");
			stubCateg = (Icategorie)Naming.lookup("rmi://localhost:1099/categorie");
			stubEmprunt= (IEmprunt)Naming.lookup("rmi://localhost:1099/Emprunt");
			stubcom= (IComment)Naming.lookup("rmi://localhost:1099/commentaire");
			stubuser= (IUser)Naming.lookup("rmi://localhost:1099/User");
			stublist= (IListeAttente)Naming.lookup("rmi://localhost:1099/liste");
			stubnotif= (INotification)Naming.lookup("rmi://localhost:1099/Notification");


		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String allProduit(HttpServletRequest request) throws RemoteException {

		Vector<Produit> vec = stub.getProduits();
		System.out.println(vec.size());

		return "/views/login.jsp";
	}

	public String home(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		Vector<Produit> vec = stub.getProduits();
		Vector<Notification>not = stubnotif.notificationsWithidUser(U.getIdUser());
		request.setAttribute("noti", not);
		
		request.setAttribute("produit", vec);
		
		
		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);

		return "/views/Home.jsp";
	}
	
	public String cat(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		//------------------------to add for no  more problemes------------------------------------------------------
		Vector<Notification>not = stubnotif.notificationsWithidUser(U.getIdUser());
		request.setAttribute("noti", not);
		//---------------------------------------------------------------------------------
		
		int x = Integer.parseInt(request.getParameter("lola"));
		Vector<Produit> vec = stub.ProduitwithCat(x);
		System.out.println(vec.size());
		
		request.setAttribute("produit", vec);
		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);

		return "/views/Home.jsp";
	}
	
	
	public String dellnoti(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		int x = Integer.parseInt(request.getParameter("lola"));
		stubnotif.deleteNotification(x);

		return "/views/Home.jsp";
	}

	public String addP(HttpServletRequest request) throws RemoteException {
		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);
		return "/views/AddProduit.jsp";
	}

	public String add(HttpServletRequest request) throws RemoteException {
		int i=0;
		/*Vector<Categorie>categories = stubCateg.categories();

		for (Categorie categorie : categories) {

			System.out.println(categorie.getId()  +" " + categorie.getDesig());
			if(categorie.getDesig().equals(request.getParameter("cat"))) {
				i = categorie.getId();
			}
		}

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");

		Produit a= new Produit();

		a.setDesig(request.getParameter("desgn").toString());
		a.setEtat(request.getParameter("Etat").toString());
		a.setCategorie(i);
		a.setCommentaire(request.getParameter("com").toString());
		a.setStatut("Disponible");

		if(U!=null) {
			a.setIdUser(U.getIdUser());
			stub.addProduit(a);
		}
		 */


		try {
			//ProduitAction.getRealPath("/");

			MultipartRequest m = new MultipartRequest(request, "f:/new");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  


		return "ok";
	}

	public String ListeP(HttpServletRequest request) throws RemoteException {
		Vector<Categorie>categories = stubCateg.categories();
		Vector<Produit> vec = stub.getProduits();
		request.setAttribute("categorie", categories);
		request.setAttribute("produit", vec);
		return "/views/listeProduit.jsp";
	}

	public String delete(HttpServletRequest request) throws RemoteException {
		Vector<Produit> vec = stub.getProduits();
		int a= Integer.parseInt(request.getParameter("ed"));
		for (Produit produit : vec) {
			if(produit.getId()==a) {
				stub.deleteProduit(produit);
				return "ok";			}
		}	
		return "notOk";
	}

	public String Edite(HttpServletRequest request) throws RemoteException {
		Vector<Produit> vec = stub.getProduits();
		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);
		System.out.println(request.getParameter("ed"));
		int a= Integer.parseInt(request.getParameter("ed"));
		for (Produit produit : vec) {
			if(produit.getId()==a) {
				request.setAttribute("obj", produit);
				return "/views/Edite.jsp";			

			}
		}
		return "/views/Edite.jsp";

	}

	public String EditeP(HttpServletRequest request) throws RemoteException {
		Vector<Categorie>categories = stubCateg.categories();
		Vector<Produit> vec = stub.getProduits();
		request.setAttribute("categorie", categories);
		request.setAttribute("produit", vec);
		System.out.println();
		return "/views/ModifierProduit.jsp";
	}
	
	public String EditePu(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		Vector<Categorie>categories = stubCateg.categories();
		Vector<Produit> vec = stub.getProduitwithuser(U.getIdUser());
		request.setAttribute("categorie", categories);
		request.setAttribute("produit", vec);
		System.out.println();
		return "/views/ModifierProduit.jsp";
	}

	public String deleteP(HttpServletRequest request) throws RemoteException {
		Vector<Categorie>categories = stubCateg.categories();
		Vector<Produit> vec = stub.getProduits();
		request.setAttribute("categorie", categories);
		request.setAttribute("produit", vec);
		System.out.println();
		return "/views/deleteProduit.jsp";
	}
	
	public String deletePu(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		
		Vector<Categorie>categories = stubCateg.categories();
		Vector<Produit> vec = stub.getProduitwithuser(U.getIdUser());
		request.setAttribute("categorie", categories);
		request.setAttribute("produit", vec);
		System.out.println();
		return "/views/deleteProduit.jsp";
	}

	public String update(HttpServletRequest request) throws RemoteException {
		int i=0;
		Vector<Categorie>categories = stubCateg.categories();

		for (Categorie categorie : categories) {

			System.out.println(categorie.getId()  +" " + categorie.getDesig());
			if(categorie.getDesig().equals(request.getParameter("cat"))) {
				i = categorie.getId();

			}
		}
		Produit a= new Produit();
		a.setDesig(request.getParameter("desgn").toString());
		a.setEtat(request.getParameter("Etat").toString());
		a.setCategorie(i);
		a.setId(Integer.parseInt(request.getParameter("idP")));
		a.setCommentaire(request.getParameter("comm"));
		a.setStatut(request.getParameter("stat"));

		stub.Update(a);

		return "ok";
	}

	public String addpost(HttpServletRequest request , String path) throws RemoteException {
		int i=0;
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		if(U!=null) {
			Vector<Categorie>categories = stubCateg.categories();

			try {

				MultipartRequest m = new MultipartRequest(request, path);
				File myFile = m.getFile("db");

				if(myFile ==null) {

					return "notok";
				}else

					for (Categorie categorie : categories) {

						if(categorie.getDesig().equals( m.getParameter("cat"))) {
							i = categorie.getId();
						}	
					}

				Produit a= new Produit();
				a.setDesig(m.getParameter("desgn").toString());
				a.setEtat(m.getParameter("Etat").toString());
				a.setCategorie(i);
				a.setCommentaire(m.getParameter("com").toString());
				a.setStatut("Disponible");
				a.setIdUser(U.getIdUser());
				a.setPrix(Float.parseFloat(m.getParameter("prix").toString()));
				a.setImagepath(myFile.getName());
				stub.addProduit(a);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}

		return "ok";
	}

	public String emprunter(HttpServletRequest request) throws RemoteException {
		System.out.println(request.getParameter("lola")); 
		String Prod = request.getParameter("lola");

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		if((U!=null)&&(Prod!=null)) {
			int a  = Integer.parseInt(Prod);
			Vector<Produit> vec =stub.getProduits();
			for (Produit produit : vec) {
				if(produit.getId() == a) {
					produit.getStatut().equals("Disponible");
					Emprunt E = new Emprunt();
					LocalDate lt  = LocalDate.now(); 
					E.setDateEmprunt(lt);
					E.setIdProduit(a);
					E.setUser(U.getIdUser());
					System.out.println(E.getIdProduit() +" " +   E.getDateEmprunt() + " " + E.getUser());
					stubEmprunt.addEmprunt(E);
					produit.setStatut("Indisponible");
					stub.Update(produit);

				}
			}

		}



		return "ok";
	}

	public String Dash(HttpServletRequest request) throws RemoteException {

		Vector<Produit> vec = stub.getProduits();
		request.setAttribute("produit", vec);

		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);

		return "/views/Dashjsp.jsp";
	}


	public String restituer(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		Vector<Emprunt> v1=  stubEmprunt.EmpruntProduitUser2(U.getIdUser());
		System.out.println(v1.size());
		Vector<Produit> v2 = new Vector<Produit>();

		for (Emprunt p : v1 ) {
			v2.add(stub.getProduitID(p.getIdProduit()).firstElement());
		}

		request.setAttribute("produit", v2);
		Vector<Categorie>categories = stubCateg.categories();
		request.setAttribute("categorie", categories);

		return "/views/restituer.jsp";
	}

	public String infoP(HttpServletRequest request) throws RemoteException {
		String Prod = request.getParameter("lola");
		int a = Integer.parseInt(Prod);

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");
		request.setAttribute("user",U );
		//-----------------------------------------------------
		Vector<Produit> vec = stub.getProduitID(a);
		request.setAttribute("produit", vec.firstElement());
		//------------------------------------------------------
		Vector<Commentaire>com = stubcom.getCommentaireProduit(a);
		request.setAttribute("com", com);

		Vector<User>use = stubuser.Users();
		request.setAttribute("use", use);

		return "/views/showprod.jsp";
	}

	public String restitu(HttpServletRequest request) throws RemoteException {
		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");

		int prod = Integer.parseInt(request.getParameter("idpr")); 
		//-------------------------------------------------prod--------------------------------------------------------------------------------

		Produit p = stub.getProduitID(prod).firstElement();
		p.setStatut("Disponible");
		//stub.Update(p);

		
		//--------------------------------------------------Emprunt---------------------------------------------------------------------------------------		
		Emprunt em = null;

		Vector<Emprunt> v1=  stubEmprunt.EmpruntProduitUser2(U.getIdUser());
		for (Emprunt emprunt : v1) {
			if(emprunt.getIdProduit() == prod) {
				em= emprunt;
			}
		}
		LocalDate lt   = LocalDate.now(); 
		em.setDateRestitution(lt);
		stubEmprunt.Update(em);
		//---------------------------------------------comment-------------------------------------------------------------------------------------

		if((request.getParameter("nt")!="")&&(request.getParameter("comment")!="")){
			System.out.println("im in");
			Commentaire e = new Commentaire();
			e.setIdUser(U.getIdUser());
			e.setIdProduit(prod);
			e.setComment(request.getParameter("comment"));
			e.setRate(Integer.parseInt(request.getParameter("nt")));
			System.out.println("im in 2"); 
			stubcom.addCommentaire(e) ;
		}

//---------------------------------------------testprio--------------------------------------------------------------------------------------------		
		Emprunt ez = new Emprunt();
		ListeAttente lis = new ListeAttente();
		Vector<ListeAttente>att1 = stublist.listeWithUserType("enseignant", p.getId());
		System.out.println(att1.size());
		Vector<ListeAttente>att2 = stublist.listeWithUserType("etudiant", p.getId());
		System.out.println(att2.size());
		if((att1.size()>0)||(att2.size()>0)) {
//----------------------------------------two teachers-------------------
		int iduser =0;
		int idlist=0;
		if(att1.size()>0) {
			int small=100;
			
			
			if(att1.size()>=2) {
				for (ListeAttente listeAttente : att1) {
					int count =  stubEmprunt.EmpruntProduitUser(listeAttente.getIdUser()).size();
					if(count<small) {
						small =count;
						iduser=listeAttente.getIdUser();
						idlist = listeAttente.getId();
						System.out.println("deux prof");
					}
				} 
			}
			if(att1.size()==1) {
				iduser=att1.firstElement().getIdUser();
				idlist = att1.firstElement().getId();
				System.out.println("un prof");
			}
		}
//----------------------two students--------------------------------		
		if((att2.size()>0)&& (att1.size()==0)){
			int small=100;
			
			if(att2.size()>=2) {
				for (ListeAttente listeAttente : att2) {
					int count =  stubEmprunt.EmpruntProduitUser(listeAttente.getIdUser()).size();
					if(count<small) {
						small =count;
						iduser=listeAttente.getIdUser();
						idlist = listeAttente.getId();
						
						System.out.println("deux etudiants");
					}
				} 
			}
			if(att2.size()==1) {
				iduser=att2.firstElement().getIdUser();
				idlist = att2.firstElement().getId();
				System.out.println("un seule etudiant");
				
			}		
		}
		//------------------------------------------------------------		
		ez.setDateEmprunt(lt);
		ez.setIdProduit(prod);
		ez.setUser(iduser);
		
		lis.setIdUser(iduser);
		lis.setIdproduit(prod);
		lis.setId(idlist);
		
		stubEmprunt.addEmprunt(ez);
		stublist.deletFromListe(lis);
		
		System.out.println("im notif");
		
		Notification n = new Notification();
		n.setProduit(ez.getIdProduit());
		n.setUser(ez.getUser());
		stubnotif.addNotification(n);
		
		}else {
			stub.Update(p);
			System.out.println(" nonn");
			
		}

		return "no";
	}
	//-----------------------------------------------------------------------------------------------------------------------------------------

	public String attent(HttpServletRequest request) throws RemoteException {
		String Prod = request.getParameter("lola");
		int a = Integer.parseInt(Prod);

		HttpSession session = request.getSession();
		User U = (User)session.getAttribute("session");

		ListeAttente li =  new ListeAttente();
		li.setIdproduit(a);
		li.setIdUser(U.getIdUser());

		boolean add = true;
		Vector<ListeAttente>v1 = stublist.ListeAttenteWithUser(U.getIdUser());
		for (ListeAttente list : v1) {
			if(list.getIdproduit() == li.getIdproduit()) {
				add = false;
			}
		}

		if(add==true ) {
			stublist.addtoListeAttente(li);
		}

		return "ok";
	}






}
