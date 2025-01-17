/**
 * Cmcc_mas_wbsSoapBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.service.impl;

import com.px.system.schema.ap.*;
import com.px.system.schema.common.v2_0.*;
import com.px.system.schema.location.*;
import com.px.system.schema.mms.DeliveryInformation;
import com.px.system.schema.mms.*;
import com.px.system.schema.notification.StartNotificationRequest;
import com.px.system.schema.notification.StopNotificationRequest;
import com.px.system.schema.sms.DeliveryStatus;
import com.px.system.schema.sms.*;
import com.px.system.schema.ussd.*;
import com.px.system.schema.wap.GetPushDeliveryStatusRequest;
import com.px.system.schema.wap.NotifyPushDeliveryReceiptRequest;
import com.px.system.schema.wap.SendPushRequest;
import com.px.system.schema.wap.SendPushResponse;
import com.px.system.service.Cmcc_mas_wbs_PortType;

public class Cmcc_mas_wbsSoapBindingStub extends org.apache.axis.client.Stub implements Cmcc_mas_wbs_PortType {
    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[37];
        _initOperationDesc1();
        _initOperationDesc2();
        _initOperationDesc3();
        _initOperationDesc4();
    }

    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    public Cmcc_mas_wbsSoapBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public Cmcc_mas_wbsSoapBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public Cmcc_mas_wbsSoapBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
        ((org.apache.axis.client.Service)super.service).setTypeMappingVersion("1.2");
            Class cls;
            javax.xml.namespace.QName qName;
            javax.xml.namespace.QName qName2;
            Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            Class simplelistsf = org.apache.axis.encoding.ser.SimpleListSerializerFactory.class;
            Class simplelistdf = org.apache.axis.encoding.ser.SimpleListDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">AlarmReq");
            cachedSerQNames.add(qName);
            cls = AlarmReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">AlarmRsp");
            cachedSerQNames.add(qName);
            cls = AlarmRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APLogOutReq");
            cachedSerQNames.add(qName);
            cls = APLogOutReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APLogOutRsp");
            cachedSerQNames.add(qName);
            cls = APLogOutRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APRegistrationReq");
            cachedSerQNames.add(qName);
            cls = APRegistrationReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APRegistrationRsp");
            cachedSerQNames.add(qName);
            cls = APRegistrationRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APStatusRepReq");
            cachedSerQNames.add(qName);
            cls = APStatusRepReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APStatusRepRsp");
            cachedSerQNames.add(qName);
            cls = APStatusRepRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcAuthenticReq");
            cachedSerQNames.add(qName);
            cls = APSvcAuthenticReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcAuthenticRsp");
            cachedSerQNames.add(qName);
            cls = APSvcAuthenticRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcPerfCmdReq");
            cachedSerQNames.add(qName);
            cls = APSvcPerfCmdReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcPerfReportReq");
            cachedSerQNames.add(qName);
            cls = APSvcPerfReportReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">PauseAPReq");
            cachedSerQNames.add(qName);
            cls = PauseAPReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">PauseAPRsp");
            cachedSerQNames.add(qName);
            cls = PauseAPRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">RecoveryAPReq");
            cachedSerQNames.add(qName);
            cls = RecoveryAPReq.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">RecoveryAPRsp");
            cachedSerQNames.add(qName);
            cls = RecoveryAPRsp.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APLogoutResult");
            cachedSerQNames.add(qName);
            cls = APLogoutResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APRegResult");
            cachedSerQNames.add(qName);
            cls = APRegResult.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APStatusType");
            cachedSerQNames.add(qName);
            cls = APStatusType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "CMAbility");
            cachedSerQNames.add(qName);
            cls = CMAbility.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "MessageNotificationType");
            cachedSerQNames.add(qName);
            cls = MessageNotificationType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException");
            cachedSerQNames.add(qName);
            cls = PolicyException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceError");
            cachedSerQNames.add(qName);
            cls = ServiceError.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException");
            cachedSerQNames.add(qName);
            cls = ServiceException.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "TimeMetric");
            cachedSerQNames.add(qName);
            cls = TimeMetric.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "TimeMetricsValues");
            cachedSerQNames.add(qName);
            cls = TimeMetricsValues.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">EndNotificationRequest");
            cachedSerQNames.add(qName);
            cls = EndNotificationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationForGroupRequest");
            cachedSerQNames.add(qName);
            cls = GetLocationForGroupRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationForGroupResponse");
            cachedSerQNames.add(qName);
            cls = LocationData[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationData");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationRequest");
            cachedSerQNames.add(qName);
            cls = GetLocationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationResponse");
            cachedSerQNames.add(qName);
            cls = GetLocationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationEndRequest");
            cachedSerQNames.add(qName);
            cls = LocationEndRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationErrorRequest");
            cachedSerQNames.add(qName);
            cls = LocationErrorRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationNotificationRequest");
            cachedSerQNames.add(qName);
            cls = LocationNotificationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">startPeriodicNotificationRequest");
            cachedSerQNames.add(qName);
            cls = StartPeriodicNotificationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">startPeriodicNotificationResponse");
            cachedSerQNames.add(qName);
            cls = StartPeriodicNotificationResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "CoordinateReferenceSystem");
            cachedSerQNames.add(qName);
            cls = CoordinateReferenceSystem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "DelayTolerance");
            cachedSerQNames.add(qName);
            cls = DelayTolerance.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationData");
            cachedSerQNames.add(qName);
            cls = LocationData.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationInfo");
            cachedSerQNames.add(qName);
            cls = LocationInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocType");
            cachedSerQNames.add(qName);
            cls = LocType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "Priority");
            cachedSerQNames.add(qName);
            cls = Priority.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "RetrievalStatus");
            cachedSerQNames.add(qName);
            cls = RetrievalStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "ServiceType");
            cachedSerQNames.add(qName);
            cls = ServiceType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageDeliveryStatusRequest");
            cachedSerQNames.add(qName);
            cls = GetMessageDeliveryStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageDeliveryStatusResponse");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "DeliveryInformation");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageRequest");
            cachedSerQNames.add(qName);
            cls = GetMessageRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageResponse");
            cachedSerQNames.add(qName);
            cls = GetMessageResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getReceivedMessagesRequest");
            cachedSerQNames.add(qName);
            cls = GetReceivedMessagesRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getReceivedMessagesResponse");
            cachedSerQNames.add(qName);
            cls = MessageReference[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MessageReference");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">notifyMessageDeliveryReceiptRequest");
            cachedSerQNames.add(qName);
            cls = NotifyMessageDeliveryReceiptRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">notifyMessageReceptionRequest");
            cachedSerQNames.add(qName);
            cls = NotifyMessageReceptionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">sendMessageRequest");
            cachedSerQNames.add(qName);
            cls = SendMessageRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">sendMessageResponse");
            cachedSerQNames.add(qName);
            cls = SendMessageResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "DeliveryInformation");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "DeliveryStatus");
            cachedSerQNames.add(qName);
            cls = DeliveryStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MessagePriority");
            cachedSerQNames.add(qName);
            cls = MessagePriority.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MessageReference");
            cachedSerQNames.add(qName);
            cls = MessageReference.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "MmsMessage");
            cachedSerQNames.add(qName);
            cls = MmsMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", ">startNotificationRequest");
            cachedSerQNames.add(qName);
            cls = StartNotificationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", ">stopNotificationRequest");
            cachedSerQNames.add(qName);
            cls = StopNotificationRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetReceivedSmsRequest");
            cachedSerQNames.add(qName);
            cls = GetReceivedSmsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetReceivedSmsResponse");
            cachedSerQNames.add(qName);
            cls = SMSMessage[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "SMSMessage");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetSmsDeliveryStatusRequest");
            cachedSerQNames.add(qName);
            cls = GetSmsDeliveryStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetSmsDeliveryStatusResponse");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "DeliveryInformation");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">notifySmsDeliveryStatusRequest");
            cachedSerQNames.add(qName);
            cls = NotifySmsDeliveryStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">notifySmsReceptionRequest");
            cachedSerQNames.add(qName);
            cls = NotifySmsReceptionRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">sendSmsRequest");
            cachedSerQNames.add(qName);
            cls = SendSmsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">sendSmsResponse");
            cachedSerQNames.add(qName);
            cls = SendSmsResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "DeliveryInformation");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "DeliveryStatus");
            cachedSerQNames.add(qName);
            cls = DeliveryStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "MessageFormat");
            cachedSerQNames.add(qName);
            cls = MessageFormat.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "SendMethodType");
            cachedSerQNames.add(qName);
            cls = SendMethodType.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "SMSMessage");
            cachedSerQNames.add(qName);
            cls = SMSMessage.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">endUssdRequest");
            cachedSerQNames.add(qName);
            cls = EndUssdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">handleUssdRequest");
            cachedSerQNames.add(qName);
            cls = HandleUssdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">handleUssdResponse");
            cachedSerQNames.add(qName);
            cls = HandleUssdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">makeUssdRequest");
            cachedSerQNames.add(qName);
            cls = MakeUssdRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">makeUssdResponse");
            cachedSerQNames.add(qName);
            cls = MakeUssdResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">notifyUssdEndRequest");
            cachedSerQNames.add(qName);
            cls = NotifyUssdEndRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">ussdContinueRequest");
            cachedSerQNames.add(qName);
            cls = UssdContinueRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">ussdContinueResponse");
            cachedSerQNames.add(qName);
            cls = UssdContinueResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "EndReason");
            cachedSerQNames.add(qName);
            cls = EndReason.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "UssdArray");
            cachedSerQNames.add(qName);
            cls = UssdArray.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">getPushDeliveryStatusRequest");
            cachedSerQNames.add(qName);
            cls = GetPushDeliveryStatusRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">getPushDeliveryStatusResponse");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation[].class;
            cachedSerClasses.add(cls);
            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "DeliveryInformation");
            qName2 = new javax.xml.namespace.QName("", "item");
            cachedSerFactories.add(new org.apache.axis.encoding.ser.ArraySerializerFactory(qName, qName2));
            cachedDeserFactories.add(new org.apache.axis.encoding.ser.ArrayDeserializerFactory());

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">notifyPushDeliveryReceiptRequest");
            cachedSerQNames.add(qName);
            cls = NotifyPushDeliveryReceiptRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">sendPushRequest");
            cachedSerQNames.add(qName);
            cls = SendPushRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">sendPushResponse");
            cachedSerQNames.add(qName);
            cls = SendPushResponse.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "DeliveryInformation");
            cachedSerQNames.add(qName);
            cls = DeliveryInformation.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "DeliveryStatus");
            cachedSerQNames.add(qName);
            cls = DeliveryStatus.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(enumsf);
            cachedDeserFactories.add(enumdf);

    }

    private static void _initOperationDesc1(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APRegistration");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APRegistrationReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APRegistrationReq"), APRegistrationReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APRegistrationRsp"));
        oper.setReturnClass(APRegistrationRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APRegistrationRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APStatusRep");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APStatusRepReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APStatusRepReq"), APStatusRepReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APStatusRepRsp"));
        oper.setReturnClass(APStatusRepRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APStatusRepRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APLogOut");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APLogOutReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APLogOutReq"), APLogOutReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APLogOutRsp"));
        oper.setReturnClass(APLogOutRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APLogOutRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PauseAP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "PauseAPReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">PauseAPReq"), PauseAPReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">PauseAPRsp"));
        oper.setReturnClass(PauseAPRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "PauseAPRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RecoveryAP");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "RecoveryAPReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">RecoveryAPReq"), RecoveryAPReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">RecoveryAPRsp"));
        oper.setReturnClass(RecoveryAPRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "RecoveryAPRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APSvcAuthentic");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APSvcAuthenticReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcAuthenticReq"), APSvcAuthenticReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcAuthenticRsp"));
        oper.setReturnClass(APSvcAuthenticRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APSvcAuthenticRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APSvcPerfCmd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APSvcPerfCmdReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcPerfCmdReq"), APSvcPerfCmdReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APSvcAlarm");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "AlarmReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">AlarmReq"), AlarmReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">AlarmRsp"));
        oper.setReturnClass(AlarmRsp.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "AlarmRsp"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("APSvcPerfReport");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", "APSvcPerfReportReq"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ap", ">APSvcPerfReportReq"), APSvcPerfReportReq.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("startNotification");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", "startNotificationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", ">startNotificationRequest"), StartNotificationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[9] = oper;

    }

    private static void _initOperationDesc2(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("stopNotification");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", "stopNotificationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/notification", ">stopNotificationRequest"), StopNotificationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendSms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "sendSmsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">sendSmsRequest"), SendSmsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">sendSmsResponse"));
        oper.setReturnClass(SendSmsResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "sendSmsResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifySmsDeliveryStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "notifySmsDeliveryStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">notifySmsDeliveryStatusRequest"), NotifySmsDeliveryStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetReceivedSms");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "GetReceivedSmsRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetReceivedSmsRequest"), GetReceivedSmsRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetReceivedSmsResponse"));
        oper.setReturnClass(SMSMessage[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "GetReceivedSmsResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetSmsDeliveryStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "GetSmsDeliveryStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetSmsDeliveryStatusRequest"), GetSmsDeliveryStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">GetSmsDeliveryStatusResponse"));
        oper.setReturnClass(DeliveryInformation[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "GetSmsDeliveryStatusResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifySmsReception");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", "notifySmsReceptionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/sms", ">notifySmsReceptionRequest"), NotifySmsReceptionRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendMessage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "sendMessageRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">sendMessageRequest"), SendMessageRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">sendMessageResponse"));
        oper.setReturnClass(SendMessageResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "sendMessageResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMessageDeliveryStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getMessageDeliveryStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageDeliveryStatusRequest"), GetMessageDeliveryStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageDeliveryStatusResponse"));
        oper.setReturnClass(DeliveryInformation[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getMessageDeliveryStatusResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getReceivedMessages");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getReceivedMessagesRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getReceivedMessagesRequest"), GetReceivedMessagesRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getReceivedMessagesResponse"));
        oper.setReturnClass(MessageReference[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getReceivedMessagesResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getMessage");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getMessageRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageRequest"), GetMessageRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">getMessageResponse"));
        oper.setReturnClass(GetMessageResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "getMessageResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[19] = oper;

    }

    private static void _initOperationDesc3(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifyMessageReception");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "notifyMessageReceptionRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">notifyMessageReceptionRequest"), NotifyMessageReceptionRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifyMessageDeliveryReceipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", "notifyMessageDeliveryReceiptRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/mms", ">notifyMessageDeliveryReceiptRequest"), NotifyMessageDeliveryReceiptRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocation");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "getLocationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationRequest"), GetLocationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationResponse"));
        oper.setReturnClass(GetLocationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "getLocationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[22] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getLocationForGroup");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "getLocationForGroupRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationForGroupRequest"), GetLocationForGroupRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">getLocationForGroupResponse"));
        oper.setReturnClass(LocationData[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "getLocationForGroupResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[23] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("startPeriodicNotification");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "startPeriodicNotificationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">startPeriodicNotificationRequest"), StartPeriodicNotificationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">startPeriodicNotificationResponse"));
        oper.setReturnClass(StartPeriodicNotificationResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "startPeriodicNotificationResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[24] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("EndNotification");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "EndNotificationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">EndNotificationRequest"), EndNotificationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[25] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LocationNotification");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationNotificationRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationNotificationRequest"), LocationNotificationRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[26] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LocationError");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationErrorRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationErrorRequest"), LocationErrorRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[27] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("LocationEnd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/location", "LocationEndRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/location", ">LocationEndRequest"), LocationEndRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[28] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("sendPush");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "sendPushRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">sendPushRequest"), SendPushRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">sendPushResponse"));
        oper.setReturnClass(SendPushResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "sendPushResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[29] = oper;

    }

    private static void _initOperationDesc4(){
        org.apache.axis.description.OperationDesc oper;
        org.apache.axis.description.ParameterDesc param;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("getPushDeliveryStatus");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "getPushDeliveryStatusRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">getPushDeliveryStatusRequest"), GetPushDeliveryStatusRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">getPushDeliveryStatusResponse"));
        oper.setReturnClass(DeliveryInformation[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "getPushDeliveryStatusResponse"));
        param = oper.getReturnParamDesc();
        param.setItemQName(new javax.xml.namespace.QName("", "item"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[30] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifyPushDeliveryReceipt");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", "notifyPushDeliveryReceiptRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/wap", ">notifyPushDeliveryReceiptRequest"), NotifyPushDeliveryReceiptRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[31] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("makeUssd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "makeUssdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">makeUssdRequest"), MakeUssdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">makeUssdResponse"));
        oper.setReturnClass(MakeUssdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "makeUssdResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[32] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("handleUssd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "handleUssdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">handleUssdRequest"), HandleUssdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">handleUssdResponse"));
        oper.setReturnClass(HandleUssdResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "handleUssdResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[33] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ussdContinue");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "ussdContinueRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">ussdContinueRequest"), UssdContinueRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">ussdContinueResponse"));
        oper.setReturnClass(UssdContinueResponse.class);
        oper.setReturnQName(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "ussdContinueResponse"));
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[34] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("endUssd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "endUssdRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">endUssdRequest"), EndUssdRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[35] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("notifyUssdEnd");
        param = new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", "notifyUssdEndRequest"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.csapi.org/schema/ussd", ">notifyUssdEndRequest"), NotifyUssdEndRequest.class, false, false);
        oper.addParameter(param);
        oper.setReturnType(org.apache.axis.encoding.XMLType.AXIS_VOID);
        oper.setStyle(org.apache.axis.constants.Style.DOCUMENT);
        oper.setUse(org.apache.axis.constants.Use.LITERAL);
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      "ServiceException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "ServiceException"),
                      true
                     ));
        oper.addFault(new org.apache.axis.description.FaultDesc(
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      "PolicyException",
                      new javax.xml.namespace.QName("http://www.csapi.org/schema/common/v2_0", "PolicyException"),
                      true
                     ));
        _operations[36] = oper;

    }

    protected org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call = super._createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                String key = (String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setEncodingStyle(null);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        Class cls = (Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        Object x = cachedSerFactories.get(i);
                        if (x instanceof Class) {
                            Class sf = (Class)
                                 cachedSerFactories.get(i);
                            Class df = (Class)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                        else if (x instanceof javax.xml.rpc.encoding.SerializerFactory) {
                            org.apache.axis.encoding.SerializerFactory sf = (org.apache.axis.encoding.SerializerFactory)
                                 cachedSerFactories.get(i);
                            org.apache.axis.encoding.DeserializerFactory df = (org.apache.axis.encoding.DeserializerFactory)
                                 cachedDeserFactories.get(i);
                            _call.registerTypeMapping(cls, qName, sf, df, false);
                        }
                    }
                }
            }
            return _call;
        }
        catch (Throwable _t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", _t);
        }
    }

    public APRegistrationRsp APRegistration(APRegistrationReq APRegistrationReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APRegistration");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APRegistration"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APRegistrationReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (APRegistrationRsp) _resp;
            } catch (Exception _exception) {
                return (APRegistrationRsp) org.apache.axis.utils.JavaUtils.convert(_resp, APRegistrationRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public APStatusRepRsp APStatusRep(APStatusRepReq APStatusRepReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APStatusRep");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APStatusRep"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APStatusRepReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (APStatusRepRsp) _resp;
            } catch (Exception _exception) {
                return (APStatusRepRsp) org.apache.axis.utils.JavaUtils.convert(_resp, APStatusRepRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public APLogOutRsp APLogOut(APLogOutReq APLogOutReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APLogOut");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APLogOut"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APLogOutReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (APLogOutRsp) _resp;
            } catch (Exception _exception) {
                return (APLogOutRsp) org.apache.axis.utils.JavaUtils.convert(_resp, APLogOutRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public PauseAPRsp pauseAP(PauseAPReq pauseAPReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/PauseAP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "PauseAP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {pauseAPReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (PauseAPRsp) _resp;
            } catch (Exception _exception) {
                return (PauseAPRsp) org.apache.axis.utils.JavaUtils.convert(_resp, PauseAPRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public RecoveryAPRsp recoveryAP(RecoveryAPReq recoveryAPReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/RecoveryAP");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "RecoveryAP"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {recoveryAPReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (RecoveryAPRsp) _resp;
            } catch (Exception _exception) {
                return (RecoveryAPRsp) org.apache.axis.utils.JavaUtils.convert(_resp, RecoveryAPRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public APSvcAuthenticRsp APSvcAuthentic(APSvcAuthenticReq APSvcAuthenticReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APSvcAuthentic");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APSvcAuthentic"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APSvcAuthenticReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (APSvcAuthenticRsp) _resp;
            } catch (Exception _exception) {
                return (APSvcAuthenticRsp) org.apache.axis.utils.JavaUtils.convert(_resp, APSvcAuthenticRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void APSvcPerfCmd(APSvcPerfCmdReq APSvcPerfCmdReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APSvcPerfCmd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APSvcPerfCmd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APSvcPerfCmdReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public AlarmRsp APSvcAlarm(AlarmReq alarmReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APSvcAlarm");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APSvcAlarm"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {alarmReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (AlarmRsp) _resp;
            } catch (Exception _exception) {
                return (AlarmRsp) org.apache.axis.utils.JavaUtils.convert(_resp, AlarmRsp.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void APSvcPerfReport(APSvcPerfReportReq APSvcPerfReportReq) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/APSvcPerfReport");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "APSvcPerfReport"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {APSvcPerfReportReq});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void startNotification(StartNotificationRequest startNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/startNotification");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "startNotification"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {startNotificationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void stopNotification(StopNotificationRequest stopNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/stopNotification");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "stopNotification"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {stopNotificationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public SendSmsResponse sendSms(SendSmsRequest sendSmsRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/sendSms");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "sendSms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sendSmsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SendSmsResponse) _resp;
            } catch (Exception _exception) {
                return (SendSmsResponse) org.apache.axis.utils.JavaUtils.convert(_resp, SendSmsResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifySmsDeliveryStatus(NotifySmsDeliveryStatusRequest notifySmsDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifySmsDeliveryStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifySmsDeliveryStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifySmsDeliveryStatusRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public SMSMessage[] getReceivedSms(GetReceivedSmsRequest getReceivedSmsRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/GetReceivedSms");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetReceivedSms"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getReceivedSmsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SMSMessage[]) _resp;
            } catch (Exception _exception) {
                return (SMSMessage[]) org.apache.axis.utils.JavaUtils.convert(_resp, SMSMessage[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public DeliveryInformation[] getSmsDeliveryStatus(GetSmsDeliveryStatusRequest getSmsDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/GetSmsDeliveryStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "GetSmsDeliveryStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getSmsDeliveryStatusRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (DeliveryInformation[]) _resp;
            } catch (Exception _exception) {
                return (DeliveryInformation[]) org.apache.axis.utils.JavaUtils.convert(_resp, DeliveryInformation[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifySmsReception(NotifySmsReceptionRequest notifySmsReceptionRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifySmsReception");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifySmsReception"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifySmsReceptionRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/sendMessage");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "sendMessage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sendMessageRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SendMessageResponse) _resp;
            } catch (Exception _exception) {
                return (SendMessageResponse) org.apache.axis.utils.JavaUtils.convert(_resp, SendMessageResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public DeliveryInformation[] getMessageDeliveryStatus(GetMessageDeliveryStatusRequest getMessageDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getMessageDeliveryStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getMessageDeliveryStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getMessageDeliveryStatusRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (DeliveryInformation[]) _resp;
            } catch (Exception _exception) {
                return (DeliveryInformation[]) org.apache.axis.utils.JavaUtils.convert(_resp, DeliveryInformation[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public MessageReference[] getReceivedMessages(GetReceivedMessagesRequest getReceivedMessagesRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getReceivedMessages");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getReceivedMessages"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getReceivedMessagesRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MessageReference[]) _resp;
            } catch (Exception _exception) {
                return (MessageReference[]) org.apache.axis.utils.JavaUtils.convert(_resp, MessageReference[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public GetMessageResponse getMessage(GetMessageRequest getMessageRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getMessage");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getMessage"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getMessageRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetMessageResponse) _resp;
            } catch (Exception _exception) {
                return (GetMessageResponse) org.apache.axis.utils.JavaUtils.convert(_resp, GetMessageResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifyMessageReception(NotifyMessageReceptionRequest notifyMessageReceptionRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifyMessageReception");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifyMessageReception"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifyMessageReceptionRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifyMessageDeliveryReceipt(NotifyMessageDeliveryReceiptRequest notifyMessageDeliveryReceiptRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifyMessageDeliveryReceipt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifyMessageDeliveryReceipt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifyMessageDeliveryReceiptRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public GetLocationResponse getLocation(GetLocationRequest getLocationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getLocation");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLocation"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getLocationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (GetLocationResponse) _resp;
            } catch (Exception _exception) {
                return (GetLocationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, GetLocationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public LocationData[] getLocationForGroup(GetLocationForGroupRequest getLocationForGroupRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[23]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getLocationForGroup");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getLocationForGroup"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getLocationForGroupRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (LocationData[]) _resp;
            } catch (Exception _exception) {
                return (LocationData[]) org.apache.axis.utils.JavaUtils.convert(_resp, LocationData[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public StartPeriodicNotificationResponse startPeriodicNotification(StartPeriodicNotificationRequest startPeriodicNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[24]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/startPeriodicNotification");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "startPeriodicNotification"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {startPeriodicNotificationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (StartPeriodicNotificationResponse) _resp;
            } catch (Exception _exception) {
                return (StartPeriodicNotificationResponse) org.apache.axis.utils.JavaUtils.convert(_resp, StartPeriodicNotificationResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void endNotification(EndNotificationRequest endNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[25]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/EndNotification");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "EndNotification"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {endNotificationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void locationNotification(LocationNotificationRequest locationNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[26]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/LocationNotification");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LocationNotification"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {locationNotificationRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void locationError(LocationErrorRequest locationErrorRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[27]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/LocationError");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LocationError"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {locationErrorRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void locationEnd(LocationEndRequest locationEndRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[28]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/LocationEnd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "LocationEnd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {locationEndRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public SendPushResponse sendPush(SendPushRequest sendPushRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[29]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/sendPush");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "sendPush"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {sendPushRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (SendPushResponse) _resp;
            } catch (Exception _exception) {
                return (SendPushResponse) org.apache.axis.utils.JavaUtils.convert(_resp, SendPushResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public DeliveryInformation[] getPushDeliveryStatus(GetPushDeliveryStatusRequest getPushDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[30]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/getPushDeliveryStatus");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "getPushDeliveryStatus"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {getPushDeliveryStatusRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (DeliveryInformation[]) _resp;
            } catch (Exception _exception) {
                return (DeliveryInformation[]) org.apache.axis.utils.JavaUtils.convert(_resp, DeliveryInformation[].class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifyPushDeliveryReceipt(NotifyPushDeliveryReceiptRequest notifyPushDeliveryReceiptRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[31]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifyPushDeliveryReceipt");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifyPushDeliveryReceipt"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifyPushDeliveryReceiptRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public MakeUssdResponse makeUssd(MakeUssdRequest makeUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[32]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/makeUssd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "makeUssd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {makeUssdRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (MakeUssdResponse) _resp;
            } catch (Exception _exception) {
                return (MakeUssdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, MakeUssdResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public HandleUssdResponse handleUssd(HandleUssdRequest handleUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[33]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/handleUssd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "handleUssd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {handleUssdRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (HandleUssdResponse) _resp;
            } catch (Exception _exception) {
                return (HandleUssdResponse) org.apache.axis.utils.JavaUtils.convert(_resp, HandleUssdResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public UssdContinueResponse ussdContinue(UssdContinueRequest ussdContinueRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[34]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/ussdContinue");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "ussdContinue"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {ussdContinueRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (UssdContinueResponse) _resp;
            } catch (Exception _exception) {
                return (UssdContinueResponse) org.apache.axis.utils.JavaUtils.convert(_resp, UssdContinueResponse.class);
            }
        }
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void endUssd(EndUssdRequest endUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[35]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/endUssd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "endUssd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {endUssdRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

    public void notifyUssdEnd(NotifyUssdEndRequest notifyUssdEndRequest) throws java.rmi.RemoteException, ServiceException, PolicyException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[36]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://www.csapi.org/service/notifyUssdEnd");
        _call.setEncodingStyle(null);
        _call.setProperty(org.apache.axis.client.Call.SEND_TYPE_ATTR, Boolean.FALSE);
        _call.setProperty(org.apache.axis.AxisEngine.PROP_DOMULTIREFS, Boolean.FALSE);
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("", "notifyUssdEnd"));

        setRequestHeaders(_call);
        setAttachments(_call);
 try {        Object _resp = _call.invoke(new Object[] {notifyUssdEndRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        extractAttachments(_call);
  } catch (org.apache.axis.AxisFault axisFaultException) {
    if (axisFaultException.detail != null) {
        if (axisFaultException.detail instanceof java.rmi.RemoteException) {
              throw (java.rmi.RemoteException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof ServiceException) {
              throw (ServiceException) axisFaultException.detail;
         }
        if (axisFaultException.detail instanceof PolicyException) {
              throw (PolicyException) axisFaultException.detail;
         }
   }
  throw axisFaultException;
}
    }

}
