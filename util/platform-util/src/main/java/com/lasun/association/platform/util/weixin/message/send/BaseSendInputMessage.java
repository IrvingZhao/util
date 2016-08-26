package com.lasun.association.platform.util.weixin.message.send;

import com.lasun.association.platform.util.weixin.message.BaseInputMessage;
import com.lasun.association.platform.util.weixin.message.BaseOutputMessage;

/**
 * Created by irving on 2016/8/15.
 */
public abstract class BaseSendInputMessage extends BaseInputMessage {
    private String errcode;
    private String errmsg;

    public abstract Class<? extends BaseSendOutputMessage> getOutputMessageClass();


    public String getErrcode() {
        return errcode;
    }

    public void setErrcode(String errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
