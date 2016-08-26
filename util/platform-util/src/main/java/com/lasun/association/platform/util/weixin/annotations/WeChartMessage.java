package com.lasun.association.platform.util.weixin.annotations;

import com.lasun.association.platform.util.weixin.enums.WeChartMessageFormat;
import com.lasun.association.platform.util.weixin.enums.WeChartMessageRequestMethod;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 微信消息配置
 *
 * @author 赵嘉楠
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WeChartMessage {
    boolean isSecurity() default false;

    WeChartMessageRequestMethod requestMethod() default WeChartMessageRequestMethod.GET;

    WeChartMessageFormat requestType() default WeChartMessageFormat.FORM;

    WeChartMessageFormat responseType() default WeChartMessageFormat.JSON;
}
