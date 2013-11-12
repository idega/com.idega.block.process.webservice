package com.idega.block.process.business;

import java.rmi.RemoteException;
import java.util.Collection;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

import com.idega.block.process.data.Case;
import com.idega.block.process.data.CaseCode;
import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.message.business.MessageBusiness;
import com.idega.block.process.webservice.server.CaseEntry;
import com.idega.block.process.webservice.server.CaseResult;
import com.idega.block.process.webservice.server.Handler;
import com.idega.block.process.webservice.server.Item;
import com.idega.block.process.webservice.server.Organization;
import com.idega.block.process.webservice.server.Owner;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.idegaweb.IWMainApplication;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.Group;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;
import com.idega.util.StringHandler;

public class WSCaseBusinessBean extends CaseBusinessBean implements WSCaseBusiness {

	private static final long serialVersionUID = -7507655249872022683L;

	private final String DO_BASIC_AUTHENTICATION = "WS_DO_BASIC_AUTHENTICATION";

	private boolean autocreateOwner=false;

	@Override
	public CaseResult createOrUpdateCase(CaseEntry wsCase) throws Exception {

		boolean storeCase = false;
		// find an existing case
		Case theCase = findExistingCase(wsCase);
		boolean caseIsUpdated = (theCase != null);

		// could we create a new case?
		// status is needed, case code is needed and owner is needed

		// try to get an owner (not required when updating)
		Owner wsOwner = wsCase.getOwner();
		User uOwner = null;
		if (wsOwner != null) {
			uOwner = findOwner(wsOwner);
		}
		// not required when updating
		String newStatus = wsCase.getStatus();
		if (StringHandler.isEmpty(newStatus)) {
			newStatus = null;
		}
		// not required when updating
		String caseCode = wsCase.getCode();
		CaseCode code = null;
		if (StringHandler.isNotEmpty(caseCode)) {
			 code = getCaseCodeAndInstallIfNotExists(caseCode);
		}
		boolean canCreateNewCase = (newStatus != null && uOwner != null && code != null);

		// create a new case if we haven't found an existing one and if a owner is known
		// do not create a case without an owner
		if ( ! caseIsUpdated && canCreateNewCase) {
			storeCase = true;
			theCase = createCase();
			// a new case was created
			theCase.setCreated(new IWTimestamp(wsCase.getCreated()).getTimestamp());
		}
		else if (! caseIsUpdated && uOwner == null) {
			// owner could not be found
			CaseResult caseResult = new CaseResult();
			caseResult.setId("-2");
			caseResult.setOperation("create/update failed");
			return caseResult;
		}

		// still no case? Giving up....
		if (theCase == null) {
			throw new CreateException();
		}

		if (uOwner != null) {
			storeCase = true;
			// the owner was fetched from the request, set the owner
			theCase.setOwner(uOwner);
		}
		else {
			// uOwner is null, try to get the owner from the case
			// if the case already exists we take the owner from there
			uOwner = theCase.getOwner();
		}

		// now the uOwner is not null and theCase is not null
		// but wsOwner could be null
		if (wsOwner != null) {
    			IWMainApplication mainApplication = IWMainApplication.getDefaultIWMainApplication();
    			boolean doCheck = mainApplication.getIWApplicationContext().getApplicationSettings().getBoolean(this.DO_BASIC_AUTHENTICATION, true);

    			if (doCheck) {
    				updateUserInformation(uOwner, wsOwner);
    			}
		}

		// prepare the user messages
		// first set the metadata, it is used in setUserMessage
		Item[] metadata = wsCase.getMetadata();
		// metadata not required, do a lot of null checks !!!!
		String subject = null;
		String body = null;
		if (metadata != null) {
			for (int i = 0; i < metadata.length; i++) {
				Item item = metadata[i];
				if (item != null) {
					String key = item.getKey();
					String value = item.getValue();
					if (key != null && value != null) {
						if (WSCaseConstants.MAIL_MESSAGE_SUBJECT.equals(key)) {
							subject = value;
						}
						if (WSCaseConstants.MAIL_MESSAGE_BODY.equals(key)) {
							body = value;
						}
						storeCase = true;
						theCase.setMetaData(key, value);
					}
				}
			}
		}

		CaseStatus newCaseStatus = null;
		if (newStatus != null) {
			storeCase = true;
			// match to four digits
			newStatus = convertStatus(newStatus);
			// create CaseStatus entry if necessary
			 newCaseStatus = getCaseStatus(newStatus);

			// was the case created or updated?
			if (caseIsUpdated) {
				changeCaseStatus(theCase, newCaseStatus, uOwner, subject, body);
			}
			else {
				setCaseStatus(theCase, newCaseStatus, uOwner, subject, body);
			}
		}
		// set at least a messagel
		else {
			setUserMessage(theCase, uOwner, subject, body);
		}

		// handler not required
		Handler handler = wsCase.getHandler();
		if (handler != null) {
			storeCase = setHandler(handler, theCase);
		}

		// external case id could be null
		String externalCaseId = wsCase.getExternalCase_id();
		if (externalCaseId != null) {
			storeCase = true;
			theCase.setExternalId(externalCaseId);
		}

		// set case code

		if (caseCode != null) {
			storeCase = true;
			theCase.setCaseCode(code);
		}

		String wsSubject = wsCase.getSubject();
		if (StringHandler.isNotEmpty(wsSubject)) {
			storeCase = true;
			theCase.setSubject(wsSubject);
		}

		String wsBody = wsCase.getBody();
		if (StringHandler.isNotEmpty(wsBody)) {
			storeCase = true;
			theCase.setBody(wsBody);
		}

		// time to store....
		if (storeCase) {
			theCase.store();
		}

		CaseResult caseResult = new CaseResult();
		caseResult.setId(theCase.getUniqueId());
		caseResult.setOperation("success");

		return caseResult;
	}


	@Override
	public void updateUserInformation(User user, Owner owner) throws CreateException{

		//Update emails:
		String sEmail = owner.getEmail();
		if (sEmail != null && sEmail.length() > 0) {
			try {
				getUserBusiness().updateUserMail(user, sEmail);
			}
			catch (RemoteException ex) {
				throw new IBORuntimeException();
			}
		}

		//Update phone:

		String sPhone = owner.getPhone();
		if(sPhone != null && sPhone.length() > 0) {
			try {
				getUserBusiness().updateUserHomePhone(user,sPhone);
			}
			catch (EJBException e) {
				e.printStackTrace();
			}
			catch (RemoteException e) {
				e.printStackTrace();
			}
		}
		String mobile = owner.getGsm();
		if(mobile != null && mobile.length() > 0){
			try {
				getUserBusiness().updateUserMobilePhone(user,mobile);
			}
			catch (EJBException e) {
				e.printStackTrace();
			}
			catch (RemoteException e) {
				e.printStackTrace();
			}
		}
	}


	private User findOwner(Owner owner) throws CreateException {
		try {
			User uOwner = getUserHome().findByPersonalID(owner.getSocialsecurity());
			System.out.println("[CaseBusiness : craeteOrUpdateCase] owner = "+uOwner.getPersonalID());
			return uOwner;
		}
		catch (FinderException f) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] no owner");
			if(this.autocreateOwner){
				//getUserBusiness().createUserByPersonalIDIfDoesNotExist()
				User uOwner = getUserHome().create();
				uOwner.setFullName(owner.getName());
				uOwner.setPersonalID(owner.getSocialsecurity());
				uOwner.store();
				return uOwner;
			}
			f.printStackTrace();
			return null;
		}
	}


	private Case findExistingCase(CaseEntry wsCase) throws FinderException{
		String id = wsCase.getId();
		if (id == null || "-1".equals(id)) {
			try{
				String externalId = wsCase.getExternalCase_id();
				Case theCase = getCaseHome().findCaseByExternalId(externalId);
				log("[CaseBusiness : craeteOrUpdateCase] updating");
				return theCase;
			}
			catch(FinderException e){
				log("[CaseBusiness : craeteOrUpdateCase] creating");
				return null;
			}
		}
		return getCaseHome().findCaseByUniqueId(id);
	}

	private Case createCase() throws CreateException {
		return  getCaseHome().create();
	}

	@Override
	public void changeCaseStatus(Case theCase, CaseStatus newCaseStatus, User performer,String updateMessageSubject, String updateMessageBody) {
		changeCaseStatusDoNotSendUpdates(theCase, newCaseStatus.getStatus(), performer);
		setUserMessage(theCase, performer, updateMessageSubject, updateMessageBody);
	}

	private void setCaseStatus(Case theCase, CaseStatus caseStatus, User performer, String messageSubject, String messageBody) {
		theCase.setCaseStatus(caseStatus);
		setUserMessage(theCase, performer, messageSubject, messageBody);
	}

	private boolean setHandler(Handler handler, Case theCase) {
		boolean theCaseIsModified = false;
		String handlerPersonalId = handler.getSocialsecurity();
		if(StringHandler.isNotEmpty(handlerPersonalId)){
			try {
				User uHandler = getUserHome().findByPersonalID(handlerPersonalId);
				theCase.setExternalHandler(uHandler);
				theCaseIsModified = true;
			}
			catch (FinderException f) {
				logError("[CaseBusiness : createOrUpdateCase] no handler");
				f.printStackTrace();
				return false;
			}
		}
		Organization organization = handler.getOrganization();
		if (organization != null) {
			String nameOfOrganization = organization.getName();
			if (StringHandler.isNotEmpty(nameOfOrganization)) {
				try {
					Collection<Group> groups = getGroupBusiness().getGroupsByGroupName(nameOfOrganization);
					if (groups == null || groups.isEmpty()) {
						logError("[CaseBusiness : createOrUpdateCase] no handler");
					}
					else {
						Group group = groups.iterator().next();
						theCase.setHandler(group);
						theCaseIsModified = true;
					}
				}
				catch (RemoteException e) {
					logError(e.getMessage());
					throw new IBORuntimeException(e);
				}
			}
		}
		return theCaseIsModified;
	}


	private void setUserMessage(Case theCase, User user, String subject, String body) {
		// check if sending an email makes sense
		boolean subjectIsEmpty = StringHandler.isEmpty(subject);
		boolean bodyIsEmpty = StringHandler.isEmpty(body);
		if (subjectIsEmpty && bodyIsEmpty) {
			return;
		}
		if (subjectIsEmpty) {
			subject = "message";
		}
		if (bodyIsEmpty) {
			body = "see subject";
		}
		MessageBusiness messageBusiness = getMessageBusiness();
		// message value needs at least receiver, subject, body
		// we are using default message type
		try {
			messageBusiness.createUserMessage(theCase, user, subject, body, false);
		}
		catch (RemoteException e) {
			throw new RuntimeException(e);
		}
		catch (CreateException e) {
			throw new RuntimeException(e);
		}
	}

	private String convertStatus(String status) {
		if (WSCaseConstants.STATUS_ARCHIVED.equals(status)) {
			return getCaseHome().getCaseStatusArchived();
		}
		if (WSCaseConstants.STATUS_CLOSED.equals(status)) {
			return getCaseHome().getCaseStatusClosed();
		}
	    if (WSCaseConstants.STATUS_IN_PROCESS.equals(status)) {
			return getCaseHome().getCaseStatusInProcess();
		}
		if (WSCaseConstants.STATUS_LOCKED.equals(status)) {
			return getCaseHome().getCaseStatusLocked();
		}
		if (WSCaseConstants.STATUS_PENDING.equals(status)) {
			return getCaseHome().getCaseStatusPending();
		}
		return status;
	}

	private UserBusiness getUserBusiness(){
		try {
			return IBOLookup.getServiceInstance(getIWApplicationContext(), UserBusiness.class);
		} catch (IBOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}

	private MessageBusiness getMessageBusiness() {
		try {
			return IBOLookup.getServiceInstance(getIWApplicationContext(), MessageBusiness.class);
		} catch (IBOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}
}