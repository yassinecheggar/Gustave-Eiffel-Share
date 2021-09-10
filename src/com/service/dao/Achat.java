/**
 * Achat.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service.dao;

public interface Achat extends java.rmi.Remote {
    public com.upem.models.Produit[] getdata() throws java.rmi.RemoteException;
    public int getdakchi() throws java.rmi.RemoteException;
    public com.upem.models.Produit[] produits() throws java.rmi.RemoteException;
    public void adduser(com.upem.models.User u) throws java.rmi.RemoteException;
    public void supprimerDuPannier(int idP) throws java.rmi.RemoteException;
    public com.upem.models.User finduser(int u) throws java.rmi.RemoteException;
    public com.upem.models.CompteUtilisateur[] compteUtilisateurs() throws java.rmi.RemoteException;
    public com.upem.models.Commentaire[] commentaires(int id) throws java.rmi.RemoteException;
    public com.upem.models.CompteUtilisateur ajouterCompte(com.upem.models.CompteUtilisateur u) throws java.rmi.RemoteException;
    public java.lang.String ajouteurAuPannier(com.upem.models.Pannier p) throws java.rmi.RemoteException;
    public com.upem.models.Categorie[] getCaProduits() throws java.rmi.RemoteException;
    public com.upem.models.Pannier[] panniers() throws java.rmi.RemoteException;
    public com.upem.models.User finduserWithlogin(java.lang.String log) throws java.rmi.RemoteException;
    public void updateCompte(com.upem.models.CompteUtilisateur c) throws java.rmi.RemoteException;
    public com.upem.models.Pannier[] panniersWithiDuser(int id) throws java.rmi.RemoteException;
    public com.upem.models.CompteUtilisateur find(int id) throws java.rmi.RemoteException;
}
