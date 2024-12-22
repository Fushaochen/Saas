package org.fsc.saas.project.controller;

import lombok.RequiredArgsConstructor;
import org.fsc.saas.project.common.convention.result.Result;
import org.fsc.saas.project.common.convention.result.Results;
import org.fsc.saas.project.service.UrlTitleService;
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

    private final UrlTitleService urlTitleService;

    @GetMapping("/api/saas/v1/title")
    public Result<String> getTitleByUrl(@RequestParam("url")String url){

        return Results.success(urlTitleService.getTitleByUrl(url));
    }
}
