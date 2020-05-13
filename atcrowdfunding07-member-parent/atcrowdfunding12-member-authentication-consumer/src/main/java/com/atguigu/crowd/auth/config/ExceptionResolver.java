package com.atguigu.crowd.auth.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.atguigu.crowd.common.entity.AppResult;
import com.atguigu.crowd.common.enums.ExceptionEnum;
import com.atguigu.crowd.common.exception.AppException;
import feign.FeignException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public AppResult<String> bindException(BindException e) {
        log.error("服务器错误-{}", e);
        return AppResult.error(ExceptionEnum.PARAMS_ERROR);
    }

    @ExceptionHandler(AppException.class)
    public void appException(AppException e, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        response.setStatus(e.getCode());
        response.getWriter().write(JSON.toJSONString(AppResult.error(e)));
    }

    @ExceptionHandler({FeignException.class})
    public Map<String, Object> feignException(FeignException exception, HttpServletResponse response) {
        String errBody = exception.contentUTF8();
        int httpStatus = exception.status();
        response.setStatus(httpStatus);
        if (httpStatus >= HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            log.error("FeignClient调用异常", exception);
        }
        if (StringUtils.isNotBlank(errBody)) {
            return JSON.parseObject(errBody);
        }
        Map<String, Object> data = new HashMap<>();
        String msg = exception.getMessage();
        if (StringUtils.isNotBlank(msg)) {
            int index = msg.indexOf("\n");
            if (index > 0) {
                String string = msg.substring(index);
                if (StringUtils.isNotBlank(string)) {
                    JSONObject json = JSONObject.parseObject(string.trim());
                    data.putAll(json.getInnerMap());
                }
            }
        }
        if (data.isEmpty()) {
            data.put("message", msg);
        }
        data.put("status", httpStatus);
        return data;
    }
}
