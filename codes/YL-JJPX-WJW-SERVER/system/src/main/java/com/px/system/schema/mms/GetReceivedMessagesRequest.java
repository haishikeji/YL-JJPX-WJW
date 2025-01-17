/**
 * GetReceivedMessagesRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.mms;

public class GetReceivedMessagesRequest  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetReceivedMessagesRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getReceivedMessagesRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ApplicationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("priority");
        elemField.setXmlName(new javax.xml.namespace.QName("", "priority"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MessagePriority"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private String applicationID;
    private MessagePriority priority;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public GetReceivedMessagesRequest() {
    }


    public GetReceivedMessagesRequest(
           String applicationID,
           MessagePriority priority) {
           this.applicationID = applicationID;
           this.priority = priority;
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
     * Gets the applicationID value for this GetReceivedMessagesRequest.
     *
     * @return applicationID
     */
    public String getApplicationID() {
        return applicationID;
    }

    /**
     * Sets the applicationID value for this GetReceivedMessagesRequest.
     *
     * @param applicationID
     */
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    /**
     * Gets the priority value for this GetReceivedMessagesRequest.
     *
     * @return priority
     */
    public MessagePriority getPriority() {
        return priority;
    }

    /**
     * Sets the priority value for this GetReceivedMessagesRequest.
     *
     * @param priority
     */
    public void setPriority(MessagePriority priority) {
        this.priority = priority;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetReceivedMessagesRequest)) return false;
        GetReceivedMessagesRequest other = (GetReceivedMessagesRequest) obj;
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
            ((this.priority==null && other.getPriority()==null) ||
             (this.priority!=null &&
              this.priority.equals(other.getPriority())));
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
        if (getPriority() != null) {
            _hashCode += getPriority().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
