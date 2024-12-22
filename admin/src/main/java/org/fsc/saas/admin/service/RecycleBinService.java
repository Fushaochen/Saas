package org.fsc.saas.admin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;

/**
 * ClassName:RecycleBinService
 * Package:org.fsc.saas.admin.service
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 16:38
 * @Version: v1.0
 */
public interface RecycleBinService {


    Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam);
}
