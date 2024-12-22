package org.fsc.saas.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * ClassName:ShortLinkNotFoundController
 * Package:com.nageoffer.shortlink.project.controller
 * Description:短链接不存在跳转控制器
 *
 * @Author: fsc
 * @Create: 2024/11/6 - 18:50
 * @Version: v1.0
 */
@Controller
public class ShortLinkNotFoundController {

    /**
     * 短链接不存在跳转页面
     */
    @RequestMapping("/page/notfound")
    public String notfound() {
        return "notfound";
    }
}
