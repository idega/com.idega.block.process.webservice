/**
 * TicketServiceServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.ticketService;

public class TicketServiceServiceLocator extends org.apache.axis.client.Service implements com.idega.block.process.webservice.server.ticketService.TicketServiceService {

    public TicketServiceServiceLocator() {
    }


    public TicketServiceServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public TicketServiceServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for TicketService
    private java.lang.String TicketService_address = "http://localhost/services/TicketService";

    public java.lang.String getTicketServiceAddress() {
        return this.TicketService_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String TicketServiceWSDDServiceName = "TicketService";

    public java.lang.String getTicketServiceWSDDServiceName() {
        return this.TicketServiceWSDDServiceName;
    }

    public void setTicketServiceWSDDServiceName(java.lang.String name) {
        this.TicketServiceWSDDServiceName = name;
    }

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(this.TicketService_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getTicketService(endpoint);
    }

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.idega.block.process.webservice.server.ticketService.TicketServiceSoapBindingStub _stub = new com.idega.block.process.webservice.server.ticketService.TicketServiceSoapBindingStub(portAddress, this);
            _stub.setPortName(getTicketServiceWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setTicketServiceEndpointAddress(java.lang.String address) {
        this.TicketService_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.idega.block.process.webservice.server.ticketService.TicketService.class.isAssignableFrom(serviceEndpointInterface)) {
                com.idega.block.process.webservice.server.ticketService.TicketServiceSoapBindingStub _stub = new com.idega.block.process.webservice.server.ticketService.TicketServiceSoapBindingStub(new java.net.URL(this.TicketService_address), this);
                _stub.setPortName(getTicketServiceWSDDServiceName());
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
        if ("TicketService".equals(inputPortName)) {
            return getTicketService();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "TicketServiceService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (this.ports == null) {
            this.ports = new java.util.HashSet();
            this.ports.add(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "TicketService"));
        }
        return this.ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("TicketService".equals(portName)) {
            setTicketServiceEndpointAddress(address);
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
