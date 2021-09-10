package com.upem.dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Vector;

import com.upem.jdbc.Database;
import com.upem.models.UserType;

public class IUserTypeImp extends UnicastRemoteObject implements IUserType {

	private Database db;
	protected IUserTypeImp(Database db) throws RemoteException {
		this.db=db;
	}

	
	
	
	
	public UserType addUser(UserType u) {
		if(db.Insert("usertype",0,u.getType())>0) return u;
		return null;
	}
	
	public UserType deleteUser(UserType u) {
		if(db.Delete("usertype", "iduserType", u.getUserTypeId())>0) {
			return u;
		}
		return null;
	}
	
	public Vector<UserType> Users() {
		
		return mapping(db.select("usertype"));
	}
	//////////////////////////////////////mapping//////////////////////////
	
	public Vector<UserType>mapping(String data[][]){
		Vector<UserType> users = new Vector<>();
		
		if(data != null) {
			for (int i = 1; i < data.length; i++) {
				users.add(mapRow(data[i]));
			}
		}
		return users;
	}
	
	public UserType mapRow(String row[]) {
		int yp=0;
		try {
			yp =Integer.parseInt(row[0]);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new UserType(yp, row[1]);
	}





	@Override
	public UserType Update(UserType u) throws RemoteException {
		db.Update("usertype", u.getUserTypeId() ,u.getType());
		return u;
	}
}
