package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fsc.saas.project.dao.entity.LinkBrowserStatsDO;
import org.fsc.saas.project.dao.entity.LinkDeviceStatsDO;
import org.fsc.saas.project.dto.req.ShortLinkStatsReqDTO;

import java.util.List;

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


    /**
     * 根据短链接获取指定日期内访问设备监控数据
     */
    @Select("SELECT " +
            "    tlds.device, " +
            "    SUM(tlds.cnt) AS cnt " +
            "FROM " +
            "    t_link tl INNER JOIN " +
            "    t_link_device_stats tlds ON tl.full_short_url = tlds.full_short_url " +
            "WHERE " +
            "    tlds.full_short_url = #{param.fullShortUrl} " +
            "    AND tl.gid = #{param.gid} " +
            "    AND tl.del_flag = '0' " +
            "    AND tl.enable_status = #{param.enableStatus} " +
            "    AND tlds.date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    tlds.full_short_url, tl.gid, tlds.device;")
    List<LinkDeviceStatsDO> listDeviceStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}
