/*
 * $Id: WSTicketBusinessBean.java,v 1.1 2006/05/18 16:59:36 thomas Exp $
 * Created on May 10, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;
import com.idega.business.IBOServiceBean;
import com.idega.repository.data.ImplementorRepository;


/**
 * 
 *  Last modified: $Date: 2006/05/18 16:59:36 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class WSTicketBusinessBean  extends IBOServiceBean implements WSTicketBusiness{
	
	public boolean validateTicket(String socialsecurity, String ticket) {
		List loginModules = ImplementorRepository.getInstance().newInstances(LoginModule.class, this.getClass());
		// just a shortcut 
		if (loginModules.isEmpty()) {
			return false;
		}
		CallbackHandler callbackHandler = new WSCallbackHandler(socialsecurity, ticket);
		Map sharedState = new HashMap(1);
		Iterator iterator = loginModules.iterator();
		while (iterator.hasNext()) {
			LoginModule loginModule = (LoginModule) iterator.next();
			try {
				loginModule.initialize(null, callbackHandler, sharedState, null);
				if (loginModule.login()) {
					return true;
				}
			}
			catch (LoginException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
}

class WSCallbackHandler implements CallbackHandler {
	
	private String socialsecurity = null;
	private char[] ticket = null;
	
	WSCallbackHandler(String socialsecurity, String ticket) {
		this.socialsecurity = socialsecurity;
		this.ticket = (ticket == null) ? null : ticket.toCharArray();
	}
		
	public void handle(Callback[] callbacks) {
		for (int i = 0; i < callbacks.length; i++) {
			Callback callback = callbacks[i];
			if (callback instanceof PasswordCallback) {
				PasswordCallback pc = (PasswordCallback)callback;
				pc.setPassword(ticket);
			}
			else if (callback instanceof NameCallback) {
				NameCallback nc = (NameCallback) callback;
				nc.setName(socialsecurity);
			}
		}
	}
}
