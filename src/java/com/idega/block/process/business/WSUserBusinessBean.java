/*
 * $Id: WSUserBusinessBean.java,v 1.1 2006/04/04 18:01:48 thomas Exp $
 * Created on Apr 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.business;

import java.rmi.RemoteException;
import javax.ejb.FinderException;
import com.idega.block.process.webservice.server.userService.AddressInfo;
import com.idega.block.process.webservice.server.userService.UserInfo;
import com.idega.business.IBOLookup;
import com.idega.business.IBOLookupException;
import com.idega.business.IBORuntimeException;
import com.idega.business.IBOServiceBean;
import com.idega.core.contact.data.Email;
import com.idega.core.contact.data.Phone;
import com.idega.core.contact.data.PhoneType;
import com.idega.core.location.data.Address;
import com.idega.core.location.data.Country;
import com.idega.core.location.data.PostalCode;
import com.idega.user.business.UserBusiness;
import com.idega.user.data.User;
import com.idega.util.StringHandler;


/**
 * 
 *  Last modified: $Date: 2006/04/04 18:01:48 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class WSUserBusinessBean extends IBOServiceBean  implements WSUserBusiness{
	
	private UserBusiness userBusiness = null;
	
	public UserInfo getUserInfo(String personalId) {
		UserInfo userInfo = new UserInfo();
		User user = null;
		try {
			try {
				user = getUserBusiness().getUser(personalId);
			}
			catch (FinderException ex) {
				userInfo.setValid(false);
				return userInfo;
			}
			userInfo.setSocialsecurity(personalId);
			setNames(user, userInfo);
			setAddress(user, userInfo);
			setEmail(user, userInfo);
			setPhone(user, userInfo);
			userInfo.setValid(true);
			return userInfo;
		}
		catch (RemoteException ex) {
			userInfo.setValid(false);
			userInfo.setError("error");
			return userInfo;
		}
	}
	
	private void setNames(User user, UserInfo userInfo) {
		String firstName = user.getFirstName();
		userInfo.setFirstName(firstName);
		
		String middleName = user.getMiddleName();
		userInfo.setMiddleName(middleName);
		
		String lastName = user.getLastName();
		userInfo.setLastName(lastName);
	}
	
	private void setAddress(User user, UserInfo userInfo) throws RemoteException {
		Address mainAddress = getUserBusiness().getUsersMainAddress(user);
		Address postalAddress = getUserBusiness().getUsersCoAddress(user);
		if (postalAddress == null) {
			// does the co address exist?
			postalAddress = mainAddress;
		}
		else {
			// see & compare:  public Address getPostalAddress(User user) 
			// se.idega.idegaweb.commune.business.CommuneUserBusiness
			
			// does the co address has a street name?
			String street = postalAddress.getStreetAddress();
			if (! StringHandler.isNotEmpty(street)) {
				postalAddress = mainAddress;
			}
		}
		AddressInfo mainAddressInfo = getAdressInfo(mainAddress);
		userInfo.setAddress(mainAddressInfo);
		AddressInfo postalAddressInfo = getAdressInfo(postalAddress);
		userInfo.setPostalAddress(postalAddressInfo);
	}
		
	private AddressInfo getAdressInfo(Address address) {
		AddressInfo addressInfo = new AddressInfo();
		if (address == null) {
			return null;
		}
		
		String streetName =address.getStreetName();
		addressInfo.setStreetName(streetName);
		
		String streetNumber = address.getStreetNumber();
		addressInfo.setStreetNumber(streetNumber);
		
		PostalCode postalCode = address.getPostalCode();
		if (postalCode != null) {
			String postalCodeString = postalCode.getPostalCode();
			addressInfo.setPostalcode(postalCodeString);
		}
		
		String city = address.getCity();
		addressInfo.setCity(city);
		
		Country country = address.getCountry();
		if (country != null) {
			String countryName = country.getName();
			addressInfo.setCountry(countryName);
		}
		
		return addressInfo;

	}
	
	private void setEmail(User user, UserInfo userInfo) throws RemoteException {
		Email userEmail = getUserBusiness().getUserMail(user);
		if (userEmail == null) {
			return;
		}
		String email = userEmail.getEmailAddress();
		userInfo.setEmail(email);
	}
	
	private void setPhone(User user, UserInfo userInfo) throws RemoteException {
		Phone[] phones = getUserBusiness().getUserPhones(user);
		for (int a = 0; a < phones.length; a++) {
			Phone phone = phones[a];
			if (phone.getPhoneTypeId() == PhoneType.HOME_PHONE_ID) {
				String phoneNumber = phone.getNumber();
				userInfo.setPhone(phoneNumber);
			}
			else if (phone.getPhoneTypeId() == PhoneType.MOBILE_PHONE_ID) {
				String numberGSM = phone.getNumber();
				userInfo.setGsm(numberGSM);
			}
		}
	}
		

	
	private UserBusiness getUserBusiness() {
		if (userBusiness == null) {
			try {
				userBusiness = (UserBusiness) IBOLookup.getServiceInstance(getIWApplicationContext(), UserBusiness.class);
			}
			catch (IBOLookupException e) {
				throw new IBORuntimeException(e);
			}
		}
		return userBusiness;
	}
	
}
