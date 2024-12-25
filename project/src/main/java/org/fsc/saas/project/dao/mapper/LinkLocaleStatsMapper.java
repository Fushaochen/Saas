package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.dao.entity.LinkLocaleStatsDO;

/**
 * ClassName:LinkLocaleStatsMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 15:20
 * @Version: v1.0
 */
public interface LinkLocaleStatsMapper extends BaseMapper<LinkLocaleStatsDO> {


    @Insert("""
INSERT INTO t_link_locale_stats (full_short_url, gid, date, cnt, province, city, adcode, country, create_time, update_time, del_flag)
VALUES (#{fullShortUrl}, #{gid}, #{date}, #{cnt}, #{province}, #{city}, #{adcode}, #{country}, NOW(), NOW(), 0)
ON DUPLICATE KEY UPDATE cnt = cnt + #{cnt};  
""")
    void shortLinkLocaleStats(LinkLocaleStatsDO linkLocaleStatsDO);

}
