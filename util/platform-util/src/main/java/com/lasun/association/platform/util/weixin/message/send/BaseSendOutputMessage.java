package com.lasun.association.platform.util.weixin.message.send;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lasun.association.platform.util.weixin.message.BaseInputMessage;
import com.lasun.association.platform.util.weixin.message.BaseOutputMessage;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by irving on 2016/8/15.
 */
public abstract class BaseSendOutputMessage extends BaseOutputMessage {
    @JsonIgnore
    public abstract String getUrl();

    @JsonIgnore
    public abstract Class<? extends BaseSendInputMessage> getInputMessageClass();

    @JsonIgnore
    public Map<String, Object> getParamMap() {
        Map<String, Object> result = null;
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(this.getClass(), BaseSendOutputMessage.class);

            PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
            result = new HashMap<>(descriptors.length);
            for (PropertyDescriptor item : descriptors) {
                String name = item.getName();
                if (name.equals("url") || name.equals("inputMessageClass")) {
                    continue;
                }
                result.put(name, item.getReadMethod().invoke(this));
            }
        } catch (IntrospectionException | InvocationTargetException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return result;
    }
}
