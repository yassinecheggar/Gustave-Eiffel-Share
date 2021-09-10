/**
 * Produit.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upem.models;

public class Produit  implements java.io.Serializable {
    private int categorie;

    private java.lang.String commentaire;

    private java.lang.String desig;

    private java.lang.String etat;

    private int id;

    private int idUser;

    private java.lang.String imagepath;

    private float prix;

    private java.lang.String statut;

    public Produit() {
    }

    public Produit(
           int categorie,
           java.lang.String commentaire,
           java.lang.String desig,
           java.lang.String etat,
           int id,
           int idUser,
           java.lang.String imagepath,
           float prix,
           java.lang.String statut) {
           this.categorie = categorie;
           this.commentaire = commentaire;
           this.desig = desig;
           this.etat = etat;
           this.id = id;
           this.idUser = idUser;
           this.imagepath = imagepath;
           this.prix = prix;
           this.statut = statut;
    }


    /**
     * Gets the categorie value for this Produit.
     * 
     * @return categorie
     */
    public int getCategorie() {
        return categorie;
    }


    /**
     * Sets the categorie value for this Produit.
     * 
     * @param categorie
     */
    public void setCategorie(int categorie) {
        this.categorie = categorie;
    }


    /**
     * Gets the commentaire value for this Produit.
     * 
     * @return commentaire
     */
    public java.lang.String getCommentaire() {
        return commentaire;
    }


    /**
     * Sets the commentaire value for this Produit.
     * 
     * @param commentaire
     */
    public void setCommentaire(java.lang.String commentaire) {
        this.commentaire = commentaire;
    }


    /**
     * Gets the desig value for this Produit.
     * 
     * @return desig
     */
    public java.lang.String getDesig() {
        return desig;
    }


    /**
     * Sets the desig value for this Produit.
     * 
     * @param desig
     */
    public void setDesig(java.lang.String desig) {
        this.desig = desig;
    }


    /**
     * Gets the etat value for this Produit.
     * 
     * @return etat
     */
    public java.lang.String getEtat() {
        return etat;
    }


    /**
     * Sets the etat value for this Produit.
     * 
     * @param etat
     */
    public void setEtat(java.lang.String etat) {
        this.etat = etat;
    }


    /**
     * Gets the id value for this Produit.
     * 
     * @return id
     */
    public int getId() {
        return id;
    }


    /**
     * Sets the id value for this Produit.
     * 
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }


    /**
     * Gets the idUser value for this Produit.
     * 
     * @return idUser
     */
    public int getIdUser() {
        return idUser;
    }


    /**
     * Sets the idUser value for this Produit.
     * 
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    /**
     * Gets the imagepath value for this Produit.
     * 
     * @return imagepath
     */
    public java.lang.String getImagepath() {
        return imagepath;
    }


    /**
     * Sets the imagepath value for this Produit.
     * 
     * @param imagepath
     */
    public void setImagepath(java.lang.String imagepath) {
        this.imagepath = imagepath;
    }


    /**
     * Gets the prix value for this Produit.
     * 
     * @return prix
     */
    public float getPrix() {
        return prix;
    }


    /**
     * Sets the prix value for this Produit.
     * 
     * @param prix
     */
    public void setPrix(float prix) {
        this.prix = prix;
    }


    /**
     * Gets the statut value for this Produit.
     * 
     * @return statut
     */
    public java.lang.String getStatut() {
        return statut;
    }


    /**
     * Sets the statut value for this Produit.
     * 
     * @param statut
     */
    public void setStatut(java.lang.String statut) {
        this.statut = statut;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Produit)) return false;
        Produit other = (Produit) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.categorie == other.getCategorie() &&
            ((this.commentaire==null && other.getCommentaire()==null) || 
             (this.commentaire!=null &&
              this.commentaire.equals(other.getCommentaire()))) &&
            ((this.desig==null && other.getDesig()==null) || 
             (this.desig!=null &&
              this.desig.equals(other.getDesig()))) &&
            ((this.etat==null && other.getEtat()==null) || 
             (this.etat!=null &&
              this.etat.equals(other.getEtat()))) &&
            this.id == other.getId() &&
            this.idUser == other.getIdUser() &&
            ((this.imagepath==null && other.getImagepath()==null) || 
             (this.imagepath!=null &&
              this.imagepath.equals(other.getImagepath()))) &&
            this.prix == other.getPrix() &&
            ((this.statut==null && other.getStatut()==null) || 
             (this.statut!=null &&
              this.statut.equals(other.getStatut())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getCategorie();
        if (getCommentaire() != null) {
            _hashCode += getCommentaire().hashCode();
        }
        if (getDesig() != null) {
            _hashCode += getDesig().hashCode();
        }
        if (getEtat() != null) {
            _hashCode += getEtat().hashCode();
        }
        _hashCode += getId();
        _hashCode += getIdUser();
        if (getImagepath() != null) {
            _hashCode += getImagepath().hashCode();
        }
        _hashCode += new Float(getPrix()).hashCode();
        if (getStatut() != null) {
            _hashCode += getStatut().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Produit.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://models.upem.com", "Produit"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("categorie");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "categorie"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("commentaire");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "commentaire"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("desig");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "desig"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("etat");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "etat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idUser");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "idUser"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("imagepath");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "imagepath"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prix");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "prix"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "float"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statut");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "statut"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
