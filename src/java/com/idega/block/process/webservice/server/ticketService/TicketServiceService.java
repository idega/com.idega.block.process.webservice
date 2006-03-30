/**
 * TicketServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.ticketService;

public interface TicketServiceService extends javax.xml.rpc.Service {
    public java.lang.String getTicketServiceAddress();

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService() throws javax.xml.rpc.ServiceException;

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
