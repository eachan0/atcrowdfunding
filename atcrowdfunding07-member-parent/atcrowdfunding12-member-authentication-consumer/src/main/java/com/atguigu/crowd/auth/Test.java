package com.atguigu.crowd.auth;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc Test
 */
public class Test {
    public static void main(String[] args) {
//        int code = (int) (Math.random()*(9999-1000)+1000);
        double random = Math.random();
        System.out.println(random);
        String substring = String.valueOf(Math.random()).substring(2, 8);
        System.out.println(substring);
    }
}
