package com.service.dao;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.upem.models.Produit;

public class clienttest {

	
	public static void main(String[] args) throws ServiceException, RemoteException {
		Achat tt  = new AchatServiceLocator().getAchat();
		for (Produit string : tt.getdata()) {
			System.out.println(string);	
		}
		
		}
}
