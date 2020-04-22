package com.atguigu.crowd.mvc.config;

import com.alibaba.fastjson.JSON;
import com.atguigu.crowd.util.CrowdUtil;
import com.atguigu.crowd.util.Result;
import com.atguigu.crowd.util.constant.CrowConst;
import com.atguigu.crowd.util.enums.ExceptionEnum;
import com.atguigu.crowd.util.exception.AccessForbiddenException;
import com.atguigu.crowd.util.exception.AppException;
import com.atguigu.crowd.util.exception.LoginAcctAlreadyExistsException;
import com.atguigu.crowd.util.exception.LoginFailedException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc CrowdExceptionResolver
 */
@ControllerAdvice
public class CrowdExceptionResolver {

    private static final String VIEW_DEFAULT = "system-error";
    private static final String VIEW_LOGIN = "admin-login";
    private static final String VIEW_ADMIN_ADD = "admin-add";

    @ExceptionHandler(value = Exception.class)
    public ModelAndView resolverException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        exception.printStackTrace();
        AppException appException = new AppException(ExceptionEnum.DEFAULT);
        return resolveViewAndJson(appException.getCode(), appException, request, response);
    }

    @ExceptionHandler(value = AppException.class)
    public ModelAndView resolverAppException(AppException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return resolveViewAndJson(exception.getCode(), exception, request, response);
    }

    @ExceptionHandler(value = DuplicateKeyException.class)
    public ModelAndView resolverDuplicateKeyException(DuplicateKeyException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        exception.printStackTrace();
        AppException appException = new AppException(ExceptionEnum.DUPLICATE_KEY);
        return resolveViewAndJson(appException.getCode(), appException, request, response);
    }

    @ExceptionHandler(value = {LoginFailedException.class, AccessForbiddenException.class})
    public ModelAndView resolverLoginException(Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return resolveView(exception, VIEW_LOGIN);
    }

    @ExceptionHandler(value = LoginAcctAlreadyExistsException.class)
    public ModelAndView resolveDataAlreadyExistsException(LoginAcctAlreadyExistsException exception, HttpServletRequest request, HttpServletResponse response) throws IOException {
        return resolveView(exception, VIEW_ADMIN_ADD);
    }

    protected ModelAndView resolveViewAndJson(int status, Exception exception, HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 判断当前请求类型,如果是Ajax请求
        if (CrowdUtil.judgeAjaxRequest(request)) {
            Result<String> result = Result.error(status, exception.getMessage());

            // 设置响应状态码
            response.setStatus(status);

            // 将JSON字符串作为响应体返回给浏览器
            response.getWriter().write(JSON.toJSONString(result));

            // 由于上面已经通过原生的response对象返回了响应，所以不提供ModelAndView对象
            return null;
        }
        // 如果不是Ajax请求则创建ModelAndView对象
        ModelAndView modelAndView = new ModelAndView();

        // 将Exception对象存入模型
        modelAndView.addObject(CrowConst.ATTR_EXCEPTION, exception);

        // 设置对应的视图名称
        modelAndView.setViewName(VIEW_DEFAULT);

        // 返回modelAndView对象
        return modelAndView;
    }

    protected ModelAndView resolveView(Exception exception, String viewName) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject(CrowConst.ATTR_EXCEPTION, exception);
        modelAndView.setViewName(viewName);
        return modelAndView;
    }
}
