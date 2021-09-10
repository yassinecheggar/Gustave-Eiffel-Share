package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.User;

public interface IUser extends Remote  {
	
	public User addUser (User u)throws RemoteException;
	public Vector <User> Users()throws RemoteException;
	public User deleteUser(User u)throws RemoteException;
	public User Update(User u)throws RemoteException;
	public User findUserWithId(int id)throws RemoteException;
	public User findUserWithLogin(String login)throws RemoteException;
	

}
