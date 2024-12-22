package org.fsc.saas.project.common.constant;

/**
 * ClassName:RedisKeyConstant
 * Package:org.fsc.saas.project.common.constant
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 13:40
 * @Version: v1.0
 */
public class RedisKeyConstant {

    /**
     * 短链接跳转key
     */
    public static final String GOTO_SHORT_LINK_KEY = "short-link_goto_%s";

    /**
     * 短链接空值跳转
     */
    public static final String GOTO_IS_NULL_SHORT_LINK_KEY = "short-link_is-null_goto_%s";


    /**
     * 短链接跳转锁前缀 key
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link_lock_goto_%s";


}
