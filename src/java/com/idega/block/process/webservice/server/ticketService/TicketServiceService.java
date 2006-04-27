package com.idega.block.process.webservice.server.ticketService;

public interface TicketServiceService extends javax.xml.rpc.Service {
    public java.lang.String getTicketServiceAddress();

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService() throws javax.xml.rpc.ServiceException;

    public com.idega.block.process.webservice.server.ticketService.TicketService getTicketService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
