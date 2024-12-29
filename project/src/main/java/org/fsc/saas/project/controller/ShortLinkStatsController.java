package org.fsc.saas.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.apache.yetus.audience.InterfaceAudience;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.common.convention.result.Results;
import org.fsc.saas.project.dto.req.ShortLinkGroupStatsReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkStatsAccessRecordReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkStatsReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkStatsAccessRecordRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkStatsRespDTO;
import org.fsc.saas.project.service.ShortLinkStatsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

/**
 * ClassName:ShortLinkStatsController
 * Package:org.fsc.saas.project.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/25 - 20:09
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkStatsController {

    private final ShortLinkStatsService shortLinkStatsService;

    @GetMapping("/api/saas/v1/stats")
    public Result<ShortLinkStatsRespDTO> shortLinkStats(ShortLinkStatsReqDTO requestParam){
        System.out.println("temp");
        ShortLinkStatsRespDTO shortLinkStatsRespDTO = shortLinkStatsService.oneShortLinkStats(requestParam);
        return Results.success(shortLinkStatsRespDTO);
    }

    @GetMapping("/api/saas/v1/stats/group")
    public Result<ShortLinkStatsRespDTO> groupShortLinkStats(ShortLinkGroupStatsReqDTO requestParam) {
        return Results.success(shortLinkStatsService.groupShortLinkStats(requestParam));
    }

    @GetMapping("/api/saas/v1/stats/access-record")
    public Result<IPage<ShortLinkStatsAccessRecordRespDTO>> shortLinkStatsAccessRecord(ShortLinkStatsAccessRecordReqDTO requestParam){
        return Results.success(shortLinkStatsService.shortLinkStatsAccessRecord(requestParam));
    }
}
