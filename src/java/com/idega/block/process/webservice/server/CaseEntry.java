/**
 * CaseEntry.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.idega.block.process.webservice.server;

public class CaseEntry  implements java.io.Serializable {
    /**
	 * Comment for <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -1256280973402092309L;

		private java.lang.String body;

    private java.lang.String code;

    private java.lang.String created;

    private java.lang.String externalCase_id;

    private com.idega.block.process.webservice.server.Handler handler;

    private java.lang.String id;

    private com.idega.block.process.webservice.server.Item[] metadata;

    private java.lang.String modified;

    private com.idega.block.process.webservice.server.Owner owner;

    private com.idega.block.process.webservice.server.Recipient recipient;

    private java.lang.String status;

    private java.lang.String subject;

    public CaseEntry() {
    }

    public CaseEntry(
           java.lang.String body,
           java.lang.String code,
           java.lang.String created,
           java.lang.String externalCase_id,
           com.idega.block.process.webservice.server.Handler handler,
           java.lang.String id,
           com.idega.block.process.webservice.server.Item[] metadata,
           java.lang.String modified,
           com.idega.block.process.webservice.server.Owner owner,
           com.idega.block.process.webservice.server.Recipient recipient,
           java.lang.String status,
           java.lang.String subject) {
           this.body = body;
           this.code = code;
           this.created = created;
           this.externalCase_id = externalCase_id;
           this.handler = handler;
           this.id = id;
           this.metadata = metadata;
           this.modified = modified;
           this.owner = owner;
           this.recipient = recipient;
           this.status = status;
           this.subject = subject;
    }


    /**
     * Gets the body value for this CaseEntry.
     * 
     * @return body
     */
    public java.lang.String getBody() {
        return body;
    }


    /**
     * Sets the body value for this CaseEntry.
     * 
     * @param body
     */
    public void setBody(java.lang.String body) {
        this.body = body;
    }


    /**
     * Gets the code value for this CaseEntry.
     * 
     * @return code
     */
    public java.lang.String getCode() {
        return code;
    }


    /**
     * Sets the code value for this CaseEntry.
     * 
     * @param code
     */
    public void setCode(java.lang.String code) {
        this.code = code;
    }


    /**
     * Gets the created value for this CaseEntry.
     * 
     * @return created
     */
    public java.lang.String getCreated() {
        return created;
    }


    /**
     * Sets the created value for this CaseEntry.
     * 
     * @param created
     */
    public void setCreated(java.lang.String created) {
        this.created = created;
    }


    /**
     * Gets the externalCase_id value for this CaseEntry.
     * 
     * @return externalCase_id
     */
    public java.lang.String getExternalCase_id() {
        return externalCase_id;
    }


    /**
     * Sets the externalCase_id value for this CaseEntry.
     * 
     * @param externalCase_id
     */
    public void setExternalCase_id(java.lang.String externalCase_id) {
        this.externalCase_id = externalCase_id;
    }


    /**
     * Gets the handler value for this CaseEntry.
     * 
     * @return handler
     */
    public com.idega.block.process.webservice.server.Handler getHandler() {
        return handler;
    }


    /**
     * Sets the handler value for this CaseEntry.
     * 
     * @param handler
     */
    public void setHandler(com.idega.block.process.webservice.server.Handler handler) {
        this.handler = handler;
    }


    /**
     * Gets the id value for this CaseEntry.
     * 
     * @return id
     */
    public java.lang.String getId() {
        return id;
    }


    /**
     * Sets the id value for this CaseEntry.
     * 
     * @param id
     */
    public void setId(java.lang.String id) {
        this.id = id;
    }


    /**
     * Gets the metadata value for this CaseEntry.
     * 
     * @return metadata
     */
    public com.idega.block.process.webservice.server.Item[] getMetadata() {
        return metadata;
    }


    /**
     * Sets the metadata value for this CaseEntry.
     * 
     * @param metadata
     */
    public void setMetadata(com.idega.block.process.webservice.server.Item[] metadata) {
        this.metadata = metadata;
    }


    /**
     * Gets the modified value for this CaseEntry.
     * 
     * @return modified
     */
    public java.lang.String getModified() {
        return modified;
    }


    /**
     * Sets the modified value for this CaseEntry.
     * 
     * @param modified
     */
    public void setModified(java.lang.String modified) {
        this.modified = modified;
    }


    /**
     * Gets the owner value for this CaseEntry.
     * 
     * @return owner
     */
    public com.idega.block.process.webservice.server.Owner getOwner() {
        return owner;
    }


    /**
     * Sets the owner value for this CaseEntry.
     * 
     * @param owner
     */
    public void setOwner(com.idega.block.process.webservice.server.Owner owner) {
        this.owner = owner;
    }


    /**
     * Gets the recipient value for this CaseEntry.
     * 
     * @return recipient
     */
    public com.idega.block.process.webservice.server.Recipient getRecipient() {
        return recipient;
    }


    /**
     * Sets the recipient value for this CaseEntry.
     * 
     * @param recipient
     */
    public void setRecipient(com.idega.block.process.webservice.server.Recipient recipient) {
        this.recipient = recipient;
    }


    /**
     * Gets the status value for this CaseEntry.
     * 
     * @return status
     */
    public java.lang.String getStatus() {
        return status;
    }


    /**
     * Sets the status value for this CaseEntry.
     * 
     * @param status
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }


    /**
     * Gets the subject value for this CaseEntry.
     * 
     * @return subject
     */
    public java.lang.String getSubject() {
        return subject;
    }


    /**
     * Sets the subject value for this CaseEntry.
     * 
     * @param subject
     */
    public void setSubject(java.lang.String subject) {
        this.subject = subject;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CaseEntry)) {
					return false;
				}
        CaseEntry other = (CaseEntry) obj;
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
            ((body==null && other.getBody()==null) || 
             (body!=null &&
              body.equals(other.getBody()))) &&
            ((code==null && other.getCode()==null) || 
             (code!=null &&
              code.equals(other.getCode()))) &&
            ((created==null && other.getCreated()==null) || 
             (created!=null &&
              created.equals(other.getCreated()))) &&
            ((externalCase_id==null && other.getExternalCase_id()==null) || 
             (externalCase_id!=null &&
              externalCase_id.equals(other.getExternalCase_id()))) &&
            ((handler==null && other.getHandler()==null) || 
             (handler!=null &&
              handler.equals(other.getHandler()))) &&
            ((id==null && other.getId()==null) || 
             (id!=null &&
              id.equals(other.getId()))) &&
            ((metadata==null && other.getMetadata()==null) || 
             (metadata!=null &&
              java.util.Arrays.equals(metadata, other.getMetadata()))) &&
            ((modified==null && other.getModified()==null) || 
             (modified!=null &&
              modified.equals(other.getModified()))) &&
            ((owner==null && other.getOwner()==null) || 
             (owner!=null &&
              owner.equals(other.getOwner()))) &&
            ((recipient==null && other.getRecipient()==null) || 
             (recipient!=null &&
              recipient.equals(other.getRecipient()))) &&
            ((status==null && other.getStatus()==null) || 
             (status!=null &&
              status.equals(other.getStatus()))) &&
            ((subject==null && other.getSubject()==null) || 
             (subject!=null &&
              subject.equals(other.getSubject())));
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
        if (getBody() != null) {
            _hashCode += getBody().hashCode();
        }
        if (getCode() != null) {
            _hashCode += getCode().hashCode();
        }
        if (getCreated() != null) {
            _hashCode += getCreated().hashCode();
        }
        if (getExternalCase_id() != null) {
            _hashCode += getExternalCase_id().hashCode();
        }
        if (getHandler() != null) {
            _hashCode += getHandler().hashCode();
        }
        if (getId() != null) {
            _hashCode += getId().hashCode();
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
        if (getModified() != null) {
            _hashCode += getModified().hashCode();
        }
        if (getOwner() != null) {
            _hashCode += getOwner().hashCode();
        }
        if (getRecipient() != null) {
            _hashCode += getRecipient().hashCode();
        }
        if (getStatus() != null) {
            _hashCode += getStatus().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(CaseEntry.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "CaseEntry"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("body");
        elemField.setXmlName(new javax.xml.namespace.QName("", "body"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("code");
        elemField.setXmlName(new javax.xml.namespace.QName("", "code"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("created");
        elemField.setXmlName(new javax.xml.namespace.QName("", "created"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("externalCase_id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "externalCase_id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("handler");
        elemField.setXmlName(new javax.xml.namespace.QName("", "handler"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Handler"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("id");
        elemField.setXmlName(new javax.xml.namespace.QName("", "id"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("metadata");
        elemField.setXmlName(new javax.xml.namespace.QName("", "metadata"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Item"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("modified");
        elemField.setXmlName(new javax.xml.namespace.QName("", "modified"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("owner");
        elemField.setXmlName(new javax.xml.namespace.QName("", "owner"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Owner"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recipient");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recipient"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.idega.block.process.webservice", "Recipient"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("status");
        elemField.setXmlName(new javax.xml.namespace.QName("", "status"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://schemas.xmlsoap.org/soap/encoding/", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return CaseEntry.typeDesc;
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
            _javaType, _xmlType, CaseEntry.typeDesc);
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
            _javaType, _xmlType, CaseEntry.typeDesc);
    }

}
