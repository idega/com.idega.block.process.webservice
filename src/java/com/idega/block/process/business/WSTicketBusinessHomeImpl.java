/*
 * $Id: WSTicketBusinessHomeImpl.java,v 1.1 2006/05/18 16:59:36 thomas Exp $
 * Created on May 10, 2006
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
 *  Last modified: $Date: 2006/05/18 16:59:36 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class WSTicketBusinessHomeImpl extends IBOHomeImpl implements WSTicketBusinessHome {

	protected Class getBeanInterfaceClass() {
		return WSTicketBusiness.class;
	}

	public WSTicketBusiness create() throws javax.ejb.CreateException {
		return (WSTicketBusiness) super.createIBO();
	}
}
