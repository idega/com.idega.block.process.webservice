package com.idega.block.process.business;

import com.idega.block.process.data.Case;
import com.idega.block.process.webservice.server.CaseEntry;

public interface WSCaseBusiness {
	public Case createOrUpdateCase(CaseEntry wsCase) throws Exception;
}
