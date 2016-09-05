package com.lasun.association.platform.util.weixin.config.impl;

import com.lasun.association.platform.util.weixin.config.WeChartTokenFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by irving on 2016/9/5.
 */
public class JavaMemeryWeChartTokenFactory implements WeChartTokenFactory {

    private Map<String,String> tokens=new HashMap<>();

    @Override
    public String getAccessToken() {
        return null;
    }

    @Override
    public String getAccessToken(String name) {
        return null;
    }

    @Override
    public void refreshAccessToken(String name) {

    }

}
