package org.fsc.saas.admin.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.fsc.saas.admin.dao.entity.GroupDO;
import org.fsc.saas.admin.dao.mapper.GroupMapper;
import org.fsc.saas.admin.service.GroupService;
import org.springframework.stereotype.Service;

/**
 * ClassName:GroupServiceImpl
 * Package:org.fsc.saas.admin.service.impl
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 14:44
 * @Version: v1.0
 */
@Slf4j
@Service
public class GroupServiceImpl extends ServiceImpl<GroupMapper, GroupDO> implements GroupService {



}
