/*
 * $Id: WebServiceAuthorizationFilter.java,v 1.1 2006/04/04 18:05:59 thomas Exp $
 * Created on Apr 4, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.webservice.security;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import javax.ejb.FinderException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.misc.BASE64Decoder;
import com.idega.business.IBORuntimeException;
import com.idega.core.accesscontrol.business.AccessController;
import com.idega.core.accesscontrol.business.LoginBusinessBean;
import com.idega.core.accesscontrol.data.LoginTable;
import com.idega.core.accesscontrol.data.LoginTableHome;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWApplicationContext;
import com.idega.idegaweb.IWMainApplication;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.Group;
import com.idega.user.data.User;
import com.idega.util.StringHandler;


/**
 * 
 *  Last modified: $Date: 2006/04/04 18:05:59 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class WebServiceAuthorizationFilter implements Filter {
	
	private final String WEB_SERVICE_USER_ROLE = "web_service_user"; 
	
	LoginBusinessBean loginBusiness = null;
	
	LoginTableHome loginTableHome = null;
	
	BASE64Decoder myBase64Decoder = null;
	
	UserBusiness userBusiness = null;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest,
	 *      javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest myRequest, ServletResponse myResponse,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)myRequest;
		HttpServletResponse response = (HttpServletResponse)myResponse;
		if (! requestIsValid(request)) {
			//send a 403 error
			response.sendError(HttpServletResponse.SC_FORBIDDEN);
			return;
		}
		chain.doFilter(request, response);
	}
		
		
	private boolean requestIsValid(HttpServletRequest request) {
		String decodedNamePassword = getDecodedNamePassword(request);
		if (decodedNamePassword == null) {
			return false;
		}
		int delimiterIndex = decodedNamePassword.indexOf(":");
		if (delimiterIndex < 0) {
			return false;
		}
		String name = decodedNamePassword.substring(0, delimiterIndex);
		String password = decodedNamePassword.substring(delimiterIndex + 1);
		if (! StringHandler.isNotEmpty(name)) {
			return false;
		}
		if (! StringHandler.isNotEmpty(password)) {
			return false;
		}
		return checkUserPasswordAndRole(request, name, password);
	}
	
	private boolean checkUserPasswordAndRole(HttpServletRequest myRequest, String name, String password) {
		ServletContext myServletContext = myRequest.getSession().getServletContext();
	   	// getting the application context
    	IWMainApplication mainApplication = IWMainApplication.getIWMainApplication(myServletContext);
    	IWApplicationContext iwac = mainApplication.getIWApplicationContext();
    	try {
    		LoginTable loginTable = getLoginTableHome().findByLogin(name);
    		if (! hasRole(loginTable, mainApplication)) {
    			return false;
    		}
    		return getLoginBusiness(iwac).verifyPassword(loginTable, password);
    	}
    	catch (FinderException ex) {
    		return false;
    	}
	}
	
	private boolean hasRole(LoginTable loginTable, IWMainApplication iwMainApplication) {
		User user = loginTable.getUser();
		List groups = user.getParentGroups();
		Iterator groupIterator = groups.iterator();
		AccessController accessController = iwMainApplication.getAccessController();
		while (groupIterator.hasNext()) {
			Group group = (Group) groupIterator.next();
			if (accessController.hasRole(WEB_SERVICE_USER_ROLE, group, null)) {
				return true;
			}
		}
		return false;
	}
	
	private String getDecodedNamePassword(HttpServletRequest request) {
		String basicNamePassword = request.getHeader("Authorization");
		if (basicNamePassword == null) {
			return null;
		}
		basicNamePassword = basicNamePassword.trim();
		if (! basicNamePassword.startsWith("Basic")) {
			return null;
		}
		if (basicNamePassword.length() < 6 ) {
			return null;
		}
		String namePassword = basicNamePassword.substring(6);
		try {
			byte[] decodedNamePasswordArray = myBase64Decoder.decodeBuffer(namePassword);
			ByteBuffer wrappedDecodedNamePasswordArray = ByteBuffer.wrap(decodedNamePasswordArray);
			Charset charset = Charset.forName("ISO-8859-1");
			CharBuffer buffer = charset.decode(wrappedDecodedNamePasswordArray);
			return buffer.toString();
		}
		catch (IOException ex) {
			return null;
		}
	}
    	
    private LoginBusinessBean getLoginBusiness(IWApplicationContext iwac) {
    	if (loginBusiness == null) { 
        	loginBusiness = LoginBusinessBean.getLoginBusinessBean(iwac);
    	}
    	return loginBusiness;
	}
		
	private LoginTableHome getLoginTableHome() {
		if (loginTableHome == null) {
			try {
				loginTableHome = (LoginTableHome) IDOLookup.getHome(LoginTable.class);
			}
			catch (IDOLookupException ile) {
				throw new IBORuntimeException(ile);
			}
		}
		return loginTableHome;
	}
		
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig arg0) throws ServletException {
		myBase64Decoder = new BASE64Decoder();
	}
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// noting to destroy
	}
	
}