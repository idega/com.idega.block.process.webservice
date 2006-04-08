/**
 * Case_NewCase_SoapPortLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.wsclient;

public class Case_NewCase_SoapPortLocator extends org.apache.axis.client.Service implements com.idega.block.process.wsclient.Case_NewCase_SoapPort {

/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -7531024904811134009L;

/**
 * BizTalk assembly "Case, Version=1.0.0.0, Culture=neutral, PublicKeyToken=86d7c3d93827fffd"
 * published web service.
 */

    public Case_NewCase_SoapPortLocator() {
    }


    public Case_NewCase_SoapPortLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public Case_NewCase_SoapPortLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for Case_NewCase_SoapPortSoap
    private java.lang.String Case_NewCase_SoapPortSoap_address = "http://213.167.155.148/Case/Case_NewCase_SoapPort.asmx";

    public java.lang.String getCase_NewCase_SoapPortSoapAddress() {
        return Case_NewCase_SoapPortSoap_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String Case_NewCase_SoapPortSoapWSDDServiceName = "Case_NewCase_SoapPortSoap";

    public java.lang.String getCase_NewCase_SoapPortSoapWSDDServiceName() {
        return Case_NewCase_SoapPortSoapWSDDServiceName;
    }

    public void setCase_NewCase_SoapPortSoapWSDDServiceName(java.lang.String name) {
        Case_NewCase_SoapPortSoapWSDDServiceName = name;
    }

    public com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType getCase_NewCase_SoapPortSoap() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(Case_NewCase_SoapPortSoap_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCase_NewCase_SoapPortSoap(endpoint);
    }

    public com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType getCase_NewCase_SoapPortSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_BindingStub _stub = new com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_BindingStub(portAddress, this);
            _stub.setPortName(getCase_NewCase_SoapPortSoapWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCase_NewCase_SoapPortSoapEndpointAddress(java.lang.String address) {
        Case_NewCase_SoapPortSoap_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_BindingStub _stub = new com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_BindingStub(new java.net.URL(Case_NewCase_SoapPortSoap_address), this);
                _stub.setPortName(getCase_NewCase_SoapPortSoapWSDDServiceName());
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
        if ("Case_NewCase_SoapPortSoap".equals(inputPortName)) {
            return getCase_NewCase_SoapPortSoap();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://Case/", "Case_NewCase_SoapPort");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://Case/", "Case_NewCase_SoapPortSoap"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("Case_NewCase_SoapPortSoap".equals(portName)) {
            setCase_NewCase_SoapPortSoapEndpointAddress(address);
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
