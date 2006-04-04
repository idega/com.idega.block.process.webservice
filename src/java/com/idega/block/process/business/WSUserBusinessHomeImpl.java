/*
 * $Id: WSUserBusinessHomeImpl.java,v 1.1 2006/04/04 18:01:48 thomas Exp $
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
 *  Last modified: $Date: 2006/04/04 18:01:48 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class WSUserBusinessHomeImpl extends IBOHomeImpl implements WSUserBusinessHome {

	protected Class getBeanInterfaceClass() {
		return WSUserBusiness.class;
	}

	public WSUserBusiness create() throws javax.ejb.CreateException {
		return (WSUserBusiness) super.createIBO();
	}
}
