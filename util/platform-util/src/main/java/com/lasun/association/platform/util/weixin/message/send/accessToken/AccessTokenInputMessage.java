package com.lasun.association.platform.util.weixin.message.send.accessToken;

import com.lasun.association.platform.util.weixin.annotations.WeChartMessage;
import com.lasun.association.platform.util.weixin.message.BaseInputMessage;
import com.lasun.association.platform.util.weixin.message.BaseOutputMessage;
import com.lasun.association.platform.util.weixin.message.send.BaseSendInputMessage;
import com.lasun.association.platform.util.weixin.message.send.BaseSendOutputMessage;

/**
 * Created by irving on 2016/8/12.
 */
@WeChartMessage
public class AccessTokenInputMessage extends BaseSendInputMessage {

    private String access_token;
    private String expires_in;

    @Override
    public Class<? extends BaseSendOutputMessage> getOutputMessageClass() {
        return AccessTokenOutputMessage.class;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
}
