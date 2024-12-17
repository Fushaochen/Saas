package org.fsc.saas.project.config;

import org.redisson.api.RBloomFilter;
import org.redisson.api.RedissonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ClassName:RBloomFilterConfiguration
 * Package:org.fsc.saas.admin.config
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/10 - 20:11
 * @Version: v1.0
 */
@Configuration
public class RBloomFilterConfiguration {

    @Bean
    public RBloomFilter<String> shortUriCreateCachePenetrationBloomFilter(RedissonClient redissonClient){
        RBloomFilter<String> cachePenetrationBloomFilter = redissonClient.getBloomFilter("shortUriCreateCachePenetrationBloomFilter");
        cachePenetrationBloomFilter.tryInit(100000000L,0.001);
        return cachePenetrationBloomFilter;
    }
}
