package org.fsc.saas.admin.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.enums.UserErrorCodeEnum;
import org.fsc.saas.admin.dto.resp.UserRespDTO;
import org.fsc.saas.admin.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UserController
 * Package:org.fsc.saas.admin.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/8 - 11:41
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/api/saas/v1/user/{username}")
    public Result<UserRespDTO> getUserByUsername(@PathVariable("username") String username){
        UserRespDTO result = userService.getUserByUsername(username);
        if(result == null){
            return new Result<UserRespDTO>().setCode(UserErrorCodeEnum.USER_NULL.code()).setMessage(UserErrorCodeEnum.USER_NULL.message());
        }
        return new Result<UserRespDTO>().setCode("0").setData(result);
    }
}
