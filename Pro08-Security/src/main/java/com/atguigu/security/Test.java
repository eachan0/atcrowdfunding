package com.atguigu.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月09日
 * @desc Test
 */
public class Test {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encode = encoder.encode("123123");
        System.out.println(encode);
    }
}
