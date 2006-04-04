/*
 * $Id: AddressInfo.java,v 1.1 2006/04/04 18:04:16 thomas Exp $
 * Created on Apr 3, 2006
 *
 * Copyright (C) 2006 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.block.process.webservice;


/**
 * 
 *  Last modified: $Date: 2006/04/04 18:04:16 $ by $Author: thomas $
 * 
 * @author <a href="mailto:thomas@idega.com">thomas</a>
 * @version $Revision: 1.1 $
 */
public class AddressInfo {
	
    private String streetName;
    
    private String streetNumber;

    private String city;
    
    private String postalcode;
    
    private String country;

	
	/**
	 * @return Returns the city.
	 */
	public String getCity() {
		return city;
	}

	
	/**
	 * @param city The city to set.
	 */
	public void setCity(String city) {
		this.city = city;
	}

	
	/**
	 * @return Returns the country.
	 */
	public String getCountry() {
		return country;
	}

	
	/**
	 * @param country The country to set.
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	
	/**
	 * @return Returns the postalcode.
	 */
	public String getPostalcode() {
		return postalcode;
	}

	
	/**
	 * @param postalcode The postalcode to set.
	 */
	public void setPostalcode(String postalcode) {
		this.postalcode = postalcode;
	}

	
	/**
	 * @return Returns the streetName.
	 */
	public String getStreetName() {
		return streetName;
	}

	
	/**
	 * @param streetName The streetName to set.
	 */
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	
	/**
	 * @return Returns the streetNumber.
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	
	/**
	 * @param streetNumber The streetNumber to set.
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}
}
