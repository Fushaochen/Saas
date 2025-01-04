package org.fsc.saas.project.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.fsc.saas.project.dao.entity.ShortLinkDO;
import org.fsc.saas.project.dto.biz.ShortLinkStatsRecordDTO;
import org.fsc.saas.project.dto.req.ShortLinkBatchCreateReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.project.dto.req.ShortLinkUpdateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkBatchCreateRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkGroupCountQueryRespDTO;
import org.fsc.saas.project.dto.resp.ShortLinkPageRespDTO;

import java.util.List;

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

    IPage<ShortLinkPageRespDTO> pageShortLink(ShortLinkPageReqDTO requestParam);

    List<ShortLinkGroupCountQueryRespDTO> listGroupShortLinkCount(List<String> requestParam);

    void updateShortLink(ShortLinkUpdateReqDTO requestParam);

    void restoreUrl(String shortUri, ServletRequest request, ServletResponse response);

    ShortLinkBatchCreateRespDTO batchCreateShortLink(ShortLinkBatchCreateReqDTO requestParam);

    /**
     * 短链接统计
     *
     * @param fullShortUrl         完整短链接
     * @param gid                  分组标识
     * @param shortLinkStatsRecord 短链接统计实体参数
     */
    void shortLinkStats(String fullShortUrl, String gid, ShortLinkStatsRecordDTO shortLinkStatsRecord);

}
