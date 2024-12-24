package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.dao.entity.LinkAccessStatsDO;

/**
 * ClassName:LinkAccessStatsMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/24 - 19:44
 * @Version: v1.0
 */
public interface LinkAccessStatsMapper extends BaseMapper<LinkAccessStatsDO> {
    @Insert("INSERT INTO t_link_access_stats (" +
            "full_short_url, gid, date, pv, uv, uip, hour, weekday, create_time, update_time, del_flag" +
            ") VALUES (" +
            "#{fullShortUrl}, #{gid}, #{date}, #{pv}, #{uv}, #{uip}, #{hour}, #{weekday}, NOW(), NOW(), #{delFlag}" +
            ") ON DUPLICATE KEY UPDATE " +
            "pv = pv + #{pv}, uv = uv + #{uv}, uip = uip + #{uip}")
    void shortLinkStats(LinkAccessStatsDO linkAccessStatsDO);


}
