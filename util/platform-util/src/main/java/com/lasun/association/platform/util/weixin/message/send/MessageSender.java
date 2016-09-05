package com.lasun.association.platform.util.weixin.message.send;

import com.lasun.association.platform.util.remote.http.HttpMessage;
import com.lasun.association.platform.util.remote.http.HttpUtil;
import com.lasun.association.platform.util.remote.http.enums.HttpMethod;
import com.lasun.association.platform.util.serial.SerialUtil;
import com.lasun.association.platform.util.weixin.config.WeChartMessageConfig;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageFormat;

import java.io.InputStream;

/**
 * Created by irving on 2016/9/5.
 */
public class MessageSender {
    private SerialUtil serialUtil = SerialUtil.getSerialUtil();
    private HttpUtil httpUtil = new HttpUtil();

    public BaseSendInputMessage sendMessage(BaseSendOutputMessage outputMessage) {
        WeChartMessageConfig messageConfig = outputMessage.getMessageConfig();
        HttpMessage httpMessage = new HttpMessage(outputMessage.getUrl());



        switch (messageConfig.getRequestMethod()) {
            case GET:
                httpMessage.setMethod(HttpMethod.GET);
                break;
            case POST:
                httpMessage.setMethod(HttpMethod.POST);
                break;
        }
        WeChartMessageFormat requestFormat = messageConfig.getRequestType();
        switch (requestFormat) {
            case FORM:
                httpMessage.addRequestParams(outputMessage.getParamMap());
                break;
            case XML:
                httpMessage.setRequestStream(serialUtil.serial(outputMessage, SerialUtil.SerialType.XML));
                break;
            case JSON:
                httpMessage.setRequestStream(serialUtil.serial(outputMessage, SerialUtil.SerialType.JSON));
                break;
        }
        httpUtil.sendMessage(httpMessage);
        InputStream responseStream = httpMessage.getResponseStream();
        SerialUtil.SerialType serialType = SerialUtil.SerialType.JSON;
        switch (messageConfig.getResponseType()) {
            case JSON:
                serialType = SerialUtil.SerialType.JSON;
                break;
            case XML:
                serialType = SerialUtil.SerialType.XML;
                break;
        }
        Class<? extends BaseSendInputMessage> outputClass = outputMessage.getInputMessageClass();
        BaseSendInputMessage result = serialUtil.parse(responseStream, outputClass, serialType);
        return result;
    }
}