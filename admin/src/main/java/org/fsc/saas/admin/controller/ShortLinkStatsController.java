package org.fsc.saas.admin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.fsc.saas.admin.remote.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkStatsReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkStatsRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:ShortLinkStatsController
 * Package:org.fsc.saas.admin.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/29 - 13:40
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    /**
     * 访问单个短链接指定时间内监控数据
     */
    @GetMapping("/api/saas/admin/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam) {
        return shortLinkRemoteService.oneShortLinkStats(
                requestParam.getFullShortUrl(),
                requestParam.getGid(),
                requestParam.getEnableStatus(),
                requestParam.getStartDate(),
                requestParam.getEndDate()
        );
    }

    /**
     * 访问单个短链接指定时间内访问记录监控数据
     */
    @GetMapping("/api/saas/admin/v1/stats/access-record")
    public Result<Page<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam) {
        return shortLinkRemoteService.shortLinkStatsAccessRecord(
                requestParam.getFullShortUrl(),
                requestParam.getGid(),
                requestParam.getStartDate(),
                requestParam.getEndDate(),
                requestParam.getEnableStatus(),
                requestParam.getCurrent(),
                requestParam.getSize()
        );
    }
}
