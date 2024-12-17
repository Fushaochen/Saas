package org.fsc.saas.project.common.convention.exception;


import org.fsc.saas.project.common.convention.errorcode.BaseErrorCode;
import org.fsc.saas.project.common.convention.errorcode.IErrorCode;

import java.util.Optional;

/**
 * ClassName:ServiceException
 * Package:org.fsc.saas.admin.common.convention.exception
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 13:02
 * @Version: v1.0
 */
public class ServiceException extends AbstractException {

    public ServiceException(String message) {
        this(message, null, BaseErrorCode.SERVICE_ERROR);
    }

    public ServiceException(IErrorCode errorCode) {
        this(null, errorCode);
    }

    public ServiceException(String message, IErrorCode errorCode) {
        this(message, null, errorCode);
    }

    public ServiceException(String message, Throwable throwable, IErrorCode errorCode) {
        super(Optional.ofNullable(message).orElse(errorCode.message()), throwable, errorCode);
    }

    @Override
    public String toString() {
        return "ServiceException{" +
                "code='" + errorCode + "'," +
                "message='" + errorMessage + "'" +
                '}';
    }
}
