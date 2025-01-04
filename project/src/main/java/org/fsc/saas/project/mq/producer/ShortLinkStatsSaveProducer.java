package org.fsc.saas.project.mq.producer;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Map;

import static org.fsc.saas.project.common.constant.RedisKeyConstant.SHORT_LINK_STATS_STREAM_TOPIC_KEY;

/**
 * ClassName:ShortLinkStatsSaveProducer
 * Package:org.fsc.saas.project.mq.producer
 * Description:
 *
 * @Author: fsc
 * @Create: 2025/1/4 - 20:55
 * @Version: v1.0
 */
@Component
@RequiredArgsConstructor
public class ShortLinkStatsSaveProducer {

    private final StringRedisTemplate stringRedisTemplate;


    /**
     * 发送延迟消费短链接统计
     */
    public void send(Map<String, String> producerMap) {
        stringRedisTemplate.opsForStream().add(SHORT_LINK_STATS_STREAM_TOPIC_KEY, producerMap);
    }
}
