/**
 * UserInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server.userService;

public class UserInfo  implements java.io.Serializable {
    private com.idega.block.process.webservice.server.userService.AddressInfo address;

    private java.lang.String email;

    private java.lang.String error;

    private java.lang.String firstName;

    private java.lang.String gsm;

    private java.lang.String lastName;

    private java.lang.String middleName;

    private java.lang.String phone;

    private com.idega.block.process.webservice.server.userService.AddressInfo postalAddress;

    private java.lang.String socialsecurity;

    private boolean valid;

    public UserInfo() {
    }

    public UserInfo(
           com.idega.block.process.webservice.server.userService.AddressInfo address,
           java.lang.String email,
           java.lang.String error,
           java.lang.String firstName,
           java.lang.String gsm,
           java.lang.String lastName,
           java.lang.String middleName,
           java.lang.String phone,
           com.idega.block.process.webservice.server.userService.AddressInfo postalAddress,
           java.lang.String socialsecurity,
           boolean valid) {
           this.address = address;
           this.email = email;
           this.error = error;
           this.firstName = firstName;
           this.gsm = gsm;
           this.lastName = lastName;
           this.middleName = middleName;
           this.phone = phone;
           this.postalAddress = postalAddress;
           this.socialsecurity = socialsecurity;
           this.valid = valid;
    }


    /**
     * Gets the address value for this UserInfo.
     * 
     * @return address
     */
    public com.idega.block.process.webservice.server.userService.AddressInfo getAddress() {
        return address;
    }


    /**
     * Sets the address value for this UserInfo.
     * 
     * @param address
     */
    public void setAddress(com.idega.block.process.webservice.server.userService.AddressInfo address) {
        this.address = address;
    }


    /**
     * Gets the email value for this UserInfo.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return email;
    }


    /**
     * Sets the email value for this UserInfo.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the error value for this UserInfo.
     * 
     * @return error
     */
    public java.lang.String getError() {
        return error;
    }


    /**
     * Sets the error value for this UserInfo.
     * 
     * @param error
     */
    public void setError(java.lang.String error) {
        this.error = error;
    }


    /**
     * Gets the firstName value for this UserInfo.
     * 
     * @return firstName
     */
    public java.lang.String getFirstName() {
        return firstName;
    }


    /**
     * Sets the firstName value for this UserInfo.
     * 
     * @param firstName
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }


    /**
     * Gets the gsm value for this UserInfo.
     * 
     * @return gsm
     */
    public java.lang.String getGsm() {
        return gsm;
    }


    /**
     * Sets the gsm value for this UserInfo.
     * 
     * @param gsm
     */
    public void setGsm(java.lang.String gsm) {
        this.gsm = gsm;
    }


    /**
     * Gets the lastName value for this UserInfo.
     * 
     * @return lastName
     */
    public java.lang.String getLastName() {
        return lastName;
    }


    /**
     * Sets the lastName value for this UserInfo.
     * 
     * @param lastName
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }


    /**
     * Gets the middleName value for this UserInfo.
     * 
     * @return middleName
     */
    public java.lang.String getMiddleName() {
        return middleName;
    }


    /**
     * Sets the middleName value for this UserInfo.
     * 
     * @param middleName
     */
    public void setMiddleName(java.lang.String middleName) {
        this.middleName = middleName;
    }


    /**
     * Gets the phone value for this UserInfo.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return phone;
    }


    /**
     * Sets the phone value for this UserInfo.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the postalAddress value for this UserInfo.
     * 
     * @return postalAddress
     */
    public com.idega.block.process.webservice.server.userService.AddressInfo getPostalAddress() {
        return postalAddress;
    }


    /**
     * Sets the postalAddress value for this UserInfo.
     * 
     * @param postalAddress
     */
    public void setPostalAddress(com.idega.block.process.webservice.server.userService.AddressInfo postalAddress) {
        this.postalAddress = postalAddress;
    }


    /**
     * Gets the socialsecurity value for this UserInfo.
     * 
     * @return socialsecurity
     */
    public java.lang.String getSocialsecurity() {
        return socialsecurity;
    }


    /**
     * Sets the socialsecurity value for this UserInfo.
     * 
     * @param socialsecurity
     */
    public void setSocialsecurity(java.lang.String socialsecurity) {
        this.socialsecurity = socialsecurity;
    }


    /**
     * Gets the valid value for this UserInfo.
     * 
     * @return valid
     */
    public boolean isValid() {
        return valid;
    }


    /**
     * Sets the valid value for this UserInfo.
     * 
     * @param valid
     */
    public void setValid(boolean valid) {
        this.valid = valid;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof UserInfo)) return false;
        UserInfo other = (UserInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.error==null && other.getError()==null) || 
             (this.error!=null &&
              this.error.equals(other.getError()))) &&
            ((this.firstName==null && other.getFirstName()==null) || 
             (this.firstName!=null &&
              this.firstName.equals(other.getFirstName()))) &&
            ((this.gsm==null && other.getGsm()==null) || 
             (this.gsm!=null &&
              this.gsm.equals(other.getGsm()))) &&
            ((this.lastName==null && other.getLastName()==null) || 
             (this.lastName!=null &&
              this.lastName.equals(other.getLastName()))) &&
            ((this.middleName==null && other.getMiddleName()==null) || 
             (this.middleName!=null &&
              this.middleName.equals(other.getMiddleName()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.postalAddress==null && other.getPostalAddress()==null) || 
             (this.postalAddress!=null &&
              this.postalAddress.equals(other.getPostalAddress()))) &&
            ((this.socialsecurity==null && other.getSocialsecurity()==null) || 
             (this.socialsecurity!=null &&
              this.socialsecurity.equals(other.getSocialsecurity()))) &&
            this.valid == other.isValid();
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getError() != null) {
            _hashCode += getError().hashCode();
        }
        if (getFirstName() != null) {
            _hashCode += getFirstName().hashCode();
        }
        if (getGsm() != null) {
            _hashCode += getGsm().hashCode();
        }
        if (getLastName() != null) {
            _hashCode += getLastName().hashCode();
        }
        if (getMiddleName() != null) {
            _hashCode += getMiddleName().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getPostalAddress() != null) {
            _hashCode += getPostalAddress().hashCode();
        }
        if (getSocialsecurity() != null) {
            _hashCode += getSocialsecurity().hashCode();
        }
        _hashCode += (isValid() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(UserInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "UserInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "AddressInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("error");
        elemField.setXmlName(new javax.xml.namespace.QName("", "error"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("firstName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "firstName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gsm");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gsm"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lastName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lastName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("middleName");
        elemField.setXmlName(new javax.xml.namespace.QName("", "middleName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("phone");
        elemField.setXmlName(new javax.xml.namespace.QName("", "phone"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("postalAddress");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postalAddress"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "AddressInfo"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socialsecurity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "socialsecurity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("valid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "valid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
