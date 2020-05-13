package com.atguigu.crowd.common.entity;

import com.atguigu.crowd.common.enums.ExceptionEnum;
import com.atguigu.crowd.common.exception.AppException;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc Result 系统同一返回格式
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "AdminEntity对象", description = "管理员账户表")
public class AppResult<T> implements Serializable {
    private static final long serialVersionUID = 7520898978368838174L;

    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "请求成功";

    @ApiModelProperty(value = "响应码", name = "status", required = true, example = "" + SUCCESS_CODE)
    private int status = SUCCESS_CODE;

    @ApiModelProperty(value = "响应消息", name = "message", required = true, example = SUCCESS_MESSAGE)
    private String message = SUCCESS_MESSAGE;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

    @ApiModelProperty(value = "返回数据总量,可以为空", name = "count")
    private Number count = 0;

    public static AppResult<String> success() {
        return new AppResult<>();
    }

    public static <E> AppResult<E> success(String message) {
        return new AppResult<E>().setMessage(message);
    }

    public static <E> AppResult<E> success(E data, Long count) {
        return new AppResult<E>().setData(data).setCount(count);
    }

    public static <E> AppResult<E> success(E data, Integer count) {
        return new AppResult<E>().setData(data).setCount(count);
    }

    public static <E> AppResult<E> success(String message, E data, Long count) {
        return new AppResult<E>().setMessage(message).setData(data).setCount(count);
    }

    public static AppResult<String> error(String message) {
        return error(500, message, message);
    }

    public static AppResult<String> error(int code, String message) {
        return error(code, message, message);
    }

    public static <E> AppResult<E> error(int code, String message, E data) {
        return new AppResult<E>().setStatus(code).setMessage(message).setData(data);
    }

    public static AppResult<String> error(AppException exception) {
        return error(exception.getCode(), exception.getMessage(), exception.getMessage());
    }

    public static AppResult<String> error(ExceptionEnum aDefault) {
        return error(aDefault.getCode(), aDefault.getMessage(), aDefault.getMessage());
    }
}
