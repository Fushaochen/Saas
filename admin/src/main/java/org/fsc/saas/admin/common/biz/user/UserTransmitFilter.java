package org.fsc.saas.admin.common.biz.user;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONPath;
import com.google.common.collect.Lists;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.fsc.saas.admin.common.convention.exception.ClientException;
import org.fsc.saas.admin.common.convention.exception.ServiceException;
import org.fsc.saas.admin.common.convention.result.Results;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.fsc.saas.admin.common.enums.UserErrorCodeEnum.USER_TOKEN_FAIL;

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

    private static final List<String> IGNORE_URI = Lists.newArrayList(
            "/api/saas/admin/v1/user/login",
            "/api/saas/admin/admin/v1/actual/user/has_username"
    );

    @SneakyThrows
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String requestURI = httpServletRequest.getRequestURI();

        if(!IGNORE_URI.contains(requestURI)){
            String method = httpServletRequest.getMethod();
            if(!(requestURI.equals("/api/saas/admin/v1/user") && method.equals("POST"))){
                String username = httpServletRequest.getHeader("username");
                String token = httpServletRequest.getHeader("token");
                if (!StrUtil.isAllNotBlank(username, token)) {
                    returnJson((HttpServletResponse) servletResponse, JSON.toJSONString(Results.failure(new ClientException(USER_TOKEN_FAIL))));
                    return;
                }
                Object userInfoJsonStr;
                try {
                    userInfoJsonStr = stringRedisTemplate.opsForHash().get("login_" + username, token);
                    if(userInfoJsonStr == null){
                        throw new ClientException(USER_TOKEN_FAIL);
                    }
                }catch (Exception e){
                    returnJson((HttpServletResponse) servletResponse, JSON.toJSONString(Results.failure(new ClientException(USER_TOKEN_FAIL))));
                    return;
                }
                UserInfoDTO userInfoDTO = JSON.parseObject(userInfoJsonStr.toString(), UserInfoDTO.class);
                UserContext.setUser(userInfoDTO);
            }
        }
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } finally {
            UserContext.removeUser();
        }
    }

    private void returnJson(HttpServletResponse response, String json) throws Exception{
        PrintWriter writer = null;
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        try {
            writer = response.getWriter();
            writer.print(json);
        }catch (IOException e){

        }finally {
            if (writer != null){
                writer.close();
            }
        }
    }
}