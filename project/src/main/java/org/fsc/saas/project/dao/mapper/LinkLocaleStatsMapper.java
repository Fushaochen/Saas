package org.fsc.saas.project.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.fsc.saas.project.dao.entity.LinkLocaleStatsDO;
import org.fsc.saas.project.dto.req.ShortLinkStatsReqDTO;

import java.util.List;

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


    /**\
     * 根据短链接获取指定日期内地区监控数据
     * @param requestParam
     * @return
     */
    @Select("""
    select province, SUM(cnt) AS cnt
    FROM t_link_locale_stats
    WHERE full_short_url = #{param.fullShortUrl} AND gid  = #{param.gid} AND date BETWEEN #{param.startDate} AND #{param.endDate}
    GROUP BY full_short_url, gid, province;
    """)
    List<LinkLocaleStatsDO> listLocaleByShortLink(@Param("param") ShortLinkStatsReqDTO requestParam);
}
