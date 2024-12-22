package org.fsc.saas.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.convention.result.Results;
import org.fsc.saas.admin.dto.req.RecycleBinSaveReqDTO;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;
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

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){
    };

    @PostMapping("/api/saas/v1/recycle-bin/save")
    public Result<Void> saveRecycleBin(@RequestBody RecycleBinSaveReqDTO requestParam){
        shortLinkRemoteService.saveRecycleBin(requestParam);
        return Results.success();
    }

    @GetMapping("/api/saas/admin/v1/recycle-bin/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return shortLinkRemoteService.pageRecycleBinShortLink(requestParam);
    }
}
