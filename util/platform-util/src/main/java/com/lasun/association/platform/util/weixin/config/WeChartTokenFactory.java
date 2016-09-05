package com.lasun.association.platform.util.weixin.config;

/**
 * Created by irving on 2016/9/2.
 */
public interface WeChartTokenFactory extends WeChartFactory{
    String getAccessToken();
    String getAccessToken(String name);
    void refreshAccessToken(String name);
}
