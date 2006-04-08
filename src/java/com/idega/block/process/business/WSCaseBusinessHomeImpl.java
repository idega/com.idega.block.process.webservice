/*
 * $Id: WSCaseBusinessHomeImpl.java,v 1.2 2006/04/08 12:13:16 laddi Exp $
 * Created on Mar 17, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.business;

import com.idega.business.IBOHomeImpl;


/**
 * 
 *  Last modified: $Date: 2006/04/08 12:13:16 $ by $Author: laddi $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.2 $
 */
public class WSCaseBusinessHomeImpl extends IBOHomeImpl implements WSCaseBusinessHome {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6003428892268304837L;

	protected Class getBeanInterfaceClass() {
		return WSCaseBusiness.class;
	}

	public WSCaseBusiness create() throws javax.ejb.CreateException {
		return (WSCaseBusiness) super.createIBO();
	}
}
