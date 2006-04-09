/**
 * Owner.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

public class Owner  implements java.io.Serializable {
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 6357276264225978022L;

		private java.lang.String address;

    private java.lang.String case_role;

    private java.lang.String city;

    private com.idega.block.process.webservice.server.Contact contact;

    private java.lang.String department;

    private java.lang.String email;

    private java.lang.String gsm;

    private java.lang.String name;

    private java.lang.String phone;

    private java.lang.String postalcode;

    private java.lang.String socialsecurity;

    private java.lang.String title;

    public Owner() {
    }

    public Owner(
           java.lang.String address,
           java.lang.String case_role,
           java.lang.String city,
           com.idega.block.process.webservice.server.Contact contact,
           java.lang.String department,
           java.lang.String email,
           java.lang.String gsm,
           java.lang.String name,
           java.lang.String phone,
           java.lang.String postalcode,
           java.lang.String socialsecurity,
           java.lang.String title) {
           this.address = address;
           this.case_role = case_role;
           this.city = city;
           this.contact = contact;
           this.department = department;
           this.email = email;
           this.gsm = gsm;
           this.name = name;
           this.phone = phone;
           this.postalcode = postalcode;
           this.socialsecurity = socialsecurity;
           this.title = title;
    }


    /**
     * Gets the address value for this Owner.
     * 
     * @return address
     */
    public java.lang.String getAddress() {
        return this.address;
    }


    /**
     * Sets the address value for this Owner.
     * 
     * @param address
     */
    public void setAddress(java.lang.String address) {
        this.address = address;
    }


    /**
     * Gets the case_role value for this Owner.
     * 
     * @return case_role
     */
    public java.lang.String getCase_role() {
        return this.case_role;
    }


    /**
     * Sets the case_role value for this Owner.
     * 
     * @param case_role
     */
    public void setCase_role(java.lang.String case_role) {
        this.case_role = case_role;
    }


    /**
     * Gets the city value for this Owner.
     * 
     * @return city
     */
    public java.lang.String getCity() {
        return this.city;
    }


    /**
     * Sets the city value for this Owner.
     * 
     * @param city
     */
    public void setCity(java.lang.String city) {
        this.city = city;
    }


    /**
     * Gets the contact value for this Owner.
     * 
     * @return contact
     */
    public com.idega.block.process.webservice.server.Contact getContact() {
        return this.contact;
    }


    /**
     * Sets the contact value for this Owner.
     * 
     * @param contact
     */
    public void setContact(com.idega.block.process.webservice.server.Contact contact) {
        this.contact = contact;
    }


    /**
     * Gets the department value for this Owner.
     * 
     * @return department
     */
    public java.lang.String getDepartment() {
        return this.department;
    }


    /**
     * Sets the department value for this Owner.
     * 
     * @param department
     */
    public void setDepartment(java.lang.String department) {
        this.department = department;
    }


    /**
     * Gets the email value for this Owner.
     * 
     * @return email
     */
    public java.lang.String getEmail() {
        return this.email;
    }


    /**
     * Sets the email value for this Owner.
     * 
     * @param email
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }


    /**
     * Gets the gsm value for this Owner.
     * 
     * @return gsm
     */
    public java.lang.String getGsm() {
        return this.gsm;
    }


    /**
     * Sets the gsm value for this Owner.
     * 
     * @param gsm
     */
    public void setGsm(java.lang.String gsm) {
        this.gsm = gsm;
    }


    /**
     * Gets the name value for this Owner.
     * 
     * @return name
     */
    public java.lang.String getName() {
        return this.name;
    }


    /**
     * Sets the name value for this Owner.
     * 
     * @param name
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }


    /**
     * Gets the phone value for this Owner.
     * 
     * @return phone
     */
    public java.lang.String getPhone() {
        return this.phone;
    }


    /**
     * Sets the phone value for this Owner.
     * 
     * @param phone
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }


    /**
     * Gets the postalcode value for this Owner.
     * 
     * @return postalcode
     */
    public java.lang.String getPostalcode() {
        return this.postalcode;
    }


    /**
     * Sets the postalcode value for this Owner.
     * 
     * @param postalcode
     */
    public void setPostalcode(java.lang.String postalcode) {
        this.postalcode = postalcode;
    }


    /**
     * Gets the socialsecurity value for this Owner.
     * 
     * @return socialsecurity
     */
    public java.lang.String getSocialsecurity() {
        return this.socialsecurity;
    }


    /**
     * Sets the socialsecurity value for this Owner.
     * 
     * @param socialsecurity
     */
    public void setSocialsecurity(java.lang.String socialsecurity) {
        this.socialsecurity = socialsecurity;
    }


    /**
     * Gets the title value for this Owner.
     * 
     * @return title
     */
    public java.lang.String getTitle() {
        return this.title;
    }


    /**
     * Sets the title value for this Owner.
     * 
     * @param title
     */
    public void setTitle(java.lang.String title) {
        this.title = title;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Owner)) {
					return false;
				}
        Owner other = (Owner) obj;
        if (obj == null) {
					return false;
				}
        if (this == obj) {
					return true;
				}
        if (this.__equalsCalc != null) {
            return (this.__equalsCalc == obj);
        }
        this.__equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.address==null && other.getAddress()==null) || 
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            ((this.case_role==null && other.getCase_role()==null) || 
             (this.case_role!=null &&
              this.case_role.equals(other.getCase_role()))) &&
            ((this.city==null && other.getCity()==null) || 
             (this.city!=null &&
              this.city.equals(other.getCity()))) &&
            ((this.contact==null && other.getContact()==null) || 
             (this.contact!=null &&
              this.contact.equals(other.getContact()))) &&
            ((this.department==null && other.getDepartment()==null) || 
             (this.department!=null &&
              this.department.equals(other.getDepartment()))) &&
            ((this.email==null && other.getEmail()==null) || 
             (this.email!=null &&
              this.email.equals(other.getEmail()))) &&
            ((this.gsm==null && other.getGsm()==null) || 
             (this.gsm!=null &&
              this.gsm.equals(other.getGsm()))) &&
            ((this.name==null && other.getName()==null) || 
             (this.name!=null &&
              this.name.equals(other.getName()))) &&
            ((this.phone==null && other.getPhone()==null) || 
             (this.phone!=null &&
              this.phone.equals(other.getPhone()))) &&
            ((this.postalcode==null && other.getPostalcode()==null) || 
             (this.postalcode!=null &&
              this.postalcode.equals(other.getPostalcode()))) &&
            ((this.socialsecurity==null && other.getSocialsecurity()==null) || 
             (this.socialsecurity!=null &&
              this.socialsecurity.equals(other.getSocialsecurity()))) &&
            ((this.title==null && other.getTitle()==null) || 
             (this.title!=null &&
              this.title.equals(other.getTitle())));
        this.__equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (this.__hashCodeCalc) {
            return 0;
        }
        this.__hashCodeCalc = true;
        int _hashCode = 1;
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        if (getCase_role() != null) {
            _hashCode += getCase_role().hashCode();
        }
        if (getCity() != null) {
            _hashCode += getCity().hashCode();
        }
        if (getContact() != null) {
            _hashCode += getContact().hashCode();
        }
        if (getDepartment() != null) {
            _hashCode += getDepartment().hashCode();
        }
        if (getEmail() != null) {
            _hashCode += getEmail().hashCode();
        }
        if (getGsm() != null) {
            _hashCode += getGsm().hashCode();
        }
        if (getName() != null) {
            _hashCode += getName().hashCode();
        }
        if (getPhone() != null) {
            _hashCode += getPhone().hashCode();
        }
        if (getPostalcode() != null) {
            _hashCode += getPostalcode().hashCode();
        }
        if (getSocialsecurity() != null) {
            _hashCode += getSocialsecurity().hashCode();
        }
        if (getTitle() != null) {
            _hashCode += getTitle().hashCode();
        }
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Owner.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Owner"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("case_role");
        elemField.setXmlName(new javax.xml.namespace.QName("", "case_role"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("city");
        elemField.setXmlName(new javax.xml.namespace.QName("", "city"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("contact");
        elemField.setXmlName(new javax.xml.namespace.QName("", "contact"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Contact"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("department");
        elemField.setXmlName(new javax.xml.namespace.QName("", "department"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("email");
        elemField.setXmlName(new javax.xml.namespace.QName("", "email"));
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
        elemField.setFieldName("name");
        elemField.setXmlName(new javax.xml.namespace.QName("", "name"));
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
        elemField.setFieldName("postalcode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "postalcode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("socialsecurity");
        elemField.setXmlName(new javax.xml.namespace.QName("", "socialsecurity"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("title");
        elemField.setXmlName(new javax.xml.namespace.QName("", "title"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return Owner.typeDesc;
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
            _javaType, _xmlType, Owner.typeDesc);
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
            _javaType, _xmlType, Owner.typeDesc);
    }

}
