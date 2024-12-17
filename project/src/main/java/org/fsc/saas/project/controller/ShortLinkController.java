package org.fsc.saas.project.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.common.convention.result.Results;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.project.service.ShortLinkService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/api/saas/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        ShortLinkCreateRespDTO shortLinkCreateRespDTO = shortLinkService.createShortLink(requestParam);
        return Results.success(null);
    }
}
