package org.fsc.saas.project.service;

/**
 * ClassName:UrlTitle
 * Package:com.nageoffer.shortlink.project.service
 * Description:标题接口层
 *
 * @Author: fsc
 * @Create: 2024/11/6 - 19:03
 * @Version: v1.0
 */
public interface UrlTitleService {

    /**
     * 根据 Url获取标题
     * @param url 目标网站地址
     * @return 网站标题
     */
    String getTitleByUrl(String url);
}
