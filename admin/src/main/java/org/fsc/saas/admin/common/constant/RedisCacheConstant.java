package org.fsc.saas.admin.common.constant;

import org.springframework.stereotype.Component;

/**
 * ClassName:RedisCacheConstant
 * Package:org.fsc.saas.admin.common.constant
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/10 - 21:26
 * @Version: v1.0
 */
@Component
public class RedisCacheConstant {

    public static final String LOCK_USER_REGISTER_KEY = "short-link:lock_user-register:";


    public static final String LOCK_GROUP_CREATE_KEY = "short-link:lock_group-create:%s";


    /**
     * 用户登录缓存标识
     */
    public static final String USER_LOGIN_KEY = "short-link:login:";

}
