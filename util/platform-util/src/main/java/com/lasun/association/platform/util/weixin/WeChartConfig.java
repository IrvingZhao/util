package com.lasun.association.platform.util.weixin;

import com.lasun.association.platform.util.property.Property;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageSecurityType;

/**
 * Created by irving on 2016/8/12.
 */
public class WeChartConfig {

    private final static WeChartConfigProps props=new WeChartConfigProps();

    static{
        props.appId= Property.get("wx.appid");
        props.appSecurity= Property.get("wx.appsecurity");
    }

    public static String getAppId() {
        return props.appId;
    }

    public static String getAppSecurity() {
        return props.appSecurity;
    }

    public static String getSecurityToken() {
        return props.securityToken;
    }

    public static String getEncodingAesKey() {
        return props.encodingAesKey;
    }

    public static WeChartMessageSecurityType getMessageType() {
        return props.messageType;
    }

    public static String getAccessToken() {
        return props.accessToken;
    }

    private static class WeChartConfigProps {
        protected String appId;
        protected String appSecurity;
        protected String securityToken;
        protected String encodingAesKey;
        protected WeChartMessageSecurityType messageType;
        protected String accessToken;
    }
}
