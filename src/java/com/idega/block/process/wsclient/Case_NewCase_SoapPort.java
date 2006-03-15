/**
 * Case_NewCase_SoapPort.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.wsclient;

public interface Case_NewCase_SoapPort extends javax.xml.rpc.Service {

/**
 * BizTalk assembly "Case, Version=1.0.0.0, Culture=neutral, PublicKeyToken=86d7c3d93827fffd"
 * published web service.
 */
    public java.lang.String getCase_NewCase_SoapPortSoapAddress();

    public com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType getCase_NewCase_SoapPortSoap() throws javax.xml.rpc.ServiceException;

    public com.idega.block.process.wsclient.Case_NewCase_SoapPortSoap_PortType getCase_NewCase_SoapPortSoap(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
