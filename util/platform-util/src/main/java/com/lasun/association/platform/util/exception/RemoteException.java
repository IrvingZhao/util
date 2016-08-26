package com.lasun.association.platform.util.exception;

/**
 * http请求异常
 *
 * @author 赵嘉楠
 */
public class RemoteException extends BaseRuntimeException {
    public RemoteException(String message, Throwable cause, String... params) {
        super(message, cause, params);
    }

    public RemoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public RemoteException(Throwable cause) {
        super("", cause);
    }
}
