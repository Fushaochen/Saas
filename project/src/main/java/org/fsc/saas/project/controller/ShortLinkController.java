package org.fsc.saas.project.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.baomidou.mybatisplus.core.metadata.IPage;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.common.convention.result.Results;
import org.fsc.saas.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkUpdateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkBatchCreateRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkPageRespDTO;
import org.fsc.saas.project.handler.CustomBlockHandler;
import org.fsc.saas.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName:ShortLinkController
 * Package:org.fsc.saas.project.controller
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 17:01
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class ShortLinkController {

    private final ShortLinkService shortLinkService;

    @GetMapping("/{short-uri}")
    public void restoreUrl(@PathVariable("short-uri") String shortUri, ServletRequest request, ServletResponse response){
        shortLinkService.restoreUrl(shortUri, request, response);
    }

    /**
     * 批量创建短链接
     */
    @PostMapping("/api/saas/v1/create/batch")
    public Result<ShortLinkBatchCreateRespDTO> batchCreateShortLink(@RequestBody ShortLinkBatchCreateReqDTO requestParam) {
        return Results.success(shortLinkService.batchCreateShortLink(requestParam));
    }

    @PostMapping("/api/saas/v1/create")
    @SentinelResource(
            value = "create_short-link",
            blockHandler = "createShortLinkBlockHandlerMethod",
            blockHandlerClass = CustomBlockHandler.class
    )
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        ShortLinkCreateRespDTO shortLinkCreateRespDTO = shortLinkService.createShortLink(requestParam);
        return Results.success(shortLinkCreateRespDTO);
    }

    @GetMapping("/api/saas/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return Results.success(shortLinkService.pageShortLink(requestParam));
    }

    @GetMapping("/api/saas/v1/count")
    public Result<List<ShortLinkGroupCountQueryRespDTO>> listGroupShortLinkCount(@RequestParam("requestParam") List<String> requestParam){
        return Results.success(shortLinkService.listGroupShortLinkCount(requestParam));
    }

    @PostMapping("/api/saas/v1/update")
    public Result<Void> updateShortLink(@RequestBody ShortLinkUpdateReqDTO requestParam){
        shortLinkService.updateShortLink(requestParam);
        return Results.success();
    }

}
