package org.fsc.saas.project.toolkit;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;

import java.util.Date;
import java.util.Optional;

import static org.fsc.saas.project.common.constant.ShortLinkConstant.DEFAULT_CACHE_VALID_TIME;

/**
 * ClassName:LinkUtil
 * Package:org.fsc.saas.project.toolkit
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 14:13
 * @Version: v1.0
 */
public class LinkUtil {

    /**
     * 获取短链接有效期时间
     * @param validDate 有效期时间
     * @return 有效期时间戳
     */
    public static long getLinkCacheValidDate(Date validDate){
        return Optional.ofNullable(validDate)
                .map(each-> DateUtil.between(new Date(),each, DateUnit.MS))
                .orElse(DEFAULT_CACHE_VALID_TIME);
    }
}
