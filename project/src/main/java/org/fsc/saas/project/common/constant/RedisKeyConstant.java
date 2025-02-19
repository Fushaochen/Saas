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
    public static final String GOTO_SHORT_LINK_KEY = "short-link:goto:%s";

    /**
     * 短链接空值跳转
     */
    public static final String GOTO_IS_NULL_SHORT_LINK_KEY = "short-link:is-null:goto_%s";

    /**
     * 短链接跳转锁前缀 key
     */
    public static final String LOCK_GOTO_SHORT_LINK_KEY = "short-link:lock:goto:%s";


    /**
     * 短链接修改分组 ID 锁前缀 Key
     */
    public static final String LOCK_GID_UPDATE_KEY = "short-link:lock:update-gid:%s";

    /**
     * 短链接延迟队列消费统计 Key
     */
    public static final String DELAY_QUEUE_STATS_KEY = "short-link:delay-queue:stats";

    /**
     * 短链接统计判断是否新用户缓存标识
     */
    public static final String SHORT_LINK_STATS_UV_KEY = "short-link:stats:uv:";

    /**
     * 短链接统计判断是否新 IP 缓存标识
     */
    public static final String SHORT_LINK_STATS_UIP_KEY = "short-link:stats:uip:";


    public static final String SHORT_LINK_STATS_STREAM_TOPIC_KEY = "short-link:stats-stream";


    public static final String SHORT_LINK_STATS_STREAM_GROUP_KEY = "short_link:stats-stream:only-group";


}
