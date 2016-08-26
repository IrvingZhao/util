package com.lasun.association.platform.util.exception;

/**
 * 序列化异常
 *
 * @author 赵嘉楠
 */
public class SerialException extends BaseRuntimeException {
    public SerialException(String message, Throwable cause, String... params) {
        super(message, cause, params);
    }

    public SerialException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerialException(Throwable cause) {
        super("", cause);
    }
}
