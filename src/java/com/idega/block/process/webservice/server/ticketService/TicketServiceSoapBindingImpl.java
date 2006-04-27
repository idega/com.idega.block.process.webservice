package com.idega.block.process.webservice.server.ticketService;

import com.idega.block.process.security.business.TicketBusiness;
import com.idega.business.IBOLookup;
import com.idega.idegaweb.IWMainApplication;

public class TicketServiceSoapBindingImpl implements com.idega.block.process.webservice.server.ticketService.TicketService{
    public boolean validateTicket(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
    	try {
    		TicketBusiness bus1 = (TicketBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), TicketBusiness.class);
    		return bus1.validateTicket(in0, in1);
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }

}
