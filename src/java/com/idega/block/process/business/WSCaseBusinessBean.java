package com.idega.block.process.business;

import java.rmi.RemoteException;
import java.util.Collection;
import java.util.Iterator;
import javax.ejb.CreateException;
import javax.ejb.EJBException;
import javax.ejb.FinderException;
import com.idega.block.process.data.Case;
import com.idega.block.process.data.CaseCode;
import com.idega.block.process.data.CaseStatus;
import com.idega.block.process.message.business.MessageBusiness;
import com.idega.block.process.message.business.MessageValue;
import com.idega.block.process.webservice.server.CaseEntry;
import com.idega.block.process.webservice.server.Handler;
import com.idega.block.process.webservice.server.Item;
import com.idega.block.process.webservice.server.Owner;
import com.idega.block.process.wsclient.WSCaseConstants;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.core.contact.data.Email;
import com.idega.core.contact.data.EmailHome;
import com.idega.data.IDOAddRelationshipException;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;
import com.idega.idegaweb.IWMainApplication;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.IWTimestamp;

public class WSCaseBusinessBean extends CaseBusinessBean implements
		WSCaseBusiness {

	
	private boolean autocreateOwner=false;
	
	public Case createOrUpdateCase(CaseEntry wsCase) throws Exception {
		
		//boolean isUpdate=false;
		
		String status = wsCase.getStatus();
		String caseCode = wsCase.getCode();
		
		CaseCode code = getCaseCodeAndInstallIfNotExists(caseCode);
		Owner owner = wsCase.getOwner();
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
		String externalId = wsCase.getExternalCase_id();
		Case theCase = null;
		String msgUpdateText = "Case Update";
		if (id == null || "-1".equals(id)) {
			try{
				theCase = getCaseHome().findCaseByExternalId(externalId);
				log("[CaseBusiness : craeteOrUpdateCase] updating");
				changeCaseStatus(theCase, newCaseStatus, null,msgUpdateText);
				//isUpdate=true;
			}
			catch(FinderException e){

				log("[CaseBusiness : craeteOrUpdateCase] creating");
				theCase = getCaseHome().create();
			}
			theCase.setCreated(new IWTimestamp(wsCase.getCreated()).getTimestamp());
			theCase.setCaseStatus(newCaseStatus);
		} else {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] updating case with id='"+id+"'");
			//isUpdate=true;
			theCase = getCaseHome().findCaseByUniqueId(id);
			changeCaseStatus(theCase, newCaseStatus, null,msgUpdateText);
		}
		theCase.setCaseCode(code);
		theCase.setExternalId(wsCase.getExternalCase_id());
		theCase.setBody(wsCase.getBody());
		theCase.setSubject(wsCase.getSubject());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Code = "+wsCase.getCode());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] extCase = "+wsCase.getExternalCase_id());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Body = "+wsCase.getBody());
		System.out.println("[CaseBusiness : craeteOrUpdateCase] Subject = "+wsCase.getSubject());

		try {
			User uOwner = getUserHome().findByPersonalID(wsCase.getOwner().getSocialsecurity());
			System.out.println("[CaseBusiness : craeteOrUpdateCase] owner = "+uOwner.getPersonalID());
			theCase.setOwner(uOwner);
			
			updateUserInformation(uOwner,owner);
			
		} catch (FinderException f) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] no owner");
			if(autocreateOwner){
				//getUserBusiness().createUserByPersonalIDIfDoesNotExist()
				
				User uOwner = getUserHome().create();
				uOwner.setFullName(owner.getName());
				uOwner.setPersonalID(owner.getSocialsecurity());
				
				uOwner.store();
				
			}
			else{
				f.printStackTrace();
			}
		}
		try {
			
			Item[] metaItems = wsCase.getMetadata();
			//Map caseMeta = theCase.getMetaDataAttributes();
			theCase.store();
			
			for (int i = 0; i < metaItems.length; i++) {
				Item item = metaItems[i];
				String key = item.getKey();
				String value = item.getValue();
				//caseMeta.put(key,value);
				theCase.setMetaData(key,value);
				//theCase.updateMetaData();
			}
			
			Handler handler = wsCase.getHandler();
			if(handler!=null){
				String handlerPersonalId = handler.getSocialsecurity();
				if(handlerPersonalId!=null){
					User uHandler = getUserHome().findByPersonalID(handlerPersonalId);
					System.out.println("[CaseBusiness : craeteOrUpdateCase] handler = "+handlerPersonalId);
					theCase.setExternalHandler(uHandler);
				}
			}
		} catch (FinderException f) {
			System.out.println("[CaseBusiness : craeteOrUpdateCase] no handler");
			f.printStackTrace();
		}
		theCase.store();
		
		return theCase;
	}
	
	
	public void updateUserInformation(User user,Owner owner){
		//Update emails:
		String sEmail = owner.getEmail();
		if(sEmail != null && sEmail.equals("")){
			Collection emails = user.getEmails();
			boolean emailFound=false;
			for (Iterator iter = emails.iterator(); iter.hasNext();) {
				Email email = (Email) iter.next();
				if(!email.getEmailAddress().equals(sEmail)){
					email.setEmailAddress(sEmail);
					email.store();
				}
				emailFound=true;
			}
			if(!emailFound){
				try {
					Email newEmail = getEmailHome().create();
					newEmail.setEmailAddress(sEmail);
					try {
						user.addEmail(newEmail);
					}
					catch (IDOAddRelationshipException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				catch (CreateException e) {
					e.printStackTrace();
				}
			}
		}
		//Update phone:
		
		String sPhone = owner.getPhone();
		if(sPhone != null && sPhone.equals("")){
			try {
				getUserBusiness().updateUserHomePhone(user,sPhone);
			}
			catch (EJBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		String mobile = owner.getGsm();
		if(mobile != null && mobile.equals("")){
			try {
				getUserBusiness().updateUserMobilePhone(user,mobile);
			}
			catch (EJBException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}
	
	/**
	 * <p>
	 * TODO tryggvil describe method getEmailHome
	 * </p>
	 * @return
	 */
	private EmailHome getEmailHome() {
		try {
			return (EmailHome) IDOLookup.getHome(Email.class);
		}
		catch (IDOLookupException e) {
			throw new RuntimeException(e);
		}
	}


	public void changeCaseStatus(Case theCase, CaseStatus newCaseStatus, User performer,String updateMessage) {
		changeCaseStatus(theCase, newCaseStatus.getStatus(), performer);	
		if(updateMessage!=null){
			try {
				MessageBusiness msgBusiness = (MessageBusiness) getServiceInstance(MessageBusiness.class);
				MessageValue mValue = new MessageValue();
				mValue.setParentCase(theCase);
				mValue.setReceiver(theCase.getOwner());
				mValue.setSubject(updateMessage);
				mValue.setBody(updateMessage);
				mValue.setMessageType("SYMEDAN");
				msgBusiness.createMessage(mValue);
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
		
	}
	
	protected UserBusiness getUserBusiness(){
		try {
			return (UserBusiness)IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(),UserBusiness.class);
		}
		catch (IBOLookupException e) {
			throw new RuntimeException(e);
		}
	}
}
