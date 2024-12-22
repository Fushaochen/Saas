package org.fsc.saas.project.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.common.convention.result.Results;
import org.fsc.saas.project.dto.req.RecycleBinSaveReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkPageRespDTO;
import org.fsc.saas.project.service.RecycleBinService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:RecycleBinController
 * Package:org.fsc.saas.project.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 15:20
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class RecycleBinController {

    private final RecycleBinService recycleBinService;

    @PostMapping("/api/saas/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam){
        recycleBinService.saveRecycleBin(requestParam);
        return Results.success();
    }

    @GetMapping("/api/saas/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return Results.success(recycleBinService.pageShortLink(requestParam));
    }
}
