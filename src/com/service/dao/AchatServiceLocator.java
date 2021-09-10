/**
 * AchatServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.service.dao;

public class AchatServiceLocator extends org.apache.axis.client.Service implements com.service.dao.AchatService {

    public AchatServiceLocator() {
    }


    public AchatServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public AchatServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Achat
    private java.lang.String Achat_address = "http://localhost:8080/UGESellService/services/Achat";

    public java.lang.String getAchatAddress() {
        return Achat_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String AchatWSDDServiceName = "Achat";

    public java.lang.String getAchatWSDDServiceName() {
        return AchatWSDDServiceName;
    }

    public void setAchatWSDDServiceName(java.lang.String name) {
        AchatWSDDServiceName = name;
    }

    public com.service.dao.Achat getAchat() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Achat_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getAchat(endpoint);
    }

    public com.service.dao.Achat getAchat(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.service.dao.AchatSoapBindingStub _stub = new com.service.dao.AchatSoapBindingStub(portAddress, this);
            _stub.setPortName(getAchatWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setAchatEndpointAddress(java.lang.String address) {
        Achat_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.service.dao.Achat.class.isAssignableFrom(serviceEndpointInterface)) {
                com.service.dao.AchatSoapBindingStub _stub = new com.service.dao.AchatSoapBindingStub(new java.net.URL(Achat_address), this);
                _stub.setPortName(getAchatWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("Achat".equals(inputPortName)) {
            return getAchat();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://dao.service.com", "AchatService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://dao.service.com", "Achat"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Achat".equals(portName)) {
            setAchatEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
