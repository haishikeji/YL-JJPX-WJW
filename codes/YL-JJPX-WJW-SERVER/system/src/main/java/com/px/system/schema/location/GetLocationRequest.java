/**
 * GetLocationRequest.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.schema.location;

import com.px.system.schema.common.v2_0.TimeMetric;

public class GetLocationRequest  implements java.io.Serializable {
    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetLocationRequest.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationRequest"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requester");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Requester"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("address");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Address"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "anyURI"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("requestedAccuracy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "RequestedAccuracy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("acceptableAccuracy");
        elemField.setXmlName(new javax.xml.namespace.QName("", "AcceptableAccuracy"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("maximumAge");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MaximumAge"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "TimeMetric"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseTime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ResponseTime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "TimeMetric"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("tolerance");
        elemField.setXmlName(new javax.xml.namespace.QName("", "Tolerance"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "DelayTolerance"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("applicationId");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ApplicationId"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("serviceType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "serviceType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "ServiceType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("crs");
        elemField.setXmlName(new javax.xml.namespace.QName("", "crs"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "CoordinateReferenceSystem"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("locType");
        elemField.setXmlName(new javax.xml.namespace.QName("", "locType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("prio");
        elemField.setXmlName(new javax.xml.namespace.QName("", "prio"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "Priority"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    private org.apache.axis.types.URI requester;
    private org.apache.axis.types.URI address;
    private int requestedAccuracy;
    private int acceptableAccuracy;
    private TimeMetric maximumAge;
    private TimeMetric responseTime;
    private DelayTolerance tolerance;
    private String applicationId;
    private ServiceType serviceType;
    private CoordinateReferenceSystem crs;
    private LocType locType;
    private Priority prio;
    private Object __equalsCalc = null;
    private boolean __hashCodeCalc = false;


    public GetLocationRequest() {
    }


    public GetLocationRequest(
           org.apache.axis.types.URI requester,
           org.apache.axis.types.URI address,
           int requestedAccuracy,
           int acceptableAccuracy,
           TimeMetric maximumAge,
           TimeMetric responseTime,
           DelayTolerance tolerance,
           String applicationId,
           ServiceType serviceType,
           CoordinateReferenceSystem crs,
           LocType locType,
           Priority prio) {
           this.requester = requester;
           this.address = address;
           this.requestedAccuracy = requestedAccuracy;
           this.acceptableAccuracy = acceptableAccuracy;
           this.maximumAge = maximumAge;
           this.responseTime = responseTime;
           this.tolerance = tolerance;
           this.applicationId = applicationId;
           this.serviceType = serviceType;
           this.crs = crs;
           this.locType = locType;
           this.prio = prio;
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
     * Gets the requester value for this GetLocationRequest.
     *
     * @return requester
     */
    public org.apache.axis.types.URI getRequester() {
        return requester;
    }

    /**
     * Sets the requester value for this GetLocationRequest.
     *
     * @param requester
     */
    public void setRequester(org.apache.axis.types.URI requester) {
        this.requester = requester;
    }

    /**
     * Gets the address value for this GetLocationRequest.
     *
     * @return address
     */
    public org.apache.axis.types.URI getAddress() {
        return address;
    }

    /**
     * Sets the address value for this GetLocationRequest.
     *
     * @param address
     */
    public void setAddress(org.apache.axis.types.URI address) {
        this.address = address;
    }

    /**
     * Gets the requestedAccuracy value for this GetLocationRequest.
     *
     * @return requestedAccuracy
     */
    public int getRequestedAccuracy() {
        return requestedAccuracy;
    }

    /**
     * Sets the requestedAccuracy value for this GetLocationRequest.
     *
     * @param requestedAccuracy
     */
    public void setRequestedAccuracy(int requestedAccuracy) {
        this.requestedAccuracy = requestedAccuracy;
    }

    /**
     * Gets the acceptableAccuracy value for this GetLocationRequest.
     *
     * @return acceptableAccuracy
     */
    public int getAcceptableAccuracy() {
        return acceptableAccuracy;
    }

    /**
     * Sets the acceptableAccuracy value for this GetLocationRequest.
     *
     * @param acceptableAccuracy
     */
    public void setAcceptableAccuracy(int acceptableAccuracy) {
        this.acceptableAccuracy = acceptableAccuracy;
    }

    /**
     * Gets the maximumAge value for this GetLocationRequest.
     *
     * @return maximumAge
     */
    public TimeMetric getMaximumAge() {
        return maximumAge;
    }

    /**
     * Sets the maximumAge value for this GetLocationRequest.
     *
     * @param maximumAge
     */
    public void setMaximumAge(TimeMetric maximumAge) {
        this.maximumAge = maximumAge;
    }

    /**
     * Gets the responseTime value for this GetLocationRequest.
     *
     * @return responseTime
     */
    public TimeMetric getResponseTime() {
        return responseTime;
    }

    /**
     * Sets the responseTime value for this GetLocationRequest.
     *
     * @param responseTime
     */
    public void setResponseTime(TimeMetric responseTime) {
        this.responseTime = responseTime;
    }

    /**
     * Gets the tolerance value for this GetLocationRequest.
     *
     * @return tolerance
     */
    public DelayTolerance getTolerance() {
        return tolerance;
    }

    /**
     * Sets the tolerance value for this GetLocationRequest.
     *
     * @param tolerance
     */
    public void setTolerance(DelayTolerance tolerance) {
        this.tolerance = tolerance;
    }

    /**
     * Gets the applicationId value for this GetLocationRequest.
     *
     * @return applicationId
     */
    public String getApplicationId() {
        return applicationId;
    }

    /**
     * Sets the applicationId value for this GetLocationRequest.
     *
     * @param applicationId
     */
    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    /**
     * Gets the serviceType value for this GetLocationRequest.
     *
     * @return serviceType
     */
    public ServiceType getServiceType() {
        return serviceType;
    }

    /**
     * Sets the serviceType value for this GetLocationRequest.
     *
     * @param serviceType
     */
    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    /**
     * Gets the crs value for this GetLocationRequest.
     *
     * @return crs
     */
    public CoordinateReferenceSystem getCrs() {
        return crs;
    }

    /**
     * Sets the crs value for this GetLocationRequest.
     *
     * @param crs
     */
    public void setCrs(CoordinateReferenceSystem crs) {
        this.crs = crs;
    }

    /**
     * Gets the locType value for this GetLocationRequest.
     *
     * @return locType
     */
    public LocType getLocType() {
        return locType;
    }

    /**
     * Sets the locType value for this GetLocationRequest.
     *
     * @param locType
     */
    public void setLocType(LocType locType) {
        this.locType = locType;
    }

    /**
     * Gets the prio value for this GetLocationRequest.
     *
     * @return prio
     */
    public Priority getPrio() {
        return prio;
    }

    /**
     * Sets the prio value for this GetLocationRequest.
     *
     * @param prio
     */
    public void setPrio(Priority prio) {
        this.prio = prio;
    }

    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof GetLocationRequest)) return false;
        GetLocationRequest other = (GetLocationRequest) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.requester==null && other.getRequester()==null) ||
             (this.requester!=null &&
              this.requester.equals(other.getRequester()))) &&
            ((this.address==null && other.getAddress()==null) ||
             (this.address!=null &&
              this.address.equals(other.getAddress()))) &&
            this.requestedAccuracy == other.getRequestedAccuracy() &&
            this.acceptableAccuracy == other.getAcceptableAccuracy() &&
            ((this.maximumAge==null && other.getMaximumAge()==null) ||
             (this.maximumAge!=null &&
              this.maximumAge.equals(other.getMaximumAge()))) &&
            ((this.responseTime==null && other.getResponseTime()==null) ||
             (this.responseTime!=null &&
              this.responseTime.equals(other.getResponseTime()))) &&
            ((this.tolerance==null && other.getTolerance()==null) ||
             (this.tolerance!=null &&
              this.tolerance.equals(other.getTolerance()))) &&
            ((this.applicationId==null && other.getApplicationId()==null) ||
             (this.applicationId!=null &&
              this.applicationId.equals(other.getApplicationId()))) &&
            ((this.serviceType==null && other.getServiceType()==null) ||
             (this.serviceType!=null &&
              this.serviceType.equals(other.getServiceType()))) &&
            ((this.crs==null && other.getCrs()==null) ||
             (this.crs!=null &&
              this.crs.equals(other.getCrs()))) &&
            ((this.locType==null && other.getLocType()==null) ||
             (this.locType!=null &&
              this.locType.equals(other.getLocType()))) &&
            ((this.prio==null && other.getPrio()==null) ||
             (this.prio!=null &&
              this.prio.equals(other.getPrio())));
        __equalsCalc = null;
        return _equals;
    }

    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getRequester() != null) {
            _hashCode += getRequester().hashCode();
        }
        if (getAddress() != null) {
            _hashCode += getAddress().hashCode();
        }
        _hashCode += getRequestedAccuracy();
        _hashCode += getAcceptableAccuracy();
        if (getMaximumAge() != null) {
            _hashCode += getMaximumAge().hashCode();
        }
        if (getResponseTime() != null) {
            _hashCode += getResponseTime().hashCode();
        }
        if (getTolerance() != null) {
            _hashCode += getTolerance().hashCode();
        }
        if (getApplicationId() != null) {
            _hashCode += getApplicationId().hashCode();
        }
        if (getServiceType() != null) {
            _hashCode += getServiceType().hashCode();
        }
        if (getCrs() != null) {
            _hashCode += getCrs().hashCode();
        }
        if (getLocType() != null) {
            _hashCode += getLocType().hashCode();
        }
        if (getPrio() != null) {
            _hashCode += getPrio().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

}
