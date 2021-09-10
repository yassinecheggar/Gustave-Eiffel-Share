package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.Categorie;
import com.upem.models.Notification;

public interface INotification extends Remote {

	public Notification addNotification (Notification N) throws RemoteException;
	public Vector <Notification> notifications() throws RemoteException;
	public Vector <Notification> notificationsWithidUser(int idUser ) throws RemoteException;
	public Notification deleteNotification(int N) throws RemoteException;
	public Notification editNotification(Notification N) throws RemoteException; 
	
}
