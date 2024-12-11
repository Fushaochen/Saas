package org.fsc.saas.admin.common.biz.user;

import com.alibaba.fastjson2.JSON;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.fsc.saas.admin.common.convention.exception.ServiceException;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;

/**
 * ClassName:UserTransmitFilter
 * Package:org.fsc.saas.admin.common.biz.user
 * Description:
 *
 * @Author: fsc
 * @Create: 2024/12/11 - 15:44
 * @Version: v1.0
 */
@RequiredArgsConstructor
public class UserTransmitFilter implements Filter {

    private final StringRedisTemplate stringRedisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        if(!requestURI.equals("/api/saas/admin/v1/user/login")){
            String username = httpServletRequest.getHeader("username");
            String token = httpServletRequest.getHeader("token");
            if (username != null && token != null){
                try {
                    Object userInfoJsonStr = stringRedisTemplate.opsForHash().get("login_" + username, token);
                    if(userInfoJsonStr != null){
                        UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(), UserInfoDTO.class);
                        UserContext.setUser(userInfoDTO);
                    }
                }catch (Exception e){
                    throw new ServiceException("Redis Error!");
                }
            }
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }
}