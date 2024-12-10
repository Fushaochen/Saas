package org.fsc.saas.admin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.fsc.saas.admin.common.convention.exception.ClientException;
import org.fsc.saas.admin.common.enums.UserErrorCodeEnum;
import org.fsc.saas.admin.dao.entity.UserDO;
import org.fsc.saas.admin.dao.mapper.UserMapper;
import org.fsc.saas.admin.dto.resp.UserRespDTO;
import org.fsc.saas.admin.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

/**
 * ClassName:UserServiceImpl
 * Package:org.fsc.saas.admin.service.impl
 * Description:用户接口实现层
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 10:49
 * @Version: v1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {


    @Override
    public UserRespDTO getUserByUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);

        UserDO userDO = baseMapper.selectOne(queryWrapper);
        if (userDO == null){
            throw new ClientException(UserErrorCodeEnum.USER_NULL);
        }
        UserRespDTO userRespDTO = new UserRespDTO();
        BeanUtils.copyProperties(userDO,userRespDTO);
        return userRespDTO;
    }

    @Override
    public Boolean hasUsername(String username) {
        LambdaQueryWrapper<UserDO> queryWrapper = Wrappers.lambdaQuery(UserDO.class)
                .eq(UserDO::getUsername, username);
        UserDO userDO = baseMapper.selectOne(queryWrapper);
        return userDO != null;
    }
}
