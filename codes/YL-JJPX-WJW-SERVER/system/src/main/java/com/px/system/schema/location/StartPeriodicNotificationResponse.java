/**
 * StartPeriodicNotificationResponse.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.location;

public class StartPeriodicNotificationResponse  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StartPeriodicNotificationResponse.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">startPeriodicNotificationResponse"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("correlator");
        elemField.setXmlName(new javax.xml.namespace.QName("", "correlator"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private String correlator;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;

    public StartPeriodicNotificationResponse() {
    }
    public StartPeriodicNotificationResponse(
           String correlator) {
           this.correlator = correlator;
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
     * Gets the correlator value for this StartPeriodicNotificationResponse.
     *
     * @return correlator
     */
    public String getCorrelator() {
        return correlator;
    }

    /**
     * Sets the correlator value for this StartPeriodicNotificationResponse.
     *
     * @param correlator
     */
    public void setCorrelator(String correlator) {
        this.correlator = correlator;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof StartPeriodicNotificationResponse)) return false;
        StartPeriodicNotificationResponse other = (StartPeriodicNotificationResponse) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.correlator==null && other.getCorrelator()==null) ||
             (this.correlator!=null &&
              this.correlator.equals(other.getCorrelator())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getCorrelator() != null) {
            _hashCode += getCorrelator().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
