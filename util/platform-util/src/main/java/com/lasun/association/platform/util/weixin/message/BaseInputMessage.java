package com.lasun.association.platform.util.weixin.message;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by irving on 2016/8/12.
 */
public abstract class BaseInputMessage {

    public abstract Class<? extends BaseOutputMessage> getOutputMessageClass();

}
