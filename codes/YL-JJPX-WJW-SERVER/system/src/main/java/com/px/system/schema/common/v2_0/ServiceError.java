/**
 * ServiceError.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.common.v2_0;

public class ServiceError  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(ServiceError.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceError"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("messageId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MessageId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("text");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Text"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("variables");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Variables"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setMaxOccursUnbounded(true);
        typeDesc.addFieldDesc(elemField);
    }

    private String messageId;
    private String text;
    private String[] variables;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public ServiceError() {
    }


    public ServiceError(
           String messageId,
           String text,
           String[] variables) {
           this.messageId = messageId;
           this.text = text;
           this.variables = variables;
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
     * Gets the messageId value for this ServiceError.
     *
     * @return messageId
     */
    public String getMessageId() {
        return messageId;
    }

    /**
     * Sets the messageId value for this ServiceError.
     *
     * @param messageId
     */
    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    /**
     * Gets the text value for this ServiceError.
     *
     * @return text
     */
    public String getText() {
        return text;
    }

    /**
     * Sets the text value for this ServiceError.
     *
     * @param text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Gets the variables value for this ServiceError.
     *
     * @return variables
     */
    public String[] getVariables() {
        return variables;
    }

    /**
     * Sets the variables value for this ServiceError.
     *
     * @param variables
     */
    public void setVariables(String[] variables) {
        this.variables = variables;
    }

    public String getVariables(int i) {
        return this.variables[i];
    }

    public void setVariables(int i, String _value) {
        this.variables[i] = _value;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof ServiceError)) return false;
        ServiceError other = (ServiceError) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.messageId==null && other.getMessageId()==null) ||
             (this.messageId!=null &&
              this.messageId.equals(other.getMessageId()))) &&
            ((this.text==null && other.getText()==null) ||
             (this.text!=null &&
              this.text.equals(other.getText()))) &&
            ((this.variables==null && other.getVariables()==null) ||
             (this.variables!=null &&
              java.util.Arrays.equals(this.variables, other.getVariables())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getMessageId() != null) {
            _hashCode += getMessageId().hashCode();
        }
        if (getText() != null) {
            _hashCode += getText().hashCode();
        }
        if (getVariables() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVariables());
                 i++) {
                Object obj = java.lang.reflect.Array.get(getVariables(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
