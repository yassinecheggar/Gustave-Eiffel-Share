/**
 * Pannier.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.upem.models;

public class Pannier  implements java.io.Serializable {
    private int idPannier;

    private int idProduit;

    private int idUser;

    private java.lang.String status;

    public Pannier() {
    }

    public Pannier(
           int idPannier,
           int idProduit,
           int idUser,
           java.lang.String status) {
           this.idPannier = idPannier;
           this.idProduit = idProduit;
           this.idUser = idUser;
           this.status = status;
    }


    /**
     * Gets the idPannier value for this Pannier.
     * 
     * @return idPannier
     */
    public int getIdPannier() {
        return idPannier;
    }


    /**
     * Sets the idPannier value for this Pannier.
     * 
     * @param idPannier
     */
    public void setIdPannier(int idPannier) {
        this.idPannier = idPannier;
    }


    /**
     * Gets the idProduit value for this Pannier.
     * 
     * @return idProduit
     */
    public int getIdProduit() {
        return idProduit;
    }


    /**
     * Sets the idProduit value for this Pannier.
     * 
     * @param idProduit
     */
    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }


    /**
     * Gets the idUser value for this Pannier.
     * 
     * @return idUser
     */
    public int getIdUser() {
        return idUser;
    }


    /**
     * Sets the idUser value for this Pannier.
     * 
     * @param idUser
     */
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }


    /**
     * Gets the status value for this Pannier.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Pannier.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Pannier)) return false;
        Pannier other = (Pannier) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.idPannier == other.getIdPannier() &&
            this.idProduit == other.getIdProduit() &&
            this.idUser == other.getIdUser() &&
            ((this.status==null && other.getStatus()==null) || 
             (this.status!=null &&
              this.status.equals(other.getStatus())));
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
        _hashCode += getIdPannier();
        _hashCode += getIdProduit();
        _hashCode += getIdUser();
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Pannier.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://models.upem.com", "Pannier"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idPannier");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "idPannier"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("idProduit");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "idProduit"));
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
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("http://models.upem.com", "status"));
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
