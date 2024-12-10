package org.fsc.saas.admin.dto.req;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.fsc.saas.admin.serialize.PhoneDesensitizationSerializer;

/**
 * ClassName:UserRegisterReqDTO
 * Package:org.fsc.saas.admin.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/10 - 20:26
 * @Version: v1.0
 */
@Data
public class UserRegisterReqDTO {
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
