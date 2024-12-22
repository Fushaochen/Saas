package org.fsc.saas.admin.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.common.convention.result.Results;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:UrlTitleController
 * Package:com.nageoffer.shortlink.project.controller
 * Description:URL标题控制层
 *
 * @Author: fsc
 * @Create: 2024/11/6 - 19:01
 * @Version: v1.0
 */
@RestController
@RequiredArgsConstructor
public class UrlTitleController {

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService(){

    };

    @GetMapping("/api/saas/admin/title")
    public Result<String> getTitleByUrl(@RequestParam("url")String url){
        return shortLinkRemoteService.getTitleByUrl(url);
    }
}
