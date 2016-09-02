package com.lasun.association.platform.util.weixin.config.impl;

import com.lasun.association.platform.util.property.Property;
import com.lasun.association.platform.util.weixin.config.WeChartConfig;
import com.lasun.association.platform.util.weixin.config.WeChartConfigFactory;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageSecurityType;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <p>通过properties文件配置微信参数</p>
 * <p>属性列表：</p>
 * <ul>
 *     <li>wx.{name}.appId</li>
 *     <li>wx.{name}.appSecurity</li>
 *     <li>wx.{name}.securityToken</li>
 *     <li>wx.{name}.encodingAesKey</li>
 *     <li>wx.{name}.messageType</li>
 * </ul>
 * <p>messageType取值范围：</p>
 * <ul>
 *     <li>CONTENT - 不加密</li>
 *     <li>CONTENT_SECURITY - 兼容模式，包含明文好和密文</li>
 *     <li>SECURITY - 加密模式，仅包含密文</li>
 * </ul>
 * <p>其中name值为配置名称，组件支持多个微信配置。</p>
 * <p>在调用微信工具类时，不传入name值，将调用name为default的配置</p>
 * <p>属性名区分大小写</p>
 *
 * @author 赵嘉楠
 */
public class PropertyWeChartConfigFactory implements WeChartConfigFactory{

    private final Map<String, WeChartConfig> weChartConfigCache = new HashMap<>();
    private final Pattern configMatcher=Pattern.compile("wx\\.(\\w*)\\.(\\w*)");

    public PropertyWeChartConfigFactory(){
    }

    public void loadWeChartConfigs(){
        Map<String,String> weChartConfig=Property.getKeyValues("wx\\.[\\w]*\\.(appId|appSecurity|securityToken|encodingAesKey|messageType){1,1}");
        weChartConfig.entrySet().forEach((item)->{
            String key=item.getKey();
            Matcher matcher=configMatcher.matcher(key);
            String name=matcher.group(1);
            WeChartConfig config=weChartConfigCache.get(name);
            if(config==null){
                config=new WeChartConfig();
                weChartConfigCache.put(name,config);
            }
            switch (matcher.group(2)){
                case "appId":config.setAppId(item.getValue());break;
                case "appSecurity":config.setAppSecurity(item.getValue());break;
                case "securityToken":config.setSecurityToken(item.getValue());break;
                case "encodingAesKey":config.setEncodingAesKey(item.getValue());break;
                case "messageType":config.setMessageType(WeChartMessageSecurityType.valueOf(item.getValue()));break;
            }
        });
    }

    @Override
    public WeChartConfig getWeChartConfig() {
        return getWeChartConfig("default");
    }

    @Override
    public WeChartConfig getWeChartConfig(String name) {
        return weChartConfigCache.get(name);
    }

}
