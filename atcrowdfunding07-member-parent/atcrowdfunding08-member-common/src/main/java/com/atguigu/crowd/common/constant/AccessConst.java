package com.atguigu.crowd.common.constant;

import java.util.HashSet;
import java.util.Set;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月14日
 * @desc AccessConst
 */
public class AccessConst {
    public static final Set<String> PASS_RES_SET = new HashSet<>();

    static {
        PASS_RES_SET.add("/");
        PASS_RES_SET.add("/auth/member/reg/page");
        PASS_RES_SET.add("/auth/member/login/page");
        PASS_RES_SET.add("/auth/member/logout");
        PASS_RES_SET.add("/auth/member/do/login");
        PASS_RES_SET.add("/auth/do/member/register");
        PASS_RES_SET.add("/auth/member/send/sms");
    }

    public static final Set<String> STATIC_RES_SET = new HashSet<>();

    static {
        STATIC_RES_SET.add("bootstrap");
        STATIC_RES_SET.add("css");
        STATIC_RES_SET.add("fonts");
        STATIC_RES_SET.add("img");
        STATIC_RES_SET.add("jquery");
        STATIC_RES_SET.add("layer");
        STATIC_RES_SET.add("script");
        STATIC_RES_SET.add("ztree");
    }

    /**
     * 用于判断某个ServletPath 值是否对应一个静态资源
     *
     * @param servletPath 资源路径
     * @return true：是静态资源
     * false：不是静态资源
     */
    public static boolean judgeCurrentServletPathWetherStaticResource(String servletPath) {
        // 1.排除字符串无效的情况
        if (servletPath == null || servletPath.length() == 0) {
            throw new RuntimeException(AppConst.MESSAGE_STRING_INVALIDATE);
        }
        // 2.根据“/”拆分ServletPath 字符串
        String[] split = servletPath.split("/");
        // 3.考虑到第一个斜杠左边经过拆分后得到一个空字符串是数组的第一个元素，所以需
        // 要使用下标1 取第二个元素
        String firstLevelPath = split[1];
        // 4.判断是否在集合中
        return STATIC_RES_SET.contains(firstLevelPath);
    }
}
