package com.atguigu.crowd.util.enums;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月22日
 * @desc ExceptionEnum
 */
@AllArgsConstructor
public enum ExceptionEnum {
    /**
     * 系统默认异常消息提示
     */
    DEFAULT(HttpStatus.INTERNAL_SERVER_ERROR.value(),"服务器意外错误,请稍后重试"),
    /**
     * 唯一索引不满足
     */
    DUPLICATE_KEY(HttpStatus.INTERNAL_SERVER_ERROR.value(),"数据已存在"),

    /**
     * 没有权限
     */
    ACCESS_DENIED(HttpStatus.FORBIDDEN.value(),HttpStatus.FORBIDDEN.getReasonPhrase())
    ;

    private int code;
    private String message;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
