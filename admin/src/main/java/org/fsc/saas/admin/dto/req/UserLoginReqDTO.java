package org.fsc.saas.admin.dto.req;

import lombok.Data;

/**
 * ClassName:UserLoginReqDTO
 * Package:org.fsc.saas.admin.dto.req
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 11:03
 * @Version: v1.0
 */
@Data
public class UserLoginReqDTO {


    private String username;

    private String password;
}
