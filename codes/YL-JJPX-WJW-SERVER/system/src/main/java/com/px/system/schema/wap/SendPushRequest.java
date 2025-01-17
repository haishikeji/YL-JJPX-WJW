/**
 * SendPushRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.wap;

public class SendPushRequest  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SendPushRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">sendPushRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ApplicationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("addresses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "addresses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("targetURL");
        elemField.setXmlName(new javax.xml.namespace.QName("", "targetURL"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ExtendCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subject");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subject"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("receiptRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "receiptRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private String applicationID;
    private org.apache.axis.types.URI[] addresses;
    private org.apache.axis.types.URI targetURL;
    private String extendCode;
    private String subject;
    private boolean receiptRequest;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public SendPushRequest() {
    }


    public SendPushRequest(
           String applicationID,
           org.apache.axis.types.URI[] addresses,
           org.apache.axis.types.URI targetURL,
           String extendCode,
           String subject,
           boolean receiptRequest) {
           this.applicationID = applicationID;
           this.addresses = addresses;
           this.targetURL = targetURL;
           this.extendCode = extendCode;
           this.subject = subject;
           this.receiptRequest = receiptRequest;
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
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Gets the applicationID value for this SendPushRequest.
     *
     * @return applicationID
     */
    public String getApplicationID() {
        return applicationID;
    }

    /**
     * Sets the applicationID value for this SendPushRequest.
     *
     * @param applicationID
     */
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * Gets the addresses value for this SendPushRequest.
     *
     * @return addresses
     */
    public org.apache.axis.types.URI[] getAddresses() {
        return addresses;
    }

    /**
     * Sets the addresses value for this SendPushRequest.
     *
     * @param addresses
     */
    public void setAddresses(org.apache.axis.types.URI[] addresses) {
        this.addresses = addresses;
    }

    public org.apache.axis.types.URI getAddresses(int i) {
        return this.addresses[i];
    }

    public void setAddresses(int i, org.apache.axis.types.URI _value) {
        this.addresses[i] = _value;
    }

    /**
     * Gets the targetURL value for this SendPushRequest.
     *
     * @return targetURL
     */
    public org.apache.axis.types.URI getTargetURL() {
        return targetURL;
    }

    /**
     * Sets the targetURL value for this SendPushRequest.
     *
     * @param targetURL
     */
    public void setTargetURL(org.apache.axis.types.URI targetURL) {
        this.targetURL = targetURL;
    }

    /**
     * Gets the extendCode value for this SendPushRequest.
     *
     * @return extendCode
     */
    public String getExtendCode() {
        return extendCode;
    }

    /**
     * Sets the extendCode value for this SendPushRequest.
     *
     * @param extendCode
     */
    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    /**
     * Gets the subject value for this SendPushRequest.
     *
     * @return subject
     */
    public String getSubject() {
        return subject;
    }

    /**
     * Sets the subject value for this SendPushRequest.
     *
     * @param subject
     */
    public void setSubject(String subject) {
        this.subject = subject;
    }

    /**
     * Gets the receiptRequest value for this SendPushRequest.
     *
     * @return receiptRequest
     */
    public boolean isReceiptRequest() {
        return receiptRequest;
    }

    /**
     * Sets the receiptRequest value for this SendPushRequest.
     *
     * @param receiptRequest
     */
    public void setReceiptRequest(boolean receiptRequest) {
        this.receiptRequest = receiptRequest;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendPushRequest)) return false;
        SendPushRequest other = (SendPushRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.applicationID==null && other.getApplicationID()==null) ||
             (this.applicationID!=null &&
              this.applicationID.equals(other.getApplicationID()))) &&
            ((this.addresses==null && other.getAddresses()==null) ||
             (this.addresses!=null &&
              java.util.Arrays.equals(this.addresses, other.getAddresses()))) &&
            ((this.targetURL==null && other.getTargetURL()==null) ||
             (this.targetURL!=null &&
              this.targetURL.equals(other.getTargetURL()))) &&
            ((this.extendCode==null && other.getExtendCode()==null) ||
             (this.extendCode!=null &&
              this.extendCode.equals(other.getExtendCode()))) &&
            ((this.subject==null && other.getSubject()==null) ||
             (this.subject!=null &&
              this.subject.equals(other.getSubject()))) &&
            this.receiptRequest == other.isReceiptRequest();
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getApplicationID() != null) {
            _hashCode += getApplicationID().hashCode();
        }
        if (getAddresses() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getAddresses());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getAddresses(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getTargetURL() != null) {
            _hashCode += getTargetURL().hashCode();
        }
        if (getExtendCode() != null) {
            _hashCode += getExtendCode().hashCode();
        }
        if (getSubject() != null) {
            _hashCode += getSubject().hashCode();
        }
        _hashCode += (isReceiptRequest() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
