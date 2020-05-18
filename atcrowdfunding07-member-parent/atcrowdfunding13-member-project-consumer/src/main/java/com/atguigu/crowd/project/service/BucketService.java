package com.atguigu.crowd.project.service;

import java.io.File;
import java.io.InputStream;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc BucketService
 */
public interface BucketService {

    /**
     * 上传文件
     *
     * @param file 文件
     * @return 文件名
     */
    String upload(File file);

    /**
     * 上传文件
     *
     * @param name 原始文件名
     * @param in 流
     * @return 服务器文件名
     */
    String upload(String name, InputStream in);

    /**
     * 删除文件
     *
     * @param name 文件名或者文件夹名称
     */
    void remove(String name);
}
