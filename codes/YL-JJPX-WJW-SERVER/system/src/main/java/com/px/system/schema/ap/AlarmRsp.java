/**
 * AlarmRsp.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.ap;

public class AlarmRsp  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(AlarmRsp.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">AlarmRsp"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recode");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recode"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("reMsg");
        elemField.setXmlName(new javax.xml.namespace.QName("", "reMsg"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private String recode;
    private String reMsg;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public AlarmRsp() {
    }


    public AlarmRsp(
           String recode,
           String reMsg) {
           this.recode = recode;
           this.reMsg = reMsg;
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
     * Gets the recode value for this AlarmRsp.
     *
     * @return recode
     */
    public String getRecode() {
        return recode;
    }

    /**
     * Sets the recode value for this AlarmRsp.
     *
     * @param recode
     */
    public void setRecode(String recode) {
        this.recode = recode;
    }

    /**
     * Gets the reMsg value for this AlarmRsp.
     *
     * @return reMsg
     */
    public String getReMsg() {
        return reMsg;
    }

    /**
     * Sets the reMsg value for this AlarmRsp.
     *
     * @param reMsg
     */
    public void setReMsg(String reMsg) {
        this.reMsg = reMsg;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof AlarmRsp)) return false;
        AlarmRsp other = (AlarmRsp) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.recode==null && other.getRecode()==null) ||
             (this.recode!=null &&
              this.recode.equals(other.getRecode()))) &&
            ((this.reMsg==null && other.getReMsg()==null) ||
             (this.reMsg!=null &&
              this.reMsg.equals(other.getReMsg())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRecode() != null) {
            _hashCode += getRecode().hashCode();
        }
        if (getReMsg() != null) {
            _hashCode += getReMsg().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
