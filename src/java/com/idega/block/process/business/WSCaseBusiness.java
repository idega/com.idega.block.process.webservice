/*
 * $Id: WSCaseBusiness.java,v 1.3 2006/03/17 20:06:05 thomas Exp $
 * Created on Mar 17, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.business;

import com.idega.block.process.data.Case;
import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.webservice.server.CaseEntry;
import com.idega.block.process.webservice.server.Owner;
import com.idega.business.IBOService;
import com.idega.user.data.User;


/**
 * 
 *  Last modified: $Date: 2006/03/17 20:06:05 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.3 $
 */
public interface WSCaseBusiness extends IBOService {

	/**
	 * @see com.idega.block.process.business.WSCaseBusinessBean#createOrUpdateCase
	 */
	public Case createOrUpdateCase(CaseEntry wsCase) throws Exception, java.rmi.RemoteException;

	/**
	 * @see com.idega.block.process.business.WSCaseBusinessBean#updateUserInformation
	 */
	public void updateUserInformation(User user, Owner owner) throws java.rmi.RemoteException;

	/**
	 * @see com.idega.block.process.business.WSCaseBusinessBean#changeCaseStatus
	 */
	public void changeCaseStatus(Case theCase, CaseStatus newCaseStatus, User performer, String updateMessage)
			throws java.rmi.RemoteException;
}
