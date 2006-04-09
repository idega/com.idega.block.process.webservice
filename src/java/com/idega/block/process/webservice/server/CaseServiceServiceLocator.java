/**
 * CaseServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

public class CaseServiceServiceLocator extends org.apache.axis.client.Service implements com.idega.block.process.webservice.server.CaseServiceService {

    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -4068439105057329256L;

		public CaseServiceServiceLocator() {
    }


    public CaseServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public CaseServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for CaseService
    private java.lang.String CaseService_address = "http://azskjalfandi.skjalfandi.is/services/CaseService";

    public java.lang.String getCaseServiceAddress() {
        return this.CaseService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String CaseServiceWSDDServiceName = "CaseService";

    public java.lang.String getCaseServiceWSDDServiceName() {
        return this.CaseServiceWSDDServiceName;
    }

    public void setCaseServiceWSDDServiceName(java.lang.String name) {
        this.CaseServiceWSDDServiceName = name;
    }

    public com.idega.block.process.webservice.server.CaseService getCaseService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(this.CaseService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getCaseService(endpoint);
    }

    public com.idega.block.process.webservice.server.CaseService getCaseService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.idega.block.process.webservice.server.CaseServiceSoapBindingStub _stub = new com.idega.block.process.webservice.server.CaseServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getCaseServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setCaseServiceEndpointAddress(java.lang.String address) {
        this.CaseService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.idega.block.process.webservice.server.CaseService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.idega.block.process.webservice.server.CaseServiceSoapBindingStub _stub = new com.idega.block.process.webservice.server.CaseServiceSoapBindingStub(new java.net.URL(this.CaseService_address), this);
                _stub.setPortName(getCaseServiceWSDDServiceName());
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
        if ("CaseService".equals(inputPortName)) {
            return getCaseService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "CaseServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new java.util.HashSet();
            this.ports.add(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "CaseService"));
        }
        return this.ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("CaseService".equals(portName)) {
            setCaseServiceEndpointAddress(address);
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
