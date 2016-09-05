package com.lasun.association.platform.util.remote.http;

import com.lasun.association.platform.util.remote.http.enums.HttpMethod;
import com.lasun.association.platform.util.remote.http.enums.RequestType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 请求消息
 *
 * @author 赵嘉楠
 */
public class HttpMessage {
    private String url;
    private Map<String, Object> requestParams;
    private HttpMethod method = HttpMethod.GET;
    private RequestType requestType = RequestType.NORMAL;
    private InputStream requestStream;

    private int resultCode;
    private Map<String, String> responseHead;
    private InputStream responseStream;

    /**
     * 构建消息，默认以GET方式提交，NORMAL提交形式
     *
     * @param url 请求地址
     */
    public HttpMessage(String url) {
        this(url, HttpMethod.GET, RequestType.NORMAL);
    }

    /**
     * 构建消息
     *
     * @param url         请求地址
     * @param method      请求提交方法
     * @param requestType 请求提交形式
     */
    public HttpMessage(String url, HttpMethod method, RequestType requestType) {
        this(url, method, requestType, new HashMap<>());
    }

    /**
     * @param url           请求地址
     * @param method        请求提交方法
     * @param requestType   请求提交形式
     * @param requestParams 请求提交参数
     */
    public HttpMessage(String url, HttpMethod method, RequestType requestType, Map<String, Object> requestParams) {
        this.url = url;
        this.method = method;
        this.requestType = requestType;
        this.requestParams = requestParams;
    }

    /**
     * 添加请求参数,当请求以流的形式提交时，请求参数无效
     *
     * @param key   参数名
     * @param value 参数值
     */
    public HttpMessage addRequestParam(String key, Object value) {
        requestParams.put(key, value);
        return this;
    }

    /**
     * 添加多个请求参数
     *
     * @param params 请求参数
     */
    public HttpMessage addRequestParams(Map<String, Object> params) {
        requestParams.putAll(params);
        return this;
    }

    /**
     * 设置请求流，只有在流请求的形式才会使用
     *
     * @param inputStream 流提交
     */
    public HttpMessage setRequestStream(InputStream inputStream) {
        this.requestStream = inputStream;
        return this;
    }

    /**
     * 设置请求流对象，默认将字符串内容转为ByteArrayInputStream
     *
     * @param content 请求内容
     */
    public HttpMessage setRequestStream(String content) {
        this.requestStream = new ByteArrayInputStream(content.getBytes());
        return this;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    public void setRequestType(RequestType requestType) {
        this.requestType = requestType;
    }

    public String getUrl() {
        return url;
    }

    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public RequestType getRequestType() {
        return requestType;
    }

    public InputStream getRequestStream() {
        return requestStream;
    }

    public int getResultCode() {
        return resultCode;
    }

    protected void setResultCode(int resultCode) {
        this.resultCode = resultCode;
    }

    public Map<String, String> getResponseHead() {
        return responseHead;
    }

    protected void setResponseHead(Map<String, String> responseHead) {
        this.responseHead = responseHead;
    }

    public InputStream getResponseStream() {
        return responseStream;
    }

    protected void setResponseStream(InputStream responseStream) {
        this.responseStream = responseStream;
    }
}
