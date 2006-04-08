/**
 * Case_request.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.wsclient;

public class Case_request  implements java.io.Serializable {
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1993035591025373056L;

		private java.lang.String case_id;

    private java.lang.String external_case_id;

    private int sf_id;

    private java.lang.String created;

    private java.lang.String code;

    private java.lang.String modified;

    private java.lang.String status;

    private java.lang.String subject;

    private java.lang.String body;

    private com.idega.block.process.wsclient.Case_requestOwner owner;

    private com.idega.block.process.wsclient.Case_requestHandler handler;

    private com.idega.block.process.wsclient.Case_requestItem[] metadata;

    public Case_request() {
    }

    public Case_request(
           java.lang.String case_id,
           java.lang.String external_case_id,
           int sf_id,
           java.lang.String created,
           java.lang.String code,
           java.lang.String modified,
           java.lang.String status,
           java.lang.String subject,
           java.lang.String body,
           com.idega.block.process.wsclient.Case_requestOwner owner,
           com.idega.block.process.wsclient.Case_requestHandler handler,
           com.idega.block.process.wsclient.Case_requestItem[] metadata) {
           this.case_id = case_id;
           this.external_case_id = external_case_id;
           this.sf_id = sf_id;
           this.created = created;
           this.code = code;
           this.modified = modified;
           this.status = status;
           this.subject = subject;
           this.body = body;
           this.owner = owner;
           this.handler = handler;
           this.metadata = metadata;
    }


    /**
     * Gets the case_id value for this Case_request.
     * 
     * @return case_id
     */
    public java.lang.String getCase_id() {
        return case_id;
    }


    /**
     * Sets the case_id value for this Case_request.
     * 
     * @param case_id
     */
    public void setCase_id(java.lang.String case_id) {
        this.case_id = case_id;
    }


    /**
     * Gets the external_case_id value for this Case_request.
     * 
     * @return external_case_id
     */
    public java.lang.String getExternal_case_id() {
        return external_case_id;
    }


    /**
     * Sets the external_case_id value for this Case_request.
     * 
     * @param external_case_id
     */
    public void setExternal_case_id(java.lang.String external_case_id) {
        this.external_case_id = external_case_id;
    }


    /**
     * Gets the sf_id value for this Case_request.
     * 
     * @return sf_id
     */
    public int getSf_id() {
        return sf_id;
    }


    /**
     * Sets the sf_id value for this Case_request.
     * 
     * @param sf_id
     */
    public void setSf_id(int sf_id) {
        this.sf_id = sf_id;
    }


    /**
     * Gets the created value for this Case_request.
     * 
     * @return created
     */
    public java.lang.String getCreated() {
        return created;
    }


    /**
     * Sets the created value for this Case_request.
     * 
     * @param created
     */
    public void setCreated(java.lang.String created) {
        this.created = created;
    }


    /**
     * Gets the code value for this Case_request.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this Case_request.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the modified value for this Case_request.
     * 
     * @return modified
     */
    public java.lang.String getModified() {
        return modified;
    }


    /**
     * Sets the modified value for this Case_request.
     * 
     * @param modified
     */
    public void setModified(java.lang.String modified) {
        this.modified = modified;
    }


    /**
     * Gets the status value for this Case_request.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this Case_request.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the subject value for this Case_request.
     * 
     * @return subject
     */
    public java.lang.String getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this Case_request.
     * 
     * @param subject
     */
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }


    /**
     * Gets the body value for this Case_request.
     * 
     * @return body
     */
    public java.lang.String getBody() {
        return body;
    }


    /**
     * Sets the body value for this Case_request.
     * 
     * @param body
     */
    public void setBody(java.lang.String body) {
        this.body = body;
    }


    /**
     * Gets the owner value for this Case_request.
     * 
     * @return owner
     */
    public com.idega.block.process.wsclient.Case_requestOwner getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this Case_request.
     * 
     * @param owner
     */
    public void setOwner(com.idega.block.process.wsclient.Case_requestOwner owner) {
        this.owner = owner;
    }


    /**
     * Gets the handler value for this Case_request.
     * 
     * @return handler
     */
    public com.idega.block.process.wsclient.Case_requestHandler getHandler() {
        return handler;
    }


    /**
     * Sets the handler value for this Case_request.
     * 
     * @param handler
     */
    public void setHandler(com.idega.block.process.wsclient.Case_requestHandler handler) {
        this.handler = handler;
    }


    /**
     * Gets the metadata value for this Case_request.
     * 
     * @return metadata
     */
    public com.idega.block.process.wsclient.Case_requestItem[] getMetadata() {
        return metadata;
    }


    /**
     * Sets the metadata value for this Case_request.
     * 
     * @param metadata
     */
    public void setMetadata(com.idega.block.process.wsclient.Case_requestItem[] metadata) {
        this.metadata = metadata;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof Case_request)) {
					return false;
				}
        Case_request other = (Case_request) obj;
        if (obj == null) {
					return false;
				}
        if (this == obj) {
					return true;
				}
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((case_id==null && other.getCase_id()==null) || 
             (case_id!=null &&
              case_id.equals(other.getCase_id()))) &&
            ((external_case_id==null && other.getExternal_case_id()==null) || 
             (external_case_id!=null &&
              external_case_id.equals(other.getExternal_case_id()))) &&
            sf_id == other.getSf_id() &&
            ((created==null && other.getCreated()==null) || 
             (created!=null &&
              created.equals(other.getCreated()))) &&
            ((code==null && other.getCode()==null) || 
             (code!=null &&
              code.equals(other.getCode()))) &&
            ((modified==null && other.getModified()==null) || 
             (modified!=null &&
              modified.equals(other.getModified()))) &&
            ((status==null && other.getStatus()==null) || 
             (status!=null &&
              status.equals(other.getStatus()))) &&
            ((subject==null && other.getSubject()==null) || 
             (subject!=null &&
              subject.equals(other.getSubject()))) &&
            ((body==null && other.getBody()==null) || 
             (body!=null &&
              body.equals(other.getBody()))) &&
            ((owner==null && other.getOwner()==null) || 
             (owner!=null &&
              owner.equals(other.getOwner()))) &&
            ((handler==null && other.getHandler()==null) || 
             (handler!=null &&
              handler.equals(other.getHandler()))) &&
            ((metadata==null && other.getMetadata()==null) || 
             (metadata!=null &&
              java.util.Arrays.equals(metadata, other.getMetadata())));
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
        if (getCase_id() != null) {
            _hashCode += getCase_id().hashCode();
        }
        if (getExternal_case_id() != null) {
            _hashCode += getExternal_case_id().hashCode();
        }
        _hashCode += getSf_id();
        if (getCreated() != null) {
            _hashCode += getCreated().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getModified() != null) {
            _hashCode += getModified().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getHandler() != null) {
            _hashCode += getHandler().hashCode();
        }
        if (getMetadata() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getMetadata());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getMetadata(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(Case_request.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://Case.case", "case_request"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("case_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "case_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("external_case_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "external_case_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sf_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "sf_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("created");
        elemField.setXmlName(new javax.xml.namespace.QName("", "created"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modified");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Case.case", "case_requestOwner"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("handler");
        elemField.setXmlName(new javax.xml.namespace.QName("", "handler"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Case.case", "case_requestHandler"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metadata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://Case.case", "case_requestItem"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setItemQName(new javax.xml.namespace.QName("http://Case.case", "item"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return Case_request.typeDesc;
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
            _javaType, _xmlType, Case_request.typeDesc);
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
            _javaType, _xmlType, Case_request.typeDesc);
    }

}
