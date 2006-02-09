/**
 * CaseServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

import java.rmi.RemoteException;

import javax.ejb.FinderException;

import com.idega.block.process.business.CaseBusiness;
import com.idega.business.IBOLookup;
import com.idega.idegaweb.IWMainApplication;

public class CaseServiceSoapBindingImpl implements com.idega.block.process.webservice.server.CaseService{
    public com.idega.block.process.webservice.server.CaseResult createOrUpdateCase(com.idega.block.process.webservice.server.CaseEntry in0) throws java.rmi.RemoteException {
    		System.out.println("[NewCaseBindingImpl (WebService)] method is called");
		CaseResult res = new CaseResult();
		CaseBusiness bus1 = (CaseBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), CaseBusiness.class);
		try {
			CaseBusiness business = bus1.getCaseBusiness(in0.getCode());
			//business.createOrUpdateCase(part_request);
			if (in0.getId() != null && !"".equals(in0.getId())) {
				res.setId(in0.getId());
				res.setOperation("updated");
			} else {
				res.setId("1");
				res.setOperation("inserted");				
			}
		}
		catch (FinderException e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		
		return res;
    }
}