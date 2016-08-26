package com.lasun.association.platform.util.weixin.message;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lasun.association.platform.util.serial.SerialUtil;
import com.lasun.association.platform.util.weixin.config.WeChartMessageConfig;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageFormat;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by irving on 2016/8/12.
 */
public abstract class BaseOutputMessage extends BaseMessage {

    @JsonIgnore
    public abstract Class<? extends BaseInputMessage> getInputMessageClass();

    private final WeChartMessageConfig messageConfig;

    protected BaseOutputMessage() {
        messageConfig = new WeChartMessageConfig(this);
    }

    @JsonIgnore
    public String getSerialContent() {
        String result = null;
        if (messageConfig.getRequestType() == WeChartMessageFormat.JSON) {
            result = serialUtil.serial(this, SerialUtil.SerialType.JSON);
        } else if (messageConfig.getRequestType() == WeChartMessageFormat.XML) {
            result = serialUtil.serial(this, SerialUtil.SerialType.XML);
        }
        return result;
    }

    @JsonIgnore
    public WeChartMessageConfig getMessageConfig() {
        return messageConfig;
    }
}
