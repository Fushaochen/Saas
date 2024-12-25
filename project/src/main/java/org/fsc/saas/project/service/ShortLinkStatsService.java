package org.fsc.saas.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.project.dao.entity.ShortLinkDO;
import org.fsc.saas.project.dto.req.ShortLinkStatsReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkStatsRespDTO;

/**
 * ClassName:ShortLinkStatsService
 * Package:org.fsc.saas.project.service
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 20:15
 * @Version: v1.0
 */
public interface ShortLinkStatsService{
    /**
     * 获取单个短链接监控数据
     *
     * @param requestParam 获取短链接监控数据入参
     * @return 短链接监控数据
     */
    ShortLinkStatsRespDTO oneShortLinkStats(ShortLinkStatsReqDTO requestParam);
}
