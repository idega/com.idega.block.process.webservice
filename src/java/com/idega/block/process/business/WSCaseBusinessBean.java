package com.idega.block.process.business;

import java.rmi.RemoteException;

import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;

import com.idega.block.process.data.Case;
import com.idega.block.process.data.CaseCode;
import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.message.business.MessageBusiness;
import com.idega.block.process.message.business.MessageValue;
import com.idega.block.process.webservice.server.CaseEntry;
import com.idega.block.process.webservice.server.CaseResult;
import com.idega.block.process.webservice.server.Handler;
import com.idega.block.process.webservice.server.Item;
import com.idega.block.process.webservice.server.Owner;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;
import com.idega.util.StringHandler;

public class WSCaseBusinessBean extends CaseBusinessBean implements
		WSCaseBusiness {

	private UserBusiness userBusiness = null;
	
	private boolean autocreateOwner=false;
	
	public CaseResult createOrUpdateCase(CaseEntry wsCase) throws Exception {
		
		// status is needed, case code is needed
		String newStatus = wsCase.getStatus();
		String caseCode = wsCase.getCode();

		if (StringHandler.isEmpty(caseCode) || StringHandler.isEmpty(newStatus)) {
			throw new CreateException("No case code");
		}
		CaseCode code = getCaseCodeAndInstallIfNotExists(caseCode);
		
		// find an existing case
		Case theCase = findExistingCase(wsCase);
		boolean caseIsUpdated = (theCase != null);
		
		// try to get an owner (not required in the request)
		Owner wsOwner = wsCase.getOwner();
		User uOwner = null;
		if (wsOwner != null) {
			uOwner = findOwner(wsOwner);
		}

		// create a new case if we haven't found an existing one and if a owner is known
		// do not create a case without an owner
		if ( ! caseIsUpdated && uOwner != null) {
			theCase = createCase();
			// a new case was created
			theCase.setCreated(new IWTimestamp(wsCase.getCreated()).getTimestamp());
		}
		
		// still no case? Giving up....
		if (theCase == null) {
			throw new CreateException();
		}
		
		if (uOwner != null) {
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
			updateUserInformation(uOwner, wsOwner);
		}
		
		// prepare the user messages
		// first set the metadata, it is used in setUserMessage
		Item[] metadata = wsCase.getMetadata();
		// metadata not required
		String subject = null;
		String body = null;
		if (metadata != null) {
			setMetadata(metadata, theCase);
			subject = theCase.getMetaData(WSCaseConstants.MAIL_MESSAGE_SUBJECT);
			body = theCase.getMetaData(WSCaseConstants.MAIL_MESSAGE_BODY);
		}
		
		// match to four digits
		newStatus = convertStatus(newStatus);
		// create CaseStatus entry if necessary 
		CaseStatus newCaseStatus = getCaseStatus(newStatus);
		// was the case created or updated?
		if (caseIsUpdated) {
			subject = StringHandler.replaceIfEmpty(subject, "updated Case");
			body = StringHandler.replaceIfEmpty(body, "caseWasUpdated");
			changeCaseStatus(theCase, newCaseStatus, uOwner, subject, body);
		}
		else { 
			subject = StringHandler.replaceIfEmpty(subject, "new Case");
			body = StringHandler.replaceIfEmpty(body, "A new case was created");
			setCaseStatus(theCase, newCaseStatus, uOwner, subject, body);
		}
	
		// handler not required
		Handler handler = wsCase.getHandler();
		if (handler != null) {
			setHandler(handler, theCase);
		}

		// external case id could be null
		String externalCaseId = wsCase.getExternalCase_id();
		if (externalCaseId != null) {
			theCase.setExternalId(externalCaseId);
		}
		
		// set case code

		theCase.setCaseCode(code);
		
		String wsBody = wsCase.getBody();
		wsBody = (wsBody == null) ? "" : wsBody;
		theCase.setBody(wsBody);
		
		String wsSubject = wsCase.getBody();
		wsBody = (wsSubject == null) ? "" : wsSubject;
		theCase.setSubject(wsSubject);
	
		// time to store....
		theCase.store();
		
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Code = "+wsCase.getCode());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] extCase = "+wsCase.getExternalCase_id());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Body = "+wsCase.getBody());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Subject = "+wsCase.getSubject());

		CaseResult caseResult = new CaseResult();
		caseResult.setId(theCase.getUniqueId());
		caseResult.setOperation("success");   
		
		return caseResult;
	}
	
	
	public void updateUserInformation(User user, Owner owner) throws CreateException{
		
		//Update emails:
		String sEmail = owner.getEmail();
		if (sEmail != null) {
			try {
				getUserBusiness().updateUserMail(user, sEmail);
			}
			catch (RemoteException ex) {
				throw new IBORuntimeException(); 
			}
		}

		//Update phone:
		
		String sPhone = owner.getPhone();
		if(sPhone != null) {
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
		if(mobile != null){
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
			if(autocreateOwner){
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
		System.out.println("[CaseBusiness : craeteOrUpdateCase] updating case with id='"+id+"'");
		return getCaseHome().findCaseByUniqueId(id);
	}
	
	private Case createCase() throws CreateException {
		return  getCaseHome().create();
	}

	public void changeCaseStatus(Case theCase, CaseStatus newCaseStatus, User performer,String updateMessageSubject, String updateMessageBody) {
		changeCaseStatusDoNotSendUpdates(theCase, newCaseStatus.getStatus(), performer);
		setUserMessage(theCase, performer, updateMessageSubject, updateMessageBody);
	}
	
	private void setCaseStatus(Case theCase, CaseStatus caseStatus, User performer, String messageSubject, String messageBody) {
		theCase.setCaseStatus(caseStatus);
		setUserMessage(theCase, performer, messageSubject, messageBody);
	}
	
	private void setMetadata(Item[] metadata, Case theCase) { 
		for (int i = 0; i < metadata.length; i++) {
			Item item = metadata[i];
			if (item != null) {
				String key = item.getKey();
				String value = item.getValue();
				theCase.setMetaData(key, value);
			}
		}
	}

	private void setHandler(Handler handler, Case theCase) {
		String handlerPersonalId = handler.getSocialsecurity();
		if(handlerPersonalId!=null){
			try {
				User uHandler = getUserHome().findByPersonalID(handlerPersonalId);
				System.out.println("[CaseBusiness : craeteOrUpdateCase] handler = "+handlerPersonalId);
				theCase.setExternalHandler(uHandler);
			}
			catch (FinderException f) {
				System.out.println("[CaseBusiness : craeteOrUpdateCase] no handler");
				f.printStackTrace();
			}
		}
	}
	
	
	private void setUserMessage(Case theCase, User user, String subject, String body) {
		MessageValue messageValue = new MessageValue();
		messageValue.setSubject(subject);
		messageValue.setBody(body);
		messageValue.setReceiver(user);
		messageValue.setParentCase(theCase);
		MessageBusiness messageBusiness = getMessageBusiness();
		// message value needs at least receiver, subject, body
		// we are using default message type
		try {
			messageBusiness.createMessage(messageValue);
		}
		catch (IBOLookupException e) {
			throw new RuntimeException(e);
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
		if (userBusiness == null) {
			try {
				userBusiness = (UserBusiness)IBOLookup.getServiceInstance(getIWApplicationContext(),UserBusiness.class);
			}
			catch (IBOLookupException e) {
				throw new RuntimeException(e);
			}
		}
		return userBusiness;
	}
	
	private MessageBusiness getMessageBusiness() {
		try {
			
			return (MessageBusiness) IBOLookup.getServiceInstance(getIWApplicationContext(), MessageBusiness.class);
		}
		catch (IBOLookupException e) {
			throw new IBORuntimeException(e);
		}
	}
}