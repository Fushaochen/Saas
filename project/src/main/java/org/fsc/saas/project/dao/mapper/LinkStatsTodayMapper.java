package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.dao.entity.LinkOsStatsDO;
import org.fsc.saas.project.dao.entity.LinkStatsTodayDO;

/**
 * ClassName:LinkStatsTodayMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/29 - 14:13
 * @Version: v1.0
 */
public interface LinkStatsTodayMapper extends BaseMapper<LinkStatsTodayDO> {

    @Insert("""
    INSERT INTO t_link_stats_today (full_short_url, gid, date, today_pv, today_uv, today_uip, create_time, update_time, del_flag)
    VALUES (#{fullShortUrl}, #{gid}, #{date}, #{todayPv}, #{todayUv}, #{todayUip}, NOW(), NOW(), 0)
    ON DUPLICATE KEY UPDATE today_pv = today_pv + #{todayPv}, today_uv = today_uv + #{todayUv}, today_uip = today_uip + #{todayUip};  
    """)
    void shortLinkTodayStats(LinkStatsTodayDO linkStatsTodayDO);

}
