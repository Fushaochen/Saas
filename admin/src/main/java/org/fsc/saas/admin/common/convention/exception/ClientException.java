package org.fsc.saas.admin.common.convention.exception;

import org.fsc.saas.admin.common.convention.errorcode.BaseErrorCode;
import org.fsc.saas.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName:ClientException
 * Package:org.fsc.saas.admin.common.convention.exception
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 13:02
 * @Version: v1.0
 */
public class ClientException extends AbstractException {

    public ClientException(IErrorCode errorCode) {
        this(null, null, errorCode);
    }

    public ClientException(String message) {
        this(message, null, BaseErrorCode.CLIENT_ERROR);
    }

    public ClientException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ClientException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ClientException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
