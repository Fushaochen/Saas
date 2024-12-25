package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.fsc.saas.project.dao.entity.LinkBrowserStatsDO;
import org.fsc.saas.project.dao.entity.LinkDeviceStatsDO;

/**
 * ClassName:LinkDeviceStatsMapper
 * Package:org.fsc.saas.project.dao.mapper
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 17:08
 * @Version: v1.0
 */
public interface LinkDeviceStatsMapper extends BaseMapper<LinkDeviceStatsDO> {


    @Insert("""
    INSERT INTO t_link_device_stats (full_short_url, gid, date, cnt, device, create_time, update_time, del_flag)
    VALUES (#{fullShortUrl}, #{gid}, #{date}, #{cnt}, #{device}, NOW(), NOW(), 0)
    ON DUPLICATE KEY UPDATE cnt = cnt + #{cnt};  
    """)
    void shortLinkDeviceStats(LinkDeviceStatsDO linkDeviceStatsDO);
}
