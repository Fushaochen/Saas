package org.fsc.saas.admin.service.impl;

import cn.hutool.core.collection.CollUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.biz.user.UserContext;
import org.fsc.saas.admin.common.convention.exception.ServiceException;
import org.fsc.saas.admin.common.convention.result.Result;
import org.fsc.saas.admin.dao.entity.GroupDO;
import org.fsc.saas.admin.dao.mapper.GroupMapper;
import org.fsc.saas.admin.remote.ShortLinkRemoteService;
import org.fsc.saas.admin.remote.dto.req.ShortLinkPageReqDTO;
import org.fsc.saas.admin.remote.dto.req.ShortLinkRecycleBinPageReqDTO;
import org.fsc.saas.admin.remote.dto.resp.ShortLinkPageRespDTO;
import org.fsc.saas.admin.service.RecycleBinService;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * ClassName:RecycleBinServiceImpl
 * Package:org.fsc.saas.admin.service.impl
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/22 - 16:38
 * @Version: v1.0
 */
@Service
@RequiredArgsConstructor
public class RecycleBinServiceImpl implements RecycleBinService {

    private final GroupMapper groupMapper;

    ShortLinkRemoteService shortLinkRemoteService = new ShortLinkRemoteService() {
    };

    @Override
    public Result<IPage<ShortLinkPageRespDTO>> pageRecycleBinShortLink(ShortLinkRecycleBinPageReqDTO requestParam) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getDelFlag, 0);
        List<GroupDO> groupDOList = groupMapper.selectList(queryWrapper);
        if(CollUtil.isEmpty(groupDOList)){
            throw new ServiceException("用户无分组信息");
        }
        requestParam.setGidList(groupDOList.stream().map(GroupDO::getGid).toList());
        List<String> gidList = requestParam.getGidList();
        return shortLinkRemoteService.pageRecycleBinShortLink(requestParam);
    }
}
