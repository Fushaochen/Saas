package org.fsc.saas.admin.dto.resp;

/**
 * ClassName:UserRespDTO
 * Package:org.fsc.saas.admin.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 10:53
 * @Version: v1.0
 */

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import org.fsc.saas.admin.serialize.PhoneDesensitizationSerializer;

import java.util.Date;

@Data
public class UserRespDTO {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
