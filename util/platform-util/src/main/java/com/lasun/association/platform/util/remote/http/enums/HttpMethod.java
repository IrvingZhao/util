package com.lasun.association.platform.util.remote.http.enums;

import org.apache.hc.client5.http.methods.*;

/**
 * http/https提交请求方法
 *
 * @author 赵嘉楠
 */
public enum HttpMethod {
    OPTIONS {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpOptions.class;
        }
    },
    GET {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpGet.class;
        }
    }, HEAD {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpHead.class;
        }
    }, POST {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpPost.class;
        }
    }, PUT {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpPut.class;
        }
    }, DELETE {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpDelete.class;
        }
    }, TRACE {
        public Class<? extends HttpRequestBase> getMethodClass() {
            return HttpTrace.class;
        }
    };

    /**
     * 获得请求所对应的请求类
     */
    public abstract Class<? extends HttpRequestBase> getMethodClass();
}
