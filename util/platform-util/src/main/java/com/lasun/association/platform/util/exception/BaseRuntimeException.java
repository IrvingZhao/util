package com.lasun.association.platform.util.exception;

/**
 * 基础异常
 * @author 赵嘉楠
 */
public abstract class BaseRuntimeException extends RuntimeException {

    public BaseRuntimeException(String message, Throwable cause, String... params) {
        super(String.format(message, params), cause);
    }
}
