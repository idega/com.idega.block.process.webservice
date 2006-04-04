/**
 * UserServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.userService;

import com.idega.block.process.business.WSUserBusiness;
import com.idega.business.IBOLookup;
import com.idega.idegaweb.IWMainApplication;

public class UserServiceSoapBindingImpl implements com.idega.block.process.webservice.server.userService.UserService{
    public com.idega.block.process.webservice.server.userService.UserInfo getUserInfo(java.lang.String in0) throws java.rmi.RemoteException {
		WSUserBusiness bus1 = (WSUserBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), WSUserBusiness.class);
		return bus1.getUserInfo(in0);
    }

}
