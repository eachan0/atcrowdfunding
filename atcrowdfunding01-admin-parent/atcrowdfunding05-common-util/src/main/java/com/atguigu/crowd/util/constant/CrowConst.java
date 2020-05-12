package com.atguigu.crowd.util.constant;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc CrowConst
 */
public class CrowConst {

    /**
     * 异常页面读取信息变量名
     */
    public static final String ATTR_EXCEPTION = "exception";

    /**
     * 判断 Ajax请求的请求头-名称
     */
    public static final String ATTR_AJAX_HEADER_NAME = "X-Requested-With";

    /**
     * 判断 Ajax请求的请求头-值
     */
    public static final String ATTR_AJAX_HEADER_VALUE = "XMLHttpRequest";

    /**
     * 登录成功后 session 存储名
     */
    public static final String ATTR_LOGIN_NAME = "loginAdmin";

    public static final String ATTR_ADMIN_EDIT = "admin";

    /**
     * MD5 加密字符串,前置验证错误的默认消息
     */
    public static final String MSG_MD5_ENCODING = "无效的字符串";

    /**
     * 登陆失败消息提示
     */
    public static final String MSG_ACCT_NOT_EXIST = "账户不存在";

    /**
     * 账户或者密码错误
     */
    public static final String MSG_PASSWORD_ERROR = "账户名或者密码错误";

    /**
     * 未登录访问受保护资源
     */
    public static final String MSG_ACCESS_FORBIDDEN = "登录失效,请重新登录";

    /**
     * 管理员维护界面参数名
     */
    public static final String ATTR_ADMIN_PAGE = "adminPageInfo";

    /**
     * security 忽略的资源
     */
    public static final String[] ATTR_SECURITY_IGNORE = {"/bootstrap/**",
            "/crowd/**", "/css/**", "/fonts/**", "/img/**", "/jquery/**", "/layui/**",
            "/script/**", "/ztree/**", "/admin/to/login/page.html" };
}
