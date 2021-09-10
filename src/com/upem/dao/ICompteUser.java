package com.upem.dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Vector;

import com.upem.models.CompteUtilisateur;

public interface ICompteUser extends Remote{

	public Vector<CompteUtilisateur> compteUtilisateurs()throws RemoteException;
	public CompteUtilisateur add(CompteUtilisateur C)throws RemoteException;
	public CompteUtilisateur Update(CompteUtilisateur C)throws RemoteException;
	public CompteUtilisateur Delet(int C)throws RemoteException;
	public CompteUtilisateur findwithid(int C)throws RemoteException;
}
