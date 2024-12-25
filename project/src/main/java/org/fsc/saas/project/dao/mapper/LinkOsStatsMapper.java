package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.dao.entity.LinkLocaleStatsDO;
import org.fsc.saas.project.dao.entity.LinkOsStatsDO;

/**
 * ClassName:LinkOsStatsMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 16:16
 * @Version: v1.0
 */
public interface LinkOsStatsMapper extends BaseMapper<LinkOsStatsDO> {

    @Insert("""
    INSERT INTO t_link_os_stats (full_short_url, gid, date, cnt, os, create_time, update_time, del_flag)
    VALUES (#{fullShortUrl}, #{gid}, #{date}, #{cnt}, #{os}, NOW(), NOW(), 0)
    ON DUPLICATE KEY UPDATE cnt = cnt + #{cnt};  
    """)
    void shortLinkOsStats(LinkOsStatsDO linkOsStatsDO);
}
