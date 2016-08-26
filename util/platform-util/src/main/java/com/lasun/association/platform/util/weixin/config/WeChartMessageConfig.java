package com.lasun.association.platform.util.weixin.config;

import com.lasun.association.platform.util.weixin.annotations.WeChartMessage;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageFormat;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageRequestMethod;
import com.lasun.association.platform.util.weixin.message.BaseOutputMessage;

/**
 * Created by irving on 2016/8/12.
 */
public class WeChartMessageConfig {
    private final boolean isSecurity;
    private final WeChartMessageRequestMethod requestMethod;
    private final WeChartMessageFormat requestType;
    private final WeChartMessageFormat responseType;

    public WeChartMessageConfig(BaseOutputMessage outputMessage) {
        WeChartMessage weChartMessage = outputMessage.getClass().getAnnotation(WeChartMessage.class);
        if (weChartMessage == null) {
            isSecurity = false;
            requestMethod = WeChartMessageRequestMethod.GET;
            requestType = WeChartMessageFormat.FORM;
            responseType = WeChartMessageFormat.JSON;
        } else {
            isSecurity = weChartMessage.isSecurity();
            requestMethod = weChartMessage.requestMethod();
            requestType = weChartMessage.requestType();
            responseType = weChartMessage.responseType();
        }
    }

    public boolean isSecurity() {
        return isSecurity;
    }

    public WeChartMessageRequestMethod getRequestMethod() {
        return requestMethod;
    }

    public WeChartMessageFormat getRequestType() {
        return requestType;
    }

    public WeChartMessageFormat getResponseType() {
        return responseType;
    }
}
