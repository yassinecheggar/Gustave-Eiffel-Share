package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.upem.jdbc.Database;

import com.upem.models.User;

public class IUserImp extends UnicastRemoteObject implements IUser {

	protected IUserImp(Database db) throws RemoteException {
		super();
		this.db=db;
	}

	private static final long serialVersionUID = 1L;
	private Database db;
	
	
	


	public User addUser(User u) {
		if(db.Insert("user", u.getIdUser(),u.getLogin(),u.getPasseword(),u.getUserType(),u.getNom(),u.getPrenom())>0) return u;
		
		return null;
	}

	public Vector<User> Users() {
		
		return mapping(db.select("user"));
	}

	public User deleteUser(User u) {
		if(db.Delete("user", "idUser", u.getIdUser())>0) {
			return u;
		}
		
		return null;
	}

	public User findUserWithId(int id) {
		Vector<User>users =  mapping(db.select("user", "idUser", id)); 
		if((users != null)||(users.size()>0)) {
			return users.get(0);
		}
		return null;
	}
	
	public User findUserWithLogin(String login) {
		Vector<User>users =  mapping(db.select("user", "login", login)); 
		if((users != null)||(users.size()>0)) {
			return users.get(0);
		}
		return null;
	}
	////////////////////////mapping ////////////////////////////////////////
	public Vector<User>mapping(String data[][]){
		Vector<User> users = new Vector<>();
		
		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				users.add(mapRow(data[i]));
			}
		}
		return users;
	}
	
	public User mapRow(String row[]) {
		int yp=0, ya=0;
		try {
			yp =Integer.parseInt(row[0]);
			ya= Integer.parseInt(row[3]);
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new User(yp, row[1], row[2], ya,row[4],row[5]);
	}

	@Override
	public User Update(User u) throws RemoteException {
		db.Update("user", u.getIdUser(),u.getLogin(),u.getPasseword(),u.getUserType(), u.getNom(),u.getPrenom());
		return u;
	}


}
