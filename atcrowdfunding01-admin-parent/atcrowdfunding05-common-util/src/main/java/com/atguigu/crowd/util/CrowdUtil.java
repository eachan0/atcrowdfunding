package com.atguigu.crowd.util;

import com.atguigu.crowd.util.constant.CrowConst;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.Assert;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月20日
 * @desc CrowdUtil
 */
public class CrowdUtil {
    /**
     * 判断是否为Ajax请求
     *
     * @param request req
     * @return yes → true
     */
    public static boolean judgeAjaxRequest(HttpServletRequest request) {
        String accept = request.getHeader(HttpHeaders.ACCEPT);
        String xRequestWith = request.getHeader(CrowConst.ATTR_AJAX_HEADER_NAME);
        return CrowConst.ATTR_AJAX_HEADER_VALUE.equals(xRequestWith) || (accept != null && accept.contains(MediaType.APPLICATION_JSON_VALUE));
    }

    /**
     * MD5加密字符串
     *
     * @param source 源
     * @return 加密后字符串
     */
    public static String md5Encoding(String source) {
        Assert.hasText(source, CrowConst.MSG_MD5_ENCODING);
        return DigestUtils.md5DigestAsHex(source.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * MD5加密字符串
     *
     * @param source 源
     * @param salt   加盐(私密)
     * @return 加密后字符串
     */
    public static String md5Encoding(String source, String salt) {
        Assert.hasText(salt + source + salt, CrowConst.MSG_MD5_ENCODING);
        return DigestUtils.md5DigestAsHex(source.getBytes(StandardCharsets.UTF_8));
    }

    public static void main(String[] args) {
        System.out.println(md5Encoding("123456"));
    }
}
