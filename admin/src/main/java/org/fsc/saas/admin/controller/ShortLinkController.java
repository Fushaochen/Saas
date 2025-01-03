package org.fsc.saas.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.convention.result.Results;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.fsc.saas.admin.remote.dto.req.ShortLinkBatchCreateReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkUpdateDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkBaseInfoRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkBatchCreateRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.fsc.saas.admin.toolkit.EasyExcelWebUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:ShortLinkController
 * Package:org.fsc.saas.admin.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/21 - 14:56
 * @Version: v1.0
 */
@RestController
public class ShortLinkController {

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    @GetMapping("/api/saas/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return shortLinkRemoteService.pageShortLink(requestParam);
    }

    /**
     * 批量创建短链接
     */
    @SneakyThrows
    @PostMapping("/api/saas/admin/v1/create/batch")
    public void batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam, HttpServletResponse response) {
        Result<ShortLinkBatchCreateRespDTO> shortLinkBatchCreateRespDTOResult = shortLinkRemoteService.batchCreateShortLink(requestParam);
        if (shortLinkBatchCreateRespDTOResult.isSuccess()) {
            List<ShortLinkBaseInfoRespDTO> baseLinkInfos = shortLinkBatchCreateRespDTOResult.getData().getBaseLinkInfos();
            EasyExcelWebUtil.write(response, "批量创建短链接-SaaS短链接系统", ShortLinkBaseInfoRespDTO.class, baseLinkInfos);
        }
    }

    @PostMapping("/api/saas/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return shortLinkRemoteService.createShortLink(requestParam);

    }

    @PostMapping("/api/saas/admin/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateDTO requestParam){
        shortLinkRemoteService.updateShortLink(requestParam);
        return Results.success();
    }

}
