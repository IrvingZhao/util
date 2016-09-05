package com.lasun.association.platform.util.weixin.config;

/**
 * Created by irving on 2016/9/2.
 */
public interface WeChartConfigFactory extends WeChartFactory{
    WeChartConfig getWeChartConfig();
    WeChartConfig getWeChartConfig(String name);
}
