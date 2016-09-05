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
 * <p>属性名不区分大小写</p>
 *
 * @author 赵嘉楠
 */
public class PropertyWeChartConfigFactory implements WeChartConfigFactory{

    private final Map<String, WeChartConfig> weChartConfigCache = new HashMap<>();
    private final Pattern configMatcher=Pattern.compile("wx\\.(\\w*)\\.(\\w*)");

    public PropertyWeChartConfigFactory(){
    }

    public void loadWeChartConfigs(){
        Pattern pattern=Pattern.compile("wx\\.[\\w]*\\.(appId|appSecurity|securityToken|encodingAesKey|messageType){1,1}",Pattern.CASE_INSENSITIVE);
        Map<String,String> weChartConfig=Property.getKeyValues(pattern);
        weChartConfig.entrySet().forEach((item)->{
            String key=item.getKey();
            Matcher matcher=configMatcher.matcher(key);
            String name=matcher.group(1);
            String prop=matcher.group(2).toLowerCase();
            WeChartConfig config=weChartConfigCache.get(name);
            if(config==null){
                config=new WeChartConfig();
                weChartConfigCache.put(name,config);
            }
            if(prop.equals("appid")){
                config.setAppId(item.getValue());
            }else if(prop.equals("appsecurity")){
                config.setAppSecurity(item.getValue());
            }else if(prop.equals("securitytoken")){
                config.setSecurityToken(item.getValue());
            }else if(prop.equals("encodingaeskey")){
                config.setEncodingAesKey(item.getValue());
            }else if (prop.equals("messagetype")){
                config.setMessageType(WeChartMessageSecurityType.valueOf(item.getValue()));
            }
        });
        if(weChartConfigCache.size()==0){
            weChartConfigCache.put(DEFAULT_NAME,weChartConfigCache.entrySet().iterator().next().getValue());
        }
    }

    @Override
    public WeChartConfig getWeChartConfig() {
        return getWeChartConfig(DEFAULT_NAME);
    }

    @Override
    public WeChartConfig getWeChartConfig(String name) {
        return weChartConfigCache.get(name);
    }

}
