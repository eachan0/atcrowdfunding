package com.atguigu.crowd.mvc.interceptor;

import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.util.constant.CrowConst;
import com.atguigu.crowd.util.exception.AccessForbiddenException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月21日
 * @desc LoginInterceptor 登陆检查
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object attribute = request.getSession().getAttribute(CrowConst.ATTR_LOGIN_NAME);
        if (attribute instanceof AdminEntity){
            return true;
        }
        throw new AccessForbiddenException(CrowConst.MSG_ACCESS_FORBIDDEN);
    }
}
