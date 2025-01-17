/**
 * SendSmsRequest.java
 * <p>
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.sms;

public class SendSmsRequest implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
            new org.apache.axis.description.TypeDesc(SendSmsRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">sendSmsRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ApplicationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("destinationAddresses");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DestinationAddresses"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("extendCode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ExtendCode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("message");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Message"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageFormat");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageFormat"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "MessageFormat"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("sendMethod");
        elemField.setXmlName(new javax.xml.namespace.QName("", "SendMethod"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "SendMethodType"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deliveryResultRequest");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DeliveryResultRequest"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "boolean"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private String applicationID;
    private org.apache.axis.types.URI[] destinationAddresses;
    private String extendCode;
    private String message;
    private MessageFormat messageFormat;
    private SendMethodType sendMethod;
    private boolean deliveryResultRequest;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public SendSmsRequest() {
    }


    public SendSmsRequest(
            String applicationID,
            org.apache.axis.types.URI[] destinationAddresses,
            String extendCode,
            String message,
            MessageFormat messageFormat,
            SendMethodType sendMethod,
            boolean deliveryResultRequest) {
        this.applicationID = applicationID;
        this.destinationAddresses = destinationAddresses;
        this.extendCode = extendCode;
        this.message = message;
        this.messageFormat = messageFormat;
        this.sendMethod = sendMethod;
        this.deliveryResultRequest = deliveryResultRequest;
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
                new org.apache.axis.encoding.ser.BeanSerializer(
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
                new org.apache.axis.encoding.ser.BeanDeserializer(
                        _javaType, _xmlType, typeDesc);
    }

    /**
     * Gets the applicationID value for this SendSmsRequest.
     *
     * @return applicationID
     */
    public String getApplicationID() {
        return applicationID;
    }

    /**
     * Sets the applicationID value for this SendSmsRequest.
     *
     * @param applicationID
     */
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * Gets the destinationAddresses value for this SendSmsRequest.
     *
     * @return destinationAddresses
     */
    public org.apache.axis.types.URI[] getDestinationAddresses() {
        return destinationAddresses;
    }

    /**
     * Sets the destinationAddresses value for this SendSmsRequest.
     *
     * @param destinationAddresses
     */
    public void setDestinationAddresses(org.apache.axis.types.URI[] destinationAddresses) {
        this.destinationAddresses = destinationAddresses;
    }

    public org.apache.axis.types.URI getDestinationAddresses(int i) {
        return this.destinationAddresses[i];
    }

    public void setDestinationAddresses(int i, org.apache.axis.types.URI _value) {
        this.destinationAddresses[i] = _value;
    }

    /**
     * Gets the extendCode value for this SendSmsRequest.
     *
     * @return extendCode
     */
    public String getExtendCode() {
        return extendCode;
    }

    /**
     * Sets the extendCode value for this SendSmsRequest.
     *
     * @param extendCode
     */
    public void setExtendCode(String extendCode) {
        this.extendCode = extendCode;
    }

    /**
     * Gets the message value for this SendSmsRequest.
     *
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets the message value for this SendSmsRequest.
     *
     * @param message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets the messageFormat value for this SendSmsRequest.
     *
     * @return messageFormat
     */
    public MessageFormat getMessageFormat() {
        return messageFormat;
    }

    /**
     * Sets the messageFormat value for this SendSmsRequest.
     *
     * @param messageFormat
     */
    public void setMessageFormat(MessageFormat messageFormat) {
        this.messageFormat = messageFormat;
    }

    /**
     * Gets the sendMethod value for this SendSmsRequest.
     *
     * @return sendMethod
     */
    public SendMethodType getSendMethod() {
        return sendMethod;
    }

    /**
     * Sets the sendMethod value for this SendSmsRequest.
     *
     * @param sendMethod
     */
    public void setSendMethod(SendMethodType sendMethod) {
        this.sendMethod = sendMethod;
    }

    /**
     * Gets the deliveryResultRequest value for this SendSmsRequest.
     *
     * @return deliveryResultRequest
     */
    public boolean isDeliveryResultRequest() {
        return deliveryResultRequest;
    }

    /**
     * Sets the deliveryResultRequest value for this SendSmsRequest.
     *
     * @param deliveryResultRequest
     */
    public void setDeliveryResultRequest(boolean deliveryResultRequest) {
        this.deliveryResultRequest = deliveryResultRequest;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof SendSmsRequest)) return false;
        SendSmsRequest other = (SendSmsRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
                ((this.applicationID == null && other.getApplicationID() == null) ||
                        (this.applicationID != null &&
                                this.applicationID.equals(other.getApplicationID()))) &&
                ((this.destinationAddresses == null && other.getDestinationAddresses() == null) ||
                        (this.destinationAddresses != null &&
                                java.util.Arrays.equals(this.destinationAddresses, other.getDestinationAddresses()))) &&
                ((this.extendCode == null && other.getExtendCode() == null) ||
                        (this.extendCode != null &&
                                this.extendCode.equals(other.getExtendCode()))) &&
                ((this.message == null && other.getMessage() == null) ||
                        (this.message != null &&
                                this.message.equals(other.getMessage()))) &&
                ((this.messageFormat == null && other.getMessageFormat() == null) ||
                        (this.messageFormat != null &&
                                this.messageFormat.equals(other.getMessageFormat()))) &&
                ((this.sendMethod == null && other.getSendMethod() == null) ||
                        (this.sendMethod != null &&
                                this.sendMethod.equals(other.getSendMethod()))) &&
                this.deliveryResultRequest == other.isDeliveryResultRequest();
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
        if (getDestinationAddresses() != null) {
            for (int i = 0;
                 i < java.lang.reflect.Array.getLength(getDestinationAddresses());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getDestinationAddresses(), i);
                if (obj != null &&
                        !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        if (getExtendCode() != null) {
            _hashCode += getExtendCode().hashCode();
        }
        if (getMessage() != null) {
            _hashCode += getMessage().hashCode();
        }
        if (getMessageFormat() != null) {
            _hashCode += getMessageFormat().hashCode();
        }
        if (getSendMethod() != null) {
            _hashCode += getSendMethod().hashCode();
        }
        _hashCode += (isDeliveryResultRequest() ? Boolean.TRUE : Boolean.FALSE).hashCode();
        __hashCodeCalc = false;
        return _hashCode;
    }

}
