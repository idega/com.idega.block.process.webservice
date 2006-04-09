/**
 * Case_response.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.wsclient;

public class Case_response  implements java.io.Serializable {
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -2080383232749364927L;
		private java.lang.String external_case_id;

    public Case_response() {
    }

    public Case_response(
           java.lang.String external_case_id) {
           this.external_case_id = external_case_id;
    }


    /**
     * Gets the external_case_id value for this Case_response.
     * 
     * @return external_case_id
     */
    public java.lang.String getExternal_case_id() {
        return this.external_case_id;
    }


    /**
     * Sets the external_case_id value for this Case_response.
     * 
     * @param external_case_id
     */
    public void setExternal_case_id(java.lang.String external_case_id) {
        this.external_case_id = external_case_id;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Case_response)) {
					return false;
				}
        Case_response other = (Case_response) obj;
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
            ((this.external_case_id==null && other.getExternal_case_id()==null) || 
             (this.external_case_id!=null &&
              this.external_case_id.equals(other.getExternal_case_id())));
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
        if (getExternal_case_id() != null) {
            _hashCode += getExternal_case_id().hashCode();
        }
        this.__hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Case_response.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Case.case_response", "case_response"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("external_case_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "external_case_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return Case_response.typeDesc;
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
            _javaType, _xmlType, Case_response.typeDesc);
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
            _javaType, _xmlType, Case_response.typeDesc);
    }

}
