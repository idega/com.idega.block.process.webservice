package com.idega.block.process.webservice.server.ticketService;

import com.idega.block.process.business.WSTicketBusiness;
import com.idega.business.IBOLookup;
import com.idega.idegaweb.IWMainApplication;

public class TicketServiceSoapBindingImpl implements com.idega.block.process.webservice.server.ticketService.TicketService{
    public boolean validateTicket(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException {
    	try {
    		WSTicketBusiness bus1 = (WSTicketBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), WSTicketBusiness.class);
    		return bus1.validateTicket(in0, in1);
    	}
    	catch (Exception ex) {
    		ex.printStackTrace();
    		return false;
    	}
    }

}
