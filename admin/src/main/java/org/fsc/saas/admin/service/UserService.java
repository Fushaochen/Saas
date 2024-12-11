package org.fsc.saas.admin.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.fsc.saas.admin.dao.entity.UserDO;
import org.fsc.saas.admin.dto.req.UserLoginReqDTO;
import org.fsc.saas.admin.dto.req.UserRegisterReqDTO;
import org.fsc.saas.admin.dto.req.UserUpdateReqDTO;
import org.fsc.saas.admin.dto.resp.UserLoginRespDTO;
import org.fsc.saas.admin.dto.resp.UserRespDTO;

/**
 * ClassName:UserService
 * Package:org.fsc.saas.admin.service
 * Description:用户接口层
 *
 * @Author: fsc
 * @Create: 2024/12/9 - 10:48
 * @Version: v1.0
 */
public interface UserService extends IService<UserDO> {

    /**
     * 根据用户名查询用户信息
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);

    /**
     * 查询用户名是否可用
     * @param username
     * @return
     */
    Boolean hasUsername(String username);

    /**
     * 注册用户
     * @param requestParam
     */
    void register(UserRegisterReqDTO requestParam);

    /**
     * 修改用户信息
     * @param requestParam
     */
    void update(UserUpdateReqDTO requestParam);

    /**
     * 用户登录
     * @param requestParam
     * @return
     */
    UserLoginRespDTO login(UserLoginReqDTO requestParam);
}
