package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fsc.saas.project.common.database.BaseDO;
import org.fsc.saas.project.dao.entity.LinkDeviceStatsDO;
import org.fsc.saas.project.dao.entity.LinkNetworkStatsDO;
import org.fsc.saas.project.dto.req.ShortLinkStatsReqDTO;

import java.util.List;

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

    /**
     * 根据短链接获取指定日期内访问网络监控数据
     */
    @Select("SELECT " +
            "    tlns.network, " +
            "    SUM(tlns.cnt) AS cnt " +
            "FROM " +
            "    t_link tl INNER JOIN " +
            "    t_link_network_stats tlns ON tl.full_short_url = tlns.full_short_url " +
            "WHERE " +
            "    tlns.full_short_url = #{param.fullShortUrl} " +
            "    AND tl.gid = #{param.gid} " +
            "    AND tl.del_flag = '0' " +
            "    AND tl.enable_status = #{param.enableStatus} " +
            "    AND tlns.date BETWEEN #{param.startDate} and #{param.endDate} " +
            "GROUP BY " +
            "    tlns.full_short_url, tl.gid, tlns.network;")
    List<LinkNetworkStatsDO> listNetworkStatsByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}
