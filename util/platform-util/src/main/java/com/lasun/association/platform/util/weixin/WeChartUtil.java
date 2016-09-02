package com.lasun.association.platform.util.weixin;

import com.lasun.association.platform.util.weixin.config.WeChartConfigFactory;
import com.lasun.association.platform.util.weixin.config.WeChartTokenFactory;

/**
 * 微信消息工具类
 */
public class WeChartUtil {

    private WeChartConfigFactory weChartConfigFactory;

    private WeChartTokenFactory weChartTokenFactory;

    public void registWeChartConfigFactory(WeChartConfigFactory weChartConfigFactory) {
        this.weChartConfigFactory = weChartConfigFactory;
    }

    public void registWeChartTokenFactory(WeChartTokenFactory weChartTokenFactory) {
        this.weChartTokenFactory = weChartTokenFactory;
    }

}
