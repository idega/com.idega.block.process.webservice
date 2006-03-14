/**
 * CaseServiceSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

import com.idega.block.process.business.WSCaseBusiness;
import com.idega.block.process.business.WSCaseBusinessBean;
import com.idega.block.process.data.Case;
import com.idega.util.IWTimestamp;

public class CaseServiceSoapBindingImpl implements com.idega.block.process.webservice.server.CaseService{
    public com.idega.block.process.webservice.server.CaseResult createOrUpdateCase(com.idega.block.process.webservice.server.CaseEntry caseEntry) throws java.rmi.RemoteException {
    		System.out.println(IWTimestamp.RightNow().getDateString("dd-MM-yyyy hh:mm:ss") + " : [NewCaseBindingImpl (WebService)] method is called");
		CaseResult res = new CaseResult();
		//WSCaseBusiness bus1 = (WSCaseBusiness) IBOLookup.getServiceInstance(IWMainApplication.getDefaultIWApplicationContext(), WSCaseBusiness.class);
		WSCaseBusiness bus1 = new WSCaseBusinessBean();
		try {
			Case updatedCase =  bus1.createOrUpdateCase(caseEntry);
			res.setId(updatedCase.getUniqueId());
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			res.setId("-1");
			res.setOperation("create/update failed");
		}
		
		/*try {
			CaseBusiness business = bus1.getCaseBusiness(caseEntry.getCode());
			//business.createOrUpdateCase(part_request);
			if (caseEntry.getId() != null && !"".equals(caseEntry.getId())) {
				res.setId(caseEntry.getId());
				res.setOperation("updated");
			} else {
				res.setId("1");
				res.setOperation("inserted");				
			}
			Owner owner = caseEntry.getOwner();
			updateOwnerInfo(owner);
		}
		catch (FinderException e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		catch (RemoteException e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		catch (Exception e) {
			e.printStackTrace();
			res.setId("-1");
			res.setOperation(e.getMessage());
		}
		*/
		
		return res;
    }

	/**
	 * <p>
	 * TODO tryggvil describe method updateOwnerInfo
	 * </p>
	 * @param owner
	 */
	/*private void updateOwnerInfo(Owner owner) {
		
		
		String personalId = owner.getSocialsecurity();
		
		UserHome uHome = getUserHome();
		User user;
		try {
			user = uHome.findByPersonalID(personalId);
			//check if user has email:
			
			String email = owner.getEmail();
			if(email!=null && !email.trim().equals("")){
				boolean hasEmail = false;
				Collection emails = user.getEmails();
				for (Iterator iter = emails.iterator(); iter.hasNext();) {
					Email mail = (Email) iter.next();
					hasEmail=true;
				}
				
				if(!hasEmail){
					EmailHome eHome = getEmailHome();
					Email newEmail = eHome.create();
					newEmail.setEmailAddress(email);
					newEmail.store();
					
					user.addEmail(newEmail);
				}
			}
			
			//check user telephone:
			
			
			//check user mobile:
		}
		catch (FinderException e) {
			throw new RuntimeException("User with socialsecurity='"+personalId+"' not found");
		}
		catch (CreateException e) {
			e.printStackTrace();
			throw new RuntimeException("Error updating info for user with socialsecurity='"+personalId+"'");
		}
		catch (IDOAddRelationshipException e) {
			e.printStackTrace();
			throw new RuntimeException("Error updating info for user with socialsecurity='"+personalId+"'");
		}
	}*/

	/**
	 * <p>
	 * TODO tryggvil describe method getEmailHome
	 * </p>
	 * @return
	 */
	/*private EmailHome getEmailHome() {
		// TODO Auto-generated method stub
		return null;
	}*/

	/**
	 * <p>
	 * TODO tryggvil describe method getUserHome
	 * </p>
	 * @return
	 */
	/*private UserHome getUserHome() {
		// TODO Auto-generated method stub
		return null;
	}*/
}