package com.service.dao;

public class AchatProxy implements com.service.dao.Achat {
  private String _endpoint = null;
  private com.service.dao.Achat achat = null;
  
  public AchatProxy() {
    _initAchatProxy();
  }
  
  public AchatProxy(String endpoint) {
    _endpoint = endpoint;
    _initAchatProxy();
  }
  
  private void _initAchatProxy() {
    try {
      achat = (new com.service.dao.AchatServiceLocator()).getAchat();
      if (achat != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)achat)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)achat)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (achat != null)
      ((javax.xml.rpc.Stub)achat)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.service.dao.Achat getAchat() {
    if (achat == null)
      _initAchatProxy();
    return achat;
  }
  
  public com.upem.models.Produit[] getdata() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.getdata();
  }
  
  public int getdakchi() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.getdakchi();
  }
  
  public com.upem.models.Categorie[] getCaProduits() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.getCaProduits();
  }
  
  public java.lang.String ajouteurAuPannier(com.upem.models.Pannier p) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.ajouteurAuPannier(p);
  }
  
  public void adduser(com.upem.models.User u) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    achat.adduser(u);
  }
  
  public void supprimerDuPannier(int idP) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    achat.supprimerDuPannier(idP);
  }
  
  public com.upem.models.User finduser(int u) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.finduser(u);
  }
  
  public void updateCompte(com.upem.models.CompteUtilisateur c) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    achat.updateCompte(c);
  }
  
  public com.upem.models.CompteUtilisateur[] compteUtilisateurs() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.compteUtilisateurs();
  }
  
  public com.upem.models.Pannier[] panniers() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.panniers();
  }
  
  public com.upem.models.CompteUtilisateur find(int id) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.find(id);
  }
  
  public com.upem.models.User finduserWithlogin(java.lang.String log) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.finduserWithlogin(log);
  }
  
  public com.upem.models.CompteUtilisateur ajouterCompte(com.upem.models.CompteUtilisateur u) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.ajouterCompte(u);
  }
  
  public com.upem.models.Pannier[] panniersWithiDuser(int id) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.panniersWithiDuser(id);
  }
  
  public com.upem.models.Commentaire[] commentaires(int id) throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.commentaires(id);
  }
  
  public com.upem.models.Produit[] produits() throws java.rmi.RemoteException{
    if (achat == null)
      _initAchatProxy();
    return achat.produits();
  }
  
  
}