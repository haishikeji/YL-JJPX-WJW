/**
 * DeliveryStatus.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.mms;

public class DeliveryStatus implements java.io.Serializable {
    public static final String _DeliveredToNetwork = "DeliveredToNetwork";
    public static final String _DeliveryUncertain = "DeliveryUncertain";
    public static final String _DeliveryImpossible = "DeliveryImpossible";
    public static final String _MessageWaiting = "MessageWaiting";
    public static final String _DeliveredToTerminal = "DeliveredToTerminal";
    public static final String _DeliveryNotificationNotSupported = "DeliveryNotificationNotSupported";
    public static final DeliveryStatus DeliveredToNetwork = new DeliveryStatus(_DeliveredToNetwork);
    public static final DeliveryStatus DeliveryUncertain = new DeliveryStatus(_DeliveryUncertain);
    public static final DeliveryStatus DeliveryImpossible = new DeliveryStatus(_DeliveryImpossible);
    public static final DeliveryStatus MessageWaiting = new DeliveryStatus(_MessageWaiting);
    public static final DeliveryStatus DeliveredToTerminal = new DeliveryStatus(_DeliveredToTerminal);
    public static final DeliveryStatus DeliveryNotificationNotSupported = new DeliveryStatus(_DeliveryNotificationNotSupported);
    private static java.util.HashMap _table_ = new java.util.HashMap();
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(DeliveryStatus.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "DeliveryStatus"));
    }

    private String _value_;
    // Constructor
    protected DeliveryStatus(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static DeliveryStatus fromValue(String value)
          throws IllegalArgumentException {
        DeliveryStatus enumeration = (DeliveryStatus)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }

    public static DeliveryStatus fromString(String value)
          throws IllegalArgumentException {
        return fromValue(value);
    }

    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new org.apache.axis.encoding.ser.EnumSerializer(
            _javaType, _xmlType);
    }

    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new org.apache.axis.encoding.ser.EnumDeserializer(
            _javaType, _xmlType);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    public String getValue() { return _value_;}

    public boolean equals(Object obj) {return (obj == this);}

    public int hashCode() { return toString().hashCode();}

    public String toString() { return _value_;}

    public Object readResolve() throws java.io.ObjectStreamException { return fromValue(_value_);}

}
