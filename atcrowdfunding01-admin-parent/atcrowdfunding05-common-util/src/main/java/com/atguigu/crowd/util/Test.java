package com.atguigu.crowd.util;

import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月22日
 * @desc Test
 */
public class Test {
    public static void main(String[] args) {
        String s = "null";
        System.out.println(DigestUtils.md5DigestAsHex(s.getBytes(StandardCharsets.UTF_8)));
    }
}
