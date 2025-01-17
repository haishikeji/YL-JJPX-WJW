/**
 * Cmcc_mas_wbs_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.px.system.service;

import com.px.system.schema.ap.*;
import com.px.system.schema.common.v2_0.PolicyException;
import com.px.system.schema.common.v2_0.ServiceException;
import com.px.system.schema.location.*;
import com.px.system.schema.mms.DeliveryInformation;
import com.px.system.schema.mms.*;
import com.px.system.schema.notification.StartNotificationRequest;
import com.px.system.schema.notification.StopNotificationRequest;
import com.px.system.schema.sms.*;
import com.px.system.schema.ussd.*;
import com.px.system.schema.wap.GetPushDeliveryStatusRequest;
import com.px.system.schema.wap.NotifyPushDeliveryReceiptRequest;
import com.px.system.schema.wap.SendPushRequest;
import com.px.system.schema.wap.SendPushResponse;

public interface Cmcc_mas_wbs_PortType extends java.rmi.Remote {
    public APRegistrationRsp APRegistration(APRegistrationReq APRegistrationReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public APStatusRepRsp APStatusRep(APStatusRepReq APStatusRepReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public APLogOutRsp APLogOut(APLogOutReq APLogOutReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public PauseAPRsp pauseAP(PauseAPReq pauseAPReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public RecoveryAPRsp recoveryAP(RecoveryAPReq recoveryAPReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public APSvcAuthenticRsp APSvcAuthentic(APSvcAuthenticReq APSvcAuthenticReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void APSvcPerfCmd(APSvcPerfCmdReq APSvcPerfCmdReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public AlarmRsp APSvcAlarm(AlarmReq alarmReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void APSvcPerfReport(APSvcPerfReportReq APSvcPerfReportReq) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void startNotification(StartNotificationRequest startNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void stopNotification(StopNotificationRequest stopNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public SendSmsResponse sendSms(SendSmsRequest sendSmsRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifySmsDeliveryStatus(NotifySmsDeliveryStatusRequest notifySmsDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public SMSMessage[] getReceivedSms(GetReceivedSmsRequest getReceivedSmsRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public DeliveryInformation[] getSmsDeliveryStatus(GetSmsDeliveryStatusRequest getSmsDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifySmsReception(NotifySmsReceptionRequest notifySmsReceptionRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public SendMessageResponse sendMessage(SendMessageRequest sendMessageRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public DeliveryInformation[] getMessageDeliveryStatus(GetMessageDeliveryStatusRequest getMessageDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public MessageReference[] getReceivedMessages(GetReceivedMessagesRequest getReceivedMessagesRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public GetMessageResponse getMessage(GetMessageRequest getMessageRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifyMessageReception(NotifyMessageReceptionRequest notifyMessageReceptionRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifyMessageDeliveryReceipt(NotifyMessageDeliveryReceiptRequest notifyMessageDeliveryReceiptRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public GetLocationResponse getLocation(GetLocationRequest getLocationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public LocationData[] getLocationForGroup(GetLocationForGroupRequest getLocationForGroupRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public StartPeriodicNotificationResponse startPeriodicNotification(StartPeriodicNotificationRequest startPeriodicNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void endNotification(EndNotificationRequest endNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void locationNotification(LocationNotificationRequest locationNotificationRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void locationError(LocationErrorRequest locationErrorRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void locationEnd(LocationEndRequest locationEndRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public SendPushResponse sendPush(SendPushRequest sendPushRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public DeliveryInformation[] getPushDeliveryStatus(GetPushDeliveryStatusRequest getPushDeliveryStatusRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifyPushDeliveryReceipt(NotifyPushDeliveryReceiptRequest notifyPushDeliveryReceiptRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public MakeUssdResponse makeUssd(MakeUssdRequest makeUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public HandleUssdResponse handleUssd(HandleUssdRequest handleUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public UssdContinueResponse ussdContinue(UssdContinueRequest ussdContinueRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void endUssd(EndUssdRequest endUssdRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
    public void notifyUssdEnd(NotifyUssdEndRequest notifyUssdEndRequest) throws java.rmi.RemoteException, ServiceException, PolicyException;
}
