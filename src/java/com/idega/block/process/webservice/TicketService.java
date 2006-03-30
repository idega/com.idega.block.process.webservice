/*
 * $Id: TicketService.java,v 1.1 2006/03/30 11:18:18 thomas Exp $
 * Created on Mar 27, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.webservice;


public interface TicketService {
	
	public boolean validateTicket(String ticket);
	
}
