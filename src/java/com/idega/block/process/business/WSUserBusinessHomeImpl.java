/*
 * $Id: WSUserBusinessHomeImpl.java,v 1.2 2006/04/08 12:13:16 laddi Exp $
 * Created on Apr 3, 2006
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
public class WSUserBusinessHomeImpl extends IBOHomeImpl implements WSUserBusinessHome {

	/**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 9094881914447029995L;

	protected Class getBeanInterfaceClass() {
		return WSUserBusiness.class;
	}

	public WSUserBusiness create() throws javax.ejb.CreateException {
		return (WSUserBusiness) super.createIBO();
	}
}
