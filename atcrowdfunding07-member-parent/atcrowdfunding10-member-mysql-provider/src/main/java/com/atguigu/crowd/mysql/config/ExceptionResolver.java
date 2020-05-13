package com.atguigu.crowd.mysql.config;

import com.alibaba.fastjson.JSON;
import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.common.enums.ExceptionEnum;
import com.atguigu.crowd.common.exception.AppException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月24日
 * @desc AppExceptionResolver 系统异常处理
 */
@Slf4j
@RestControllerAdvice
public class ExceptionResolver {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AppResult<String> exception(Exception e) {
        log.error("服务器错误-{}", e);
        return AppResult.error(ExceptionEnum.DEFAULT);
    }

    @ExceptionHandler(AppException.class)
    public void exception(AppException e, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(e.getCode());
        response.getWriter().write(JSON.toJSONString(AppResult.error(e)));
    }

}
