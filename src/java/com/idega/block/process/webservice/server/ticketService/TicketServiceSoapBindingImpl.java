/**
 * TicketServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.ticketService;

import com.idega.block.process.security.business.TicketBusiness;
import com.idega.business.IBOLookup;
import com.idega.idegaweb.IWMainApplication;

public class TicketServiceSoapBindingImpl implements com.idega.block.process.webservice.server.ticketService.TicketService{
    public boolean validateTicket(java.lang.String in0) throws java.rmi.RemoteException {
		TicketBusiness bus1 = (TicketBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), TicketBusiness.class);
		return bus1.validateTicket(in0);
    }

}
