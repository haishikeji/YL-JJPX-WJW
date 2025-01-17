/**
 * APSvcPerfCmdReq.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.ap;

public class APSvcPerfCmdReq  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(APSvcPerfCmdReq.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcPerfCmdReq"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("APid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "APid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("apSvcPerfCmdType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ApSvcPerfCmdType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    private String APid;
    private String apSvcPerfCmdType;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public APSvcPerfCmdReq() {
    }


    public APSvcPerfCmdReq(
           String APid,
           String apSvcPerfCmdType) {
           this.APid = APid;
           this.apSvcPerfCmdType = apSvcPerfCmdType;
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
     * Gets the APid value for this APSvcPerfCmdReq.
     *
     * @return APid
     */
    public String getAPid() {
        return APid;
    }

    /**
     * Sets the APid value for this APSvcPerfCmdReq.
     *
     * @param APid
     */
    public void setAPid(String APid) {
        this.APid = APid;
    }

    /**
     * Gets the apSvcPerfCmdType value for this APSvcPerfCmdReq.
     *
     * @return apSvcPerfCmdType
     */
    public String getApSvcPerfCmdType() {
        return apSvcPerfCmdType;
    }

    /**
     * Sets the apSvcPerfCmdType value for this APSvcPerfCmdReq.
     *
     * @param apSvcPerfCmdType
     */
    public void setApSvcPerfCmdType(String apSvcPerfCmdType) {
        this.apSvcPerfCmdType = apSvcPerfCmdType;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof APSvcPerfCmdReq)) return false;
        APSvcPerfCmdReq other = (APSvcPerfCmdReq) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.APid==null && other.getAPid()==null) ||
             (this.APid!=null &&
              this.APid.equals(other.getAPid()))) &&
            ((this.apSvcPerfCmdType==null && other.getApSvcPerfCmdType()==null) ||
             (this.apSvcPerfCmdType!=null &&
              this.apSvcPerfCmdType.equals(other.getApSvcPerfCmdType())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getAPid() != null) {
            _hashCode += getAPid().hashCode();
        }
        if (getApSvcPerfCmdType() != null) {
            _hashCode += getApSvcPerfCmdType().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
