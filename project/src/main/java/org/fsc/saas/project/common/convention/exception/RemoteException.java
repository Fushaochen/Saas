package org.fsc.saas.admin.common.convention.exception;

import org.fsc.saas.admin.common.convention.errorcode.BaseErrorCode;
import org.fsc.saas.admin.common.convention.errorcode.IErrorCode;

/**
 * ClassName:RemoteException
 * Package:org.fsc.saas.admin.common.convention.exception
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 13:02
 * @Version: v1.0
 */
public class RemoteException extends AbstractException{
    public RemoteException(String message) {
        this(message, null, BaseErrorCode.REMOTE_ERROR);
    }

    public RemoteException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public RemoteException(String message, Throwable throwable, IErrorCode errorCode) {
        super(message, throwable, errorCode);
    }

    @Override
    public String toString() {
        return "RemoteException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
