/*
 * $Id: UserService.java,v 1.1 2006/04/04 18:04:17 thomas Exp $
 * Created on Mar 31, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.webservice;


public interface UserService {
	
	UserInfo getUserInfo(String personalId);
}
