package org.fsc.saas.admin.dto.req;

import lombok.Data;

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
public class UserUpdateReqDTO {
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
