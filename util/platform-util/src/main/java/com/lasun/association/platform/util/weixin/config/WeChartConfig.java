package com.lasun.association.platform.util.weixin.config;

import com.lasun.association.platform.util.weixin.enums.WeChartMessageSecurityType;

/**
 * 微信配置实体类
 *
 * @author 赵嘉楠
 */
public final class WeChartConfig {

    private String appId;
    private String appSecurity;
    private String securityToken;
    private String encodingAesKey;
    private WeChartMessageSecurityType messageType;

    public WeChartConfig(){}

    /**
     * 初始化微信配置
     *
     * @param appId
     * @param appSecurity
     * @param securityToken
     * @param encodingAesKey
     * @param messageType
     */
    public WeChartConfig(String appId, String appSecurity, String securityToken, String encodingAesKey, WeChartMessageSecurityType messageType) {
        this.appId = appId;
        this.appSecurity = appSecurity;
        this.securityToken = securityToken;
        this.encodingAesKey = encodingAesKey;
        this.messageType = messageType;
    }

    public String getAppId() {
        return appId;
    }

    public String getAppSecurity() {
        return appSecurity;
    }

    public String getSecurityToken() {
        return securityToken;
    }

    public String getEncodingAesKey() {
        return encodingAesKey;
    }

    public WeChartMessageSecurityType getMessageType() {
        return messageType;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setAppSecurity(String appSecurity) {
        this.appSecurity = appSecurity;
    }

    public void setSecurityToken(String securityToken) {
        this.securityToken = securityToken;
    }

    public void setEncodingAesKey(String encodingAesKey) {
        this.encodingAesKey = encodingAesKey;
    }

    public void setMessageType(WeChartMessageSecurityType messageType) {
        this.messageType = messageType;
    }
}
