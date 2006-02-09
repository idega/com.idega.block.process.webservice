/**
 * CaseServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

public interface CaseServiceService extends javax.xml.rpc.Service {
    public java.lang.String getCaseServiceAddress();

    public com.idega.block.process.webservice.server.CaseService getCaseService() throws javax.xml.rpc.ServiceException;

    public com.idega.block.process.webservice.server.CaseService getCaseService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
