package org.fsc.saas.project.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.fsc.saas.project.dao.entity.ShortLinkDO;
import org.fsc.saas.project.dao.mapper.ShortLinkMapper;
import org.fsc.saas.project.dto.req.ShortLinkCreateReqDTO;
import org.fsc.saas.project.dto.resp.ShortLinkCreateRespDTO;
import org.fsc.saas.project.service.ShortLinkService;
import org.fsc.saas.project.toolkit.HashUtil;
import org.springframework.stereotype.Service;

/**
 * ClassName:ShortLinkServiceImpl
 * Package:org.fsc.saas.project.service.impl
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/17 - 16:54
 * @Version: v1.0
 */
@Slf4j
@Service
public class ShortLinkServiceImpl extends ServiceImpl<ShortLinkMapper, ShortLinkDO> implements ShortLinkService {


    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        String shortLinkSuffix = generateSuffix(requestParam);
        ShortLinkDO shortLinkDO = BeanUtil.toBean(requestParam, ShortLinkDO.class);
        shortLinkDO.setShortUri(shortLinkSuffix);
        shortLinkDO.setEnableStatus(0);
        shortLinkDO.setDescribe(requestParam.getDescribe());
        shortLinkDO.setFullShortUrl(requestParam.getDomain() + "/" + shortLinkSuffix);
        baseMapper.insert(shortLinkDO);
        return ShortLinkCreateRespDTO.builder()
                .fullShortUrl(shortLinkDO.getFullShortUrl())
                .originUrl(requestParam.getOriginUrl())
                .gid(requestParam.getGid())
                .build();
    }

    private String generateSuffix(ShortLinkCreateReqDTO  requestParam){
        String originUrl = requestParam.getOriginUrl();
        return HashUtil.hashToBase62(originUrl);
    }
}
