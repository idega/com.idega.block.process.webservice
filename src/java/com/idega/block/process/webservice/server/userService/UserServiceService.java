/**
 * UserServiceService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.userService;

public interface UserServiceService extends javax.xml.rpc.Service {
    public java.lang.String getUserServiceAddress();

    public com.idega.block.process.webservice.server.userService.UserService getUserService() throws javax.xml.rpc.ServiceException;

    public com.idega.block.process.webservice.server.userService.UserService getUserService(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
