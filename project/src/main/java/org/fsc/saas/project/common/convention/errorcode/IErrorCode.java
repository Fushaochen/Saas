package org.fsc.saas.admin.common.convention.errorcode;

/**
 * ClassName:IErrorCode
 * Package:org.fsc.saas.admin.common.convention.errorcode
 * Description: 平台错误码
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 11:25
 * @Version: v1.0
 */
public interface IErrorCode {

    /**
     * 错误码
     */
    String code();

    /**
     * 错误信息
     */
    String message();
}
