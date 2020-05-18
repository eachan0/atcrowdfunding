package com.atguigu.crowd.common.constant;

import java.util.TimeZone;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月24日
 * @desc CrowConst 系统常量类
 */
public class AppConst {

    public static final TimeZone ATTR_APP_TIMEZONE = TimeZone.getTimeZone("Asia/Shanghai");
    public static final String ATTR_PHONE_CODE_PREFIX = "phonecode:";
    public static final String ATTR_NAME_MESSAGE = "message";
    public static final String MESSAGE_CODE_NOT_EXISTS = "验证码已过期";
    public static final String MESSAGE_CODE_INVALID = "验证码无效";
    public static final String MESSAGE_LOGIN_FAILED = "用户名和密码错误";
    public static final String ATTR_NAME_LOGIN_MEMBER = "loginMember";
    public static final String MESSAGE_STRING_INVALIDATE = "参数无效";
    public static final String MESSAGE_ACCESS_FORBIDEN = "禁止访问";
    public static final String MESSAGE_HEADER_PIC_EMPTY = "图片不能为空";
    public static final String MESSAGE_HEADER_PIC_UPLOAD_FAILED = "展示图片上传失败";
    public static final String MESSAGE_DETAIL_PIC_EMPTY = "图片不能为空";
    public static final String ATTR_NAME_TEMPLE_PROJECT = "tempProject";
    public static final String MESSAGE_DETAIL_PIC_UPLOAD_FAILED = "详情图片上传失败";

    public static final String MESSAGE_TEMPLE_PROJECT_MISSING = "参数失效";
}
