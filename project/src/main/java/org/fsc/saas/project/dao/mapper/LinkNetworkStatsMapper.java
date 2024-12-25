package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.common.database.BaseDO;
import org.fsc.saas.project.dao.entity.LinkDeviceStatsDO;
import org.fsc.saas.project.dao.entity.LinkNetworkStatsDO;

/**
 * ClassName:LinkNetworkStatsMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 17:16
 * @Version: v1.0
 */
public interface LinkNetworkStatsMapper extends BaseMapper<LinkNetworkStatsDO> {

    @Insert("""
    INSERT INTO t_link_network_stats (full_short_url, gid, date, cnt, network, create_time, update_time, del_flag)
    VALUES (#{fullShortUrl}, #{gid}, #{date}, #{cnt}, #{network}, NOW(), NOW(), 0)
    ON DUPLICATE KEY UPDATE cnt = cnt + #{cnt};  
    """)
    void shortLinkNetworkStats(LinkNetworkStatsDO linkNetworkStatsDO);
}
