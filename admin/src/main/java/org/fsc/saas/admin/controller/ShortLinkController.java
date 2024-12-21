package org.fsc.saas.admin.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.fsc.saas.admin.remote.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){

    };

    @GetMapping("/api/saas/admin/v1/page")
    public Result<IPage<ShortLinkPageRespDTO>> pageShortLink(ShortLinkPageReqDTO requestParam){
        return shortLinkRemoteService.pageShortLink(requestParam);
    }

    @PostMapping("/api/saas/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> createShortLink(@RequestBody ShortLinkCreateReqDTO requestParam){
        return shortLinkRemoteService.createShortLink(requestParam);

    }

}
