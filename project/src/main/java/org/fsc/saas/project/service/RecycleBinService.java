package org.fsc.saas.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.project.dao.entity.ShortLinkDO;
import org.fsc.saas.project.dto.req.*;
import org.fsc.saas.project.dto.resp.ShortLinkPageRespDTO;

/**
 * ClassName:RecycleBinService
 * Package:org.fsc.saas.project.service
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 15:23
 * @Version: v1.0
 */
public interface RecycleBinService extends IService<ShortLinkDO> {

    void saveRecycleBin(RecycleBinSaveReqDTO requestParam);

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkRecycleBinPageReqDTO requestParam);

    void recoverRecycleBin(RecycleBinRecoverReqDTO requestParam);

    void removeRecycleBin(RecycleBinRemoveReqDTO requestParam);
}
