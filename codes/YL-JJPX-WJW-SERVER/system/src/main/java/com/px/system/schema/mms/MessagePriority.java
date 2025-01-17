/**
 * MessagePriority.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.mms;

public class MessagePriority implements java.io.Serializable {
    public static final String _Default = "Default";
    public static final String _Low = "Low";
    public static final String _Normal = "Normal";
    public static final String _High = "High";
    public static final MessagePriority Default = new MessagePriority(_Default);
    public static final MessagePriority Low = new MessagePriority(_Low);
    public static final MessagePriority Normal = new MessagePriority(_Normal);
    public static final MessagePriority High = new MessagePriority(_High);
    private static java.util.HashMap _table_ = new java.util.HashMap();
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(MessagePriority.class);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MessagePriority"));
    }

    private String _value_;
    // Constructor
    protected MessagePriority(String value) {
        _value_ = value;
        _table_.put(_value_,this);
    }

    public static MessagePriority fromValue(String value)
          throws IllegalArgumentException {
        MessagePriority enumeration = (MessagePriority)
            _table_.get(value);
        if (enumeration==null) throw new IllegalArgumentException();
        return enumeration;
    }

    public static MessagePriority fromString(String value)
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
