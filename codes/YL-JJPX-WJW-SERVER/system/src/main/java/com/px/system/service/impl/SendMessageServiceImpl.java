package com.px.system.service.impl;

import com.px.system.schema.common.v2_0.ServiceException;
import com.px.system.schema.sms.MessageFormat;
import com.px.system.schema.sms.SendMethodType;
import com.px.system.schema.sms.SendSmsRequest;
import com.px.system.schema.sms.SendSmsResponse;
import com.px.system.service.Cmcc_mas_wbs_PortType;
import com.px.system.service.SendMessageService;
import lombok.extern.slf4j.Slf4j;
import org.apache.axis.types.URI.MalformedURIException;
import org.springframework.stereotype.Service;

/**
 * @author 品讯科技
 * @date 2024-08
 * @PackageName:com.px.wjwtest.service.impl
 * @ClassName: SendMessageServiceImpl
 * @Description: TODO
 * @Version 1.0
 */

@Slf4j
@Service
public class SendMessageServiceImpl implements SendMessageService {

    @Override
    public Boolean sendMsg(String phone,String code){

        String url="http://211.103.8.117:8093/services/cmcc_mas_wbs";
        String ApplicationID="Wwjwksxt20230614";
        String[] DestinationAddresses={"tel:"+phone};
        String Message="您的验证码为"+code+"，有效期为3分钟，请确保是本人操作，不要把验证码泄露给其他人。";
        String ExtendCode="";
        try {
            Cmcc_mas_wbs_ServiceLocator cmcc_mas_wbs_ServiceLocator = new 	Cmcc_mas_wbs_ServiceLocator();
            // 设置 WebService 方式通信适配插件服务地址
            cmcc_mas_wbs_ServiceLocator.setcmcc_mas_wbsEndpointAddress(url);
            // 生成客户端访问接口
            try {
                Cmcc_mas_wbs_PortType cmcc_mas_wbs_PortType;
                cmcc_mas_wbs_PortType = cmcc_mas_wbs_ServiceLocator.getcmcc_mas_wbs();
                // 应用系统或插件请求发送的短消息	q`as
                SendSmsRequest sendSmsRequest = new SendSmsRequest();
                // 设置应用 ID 或插件的 ID
                sendSmsRequest.setApplicationID(ApplicationID);
                // 设置指示是否需要网络侧返回递交状态报告。若无，则不返回。True 表示需要网络侧返回递交状态报告，false 表示不需要网络侧返回递交状态报告
                sendSmsRequest.setDeliveryResultRequest(false);
                // 设置短消息要被发送到的地址。群发短消息的最大数量为 254

                org.apache.axis.types.URI[] mobile=new org.apache.axis.types.URI[DestinationAddresses.length];
                for (int i=0;i<DestinationAddresses.length;i++)
                {
                    try {
                        mobile[i]=new org.apache.axis.types.URI(DestinationAddresses[i]);

                        //System.out.println("手机号码："+mobile[i]);
                        sendSmsRequest.setDestinationAddresses(mobile);
                    } catch (MalformedURIException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }
                // 设置由该应用填写的内部扩展号码。MAS 服务器需自动补充为此业务分配的长服务号码
                sendSmsRequest.setExtendCode(ExtendCode);
                // 设置在短消息中发送的文本
                sendSmsRequest.setMessage(Message);
                // 设置消息编码类
                sendSmsRequest.setMessageFormat(MessageFormat.GB2312);
                // 设置发送消息选项
                sendSmsRequest.setSendMethod(SendMethodType.Normal);
                // 发送短消息（返回发送短消息响应）

//                System.out.println("sendSmsRequest:{");
//                System.out.println("ApplicationID："+sendSmsRequest.getApplicationID());
//                System.out.println("DestinationAddresses："+sendSmsRequest.getDestinationAddresses(0));
//                System.out.println("Message："+sendSmsRequest.getMessage());
//                System.out.println("ExtendCode："+sendSmsRequest.getExtendCode());
//                System.out.println("MessageFormat："+sendSmsRequest.getMessageFormat());
//                System.out.println("SendMethod："+sendSmsRequest.getSendMethod());
//                System.out.println("}");
                SendSmsResponse sendSmsResponse = cmcc_mas_wbs_PortType.sendSms(sendSmsRequest);
//                System.out.println("sendSmsResponse:{RequestIdentifier:"+sendSmsResponse.getRequestIdentifier()+"}");

            } catch (ServiceException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
                return false;
            }
        }catch (Exception e){
            log.error("发送消息发生异常：",e);
            return false;
        }


        return true;
    }
}
