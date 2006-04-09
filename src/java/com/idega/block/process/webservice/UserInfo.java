/*
 * $Id: UserInfo.java,v 1.2 2006/04/09 11:52:52 laddi Exp $
 * Created on Mar 31, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.webservice;


public class UserInfo {
	
	
   private String socialsecurity;
	
    private String firstName;
    
    private String middleName;
    
    private String lastName;

    private String email;

    private String gsm;

    private String phone;
    
    private AddressInfo address;
    
    private AddressInfo postalAddress;
    
    private String error;
    
    private boolean valid = false;
	
	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return this.email;
	}

	
	/**
	 * @param email The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return Returns the firstName.
	 */
	public String getFirstName() {
		return this.firstName;
	}

	
	/**
	 * @param firstName The firstName to set.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * @return Returns the gsm.
	 */
	public String getGsm() {
		return this.gsm;
	}

	
	/**
	 * @param gsm The gsm to set.
	 */
	public void setGsm(String gsm) {
		this.gsm = gsm;
	}

	
	/**
	 * @return Returns the lastName.
	 */
	public String getLastName() {
		return this.lastName;
	}

	
	/**
	 * @param lastName The lastName to set.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/**
	 * @return Returns the middleName.
	 */
	public String getMiddleName() {
		return this.middleName;
	}

	
	/**
	 * @param middleName The middleName to set.
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	
	/**
	 * @return Returns the phone.
	 */
	public String getPhone() {
		return this.phone;
	}

	
	/**
	 * @param phone The phone to set.
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	/**
	 * @return Returns the socialsecurity.
	 */
	public String getSocialsecurity() {
		return this.socialsecurity;
	}

	
	/**
	 * @param socialsecurity The socialsecurity to set.
	 */
	public void setSocialsecurity(String socialsecurity) {
		this.socialsecurity = socialsecurity;
	}


	
	/**
	 * @return Returns the error.
	 */
	public String getError() {
		return this.error;
	}


	
	/**
	 * @param error The error to set.
	 */
	public void setError(String error) {
		this.error = error;
	}


	
	/**
	 * @return Returns the valid.
	 */
	public boolean isValid() {
		return this.valid;
	}


	
	/**
	 * @param valid The valid to set.
	 */
	public void setValid(boolean valid) {
		this.valid = valid;
	}


	
	/**
	 * @return Returns the address.
	 */
	public AddressInfo getAddress() {
		return this.address;
	}


	
	/**
	 * @param address The address to set.
	 */
	public void setAddress(AddressInfo address) {
		this.address = address;
	}


	
	/**
	 * @return Returns the postalAddress.
	 */
	public AddressInfo getPostalAddress() {
		return this.postalAddress;
	}


	
	/**
	 * @param postalAddress The postalAddress to set.
	 */
	public void setPostalAddress(AddressInfo postalAddress) {
		this.postalAddress = postalAddress;
	}
	
}
