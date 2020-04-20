package com.atguigu.crowd.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc CrowdUtil
 */
public class CrowdUtil {
    public static boolean judgeAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader("Accept");
        String xRequestWith = request.getHeader("X-Requested-With");
        return "XMLHttpRequest".equals(xRequestWith) || (accept != null && accept.contains("application/json"));
    }
}
