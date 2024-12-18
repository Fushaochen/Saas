package org.fsc.saas.project.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.project.dao.entity.ShortLinkDO;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;

/**
 * ClassName:ShortLinkService
 * Package:org.fsc.saas.project.service.impl
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 16:54
 * @Version: v1.0
 */
public interface ShortLinkService extends IService<ShortLinkDO> {
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);
}
