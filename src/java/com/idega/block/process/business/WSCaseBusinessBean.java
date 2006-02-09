package com.idega.block.process.business;

import javax.ejb.FinderException;

import com.idega.block.process.data.Case;
import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.block.process.wsclient._case;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;

public class WSCaseBusinessBean extends CaseBusinessBean implements
		WSCaseBusiness {

	public Case createOrUpdateCase(_case wsCase) throws Exception {
		
		String status = wsCase.getStatus();
		System.out.println("[CaseBusiness : craeteOrUpdateCase] status = "+status);
		if (status.equals(WSCaseConstants.STATUS_ARCHIVED)) {
			status = getCaseHome().getCaseStatusArchived();
		} else if (status.equals(WSCaseConstants.STATUS_CLOSED)) {
			status = getCaseHome().getCaseStatusClosed();
		} else if (status.equals(WSCaseConstants.STATUS_IN_PROCESS)) {
			status = getCaseHome().getCaseStatusInProcess();
		} else if (status.equals(WSCaseConstants.STATUS_LOCKED)) {
			status = getCaseHome().getCaseStatusLocked();
		} else if (status.equals(WSCaseConstants.STATUS_PENDING)) {
			status = getCaseHome().getCaseStatusPending();
		} 
		System.out.println("[CaseBusiness : craeteOrUpdateCase] status = "+status);
		
		CaseStatus newCaseStatus = getCaseStatus(status);
		
		String id = wsCase.getId();
		Case theCase = null;
		if (id == null || "-1".equals(id)) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] creating");
			theCase = getCaseHome().create();
			theCase.setCreated(new IWTimestamp(wsCase.getCreated()).getTimestamp());
			theCase.setCaseStatus(newCaseStatus);
		} else {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] updating");
			theCase = getCaseHome().findByPrimaryKey(new Integer(id));
			changeCaseStatus(theCase, newCaseStatus, null);
		}
		theCase.setCode(wsCase.getCode());
		theCase.setExternalId(wsCase.getExternal_case_id());
		theCase.setBody(wsCase.getBody());
		theCase.setSubject(wsCase.getSubject());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Code = "+wsCase.getCode());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] extCase = "+wsCase.getExternal_case_id());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Body = "+wsCase.getBody());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Subject = "+wsCase.getSubject());

		try {
			User owner = getUserHome().findByPersonalID(wsCase.getOwner().getSocialsecurity());
			System.out.println("[CaseBusiness : craeteOrUpdateCase] owner = "+owner.getPersonalID());
			theCase.setOwner(owner);
		} catch (FinderException f) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] no owner");
			f.printStackTrace();
		}
		try {
			User handler = getUserHome().findByPersonalID(wsCase.getHandler().getSocialsecurity());
			System.out.println("[CaseBusiness : craeteOrUpdateCase] handler = "+handler.getPersonalID());
			theCase.setExternalHandler(handler);
		} catch (FinderException f) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] no handler");
			f.printStackTrace();
		}
		theCase.store();
		
		return theCase;
	}
}
