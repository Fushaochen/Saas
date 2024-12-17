package org.fsc.saas.project.common.convention.exception;

import lombok.Data;
import org.fsc.saas.project.common.convention.errorcode.IErrorCode;
import org.springframework.util.StringUtils;

import java.util.Optional;

/**
 * ClassName:AbstractException
 * Package:org.fsc.saas.admin.common.convention.exception
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 12:48
 * @Version: v1.0
 */
@Data
public abstract class AbstractException extends RuntimeException{

    public final String errorCode;

    public final String errorMessage;

    public AbstractException(String message, Throwable throwable, IErrorCode errorCode){
        super(message,throwable);
        this.errorCode = errorCode.code();
        this.errorMessage = Optional.ofNullable(StringUtils.hasLength(message) ? message : null).orElse(errorCode.message());
    }
}
