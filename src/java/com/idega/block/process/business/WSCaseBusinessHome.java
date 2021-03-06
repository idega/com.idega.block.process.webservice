/*
 * $Id: WSCaseBusinessHome.java,v 1.1 2006/03/17 20:06:05 thomas Exp $
 * Created on Mar 17, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.business;

import com.idega.business.IBOHome;


/**
 * 
 *  Last modified: $Date: 2006/03/17 20:06:05 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public interface WSCaseBusinessHome extends IBOHome {

	public WSCaseBusiness create() throws javax.ejb.CreateException, java.rmi.RemoteException;
}
