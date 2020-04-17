package com.atguigu.crowd.util;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月17日
 * @desc Result
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="AdminEntity对象", description="管理员账户表")
public class Result<T> implements Serializable {
    private static final long serialVersionUID = 7520898978368838174L;

    public static final int SUCCESS_CODE = 200;

    public static final String SUCCESS_MESSAGE = "请求成功";

    @ApiModelProperty(value = "响应码", name = "status", required = true, example = "" + SUCCESS_CODE)
    private int status = SUCCESS_CODE;

    @ApiModelProperty(value = "响应消息", name = "message", required = true, example = SUCCESS_MESSAGE)
    private String message = SUCCESS_MESSAGE;

    @ApiModelProperty(value = "响应数据", name = "data")
    private T data;

    @ApiModelProperty(value = "适用于分页查询返回数据总量", name = "count")
    private Long count = 0L;

    public static <E> Result<E> success(){
        return new Result<>();
    }
}
