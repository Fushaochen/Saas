package org.fsc.saas.admin.dto.resp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * ClassName:UserLoginRespDTO
 * Package:org.fsc.saas.admin.dto.resp
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 11:01
 * @Version: v1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {


    /**
     * 用户Token
     */
    private String token;
}
