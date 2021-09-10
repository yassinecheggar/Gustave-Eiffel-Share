package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.UserType;

public interface IUserType  extends Remote {

	
	public UserType addUser (UserType u) throws RemoteException;
	public Vector <UserType> Users() throws RemoteException;
	public UserType Update(UserType u) throws RemoteException;
	public UserType deleteUser(UserType u) throws RemoteException;
	
	
}
