/**
 * AchatService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service.dao;

public interface AchatService extends javax.xml.rpc.Service {
    public java.lang.String getAchatAddress();

    public com.service.dao.Achat getAchat() throws javax.xml.rpc.ServiceException;

    public com.service.dao.Achat getAchat(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
