package com.atguigu.crowd.project.service.impl;

import cn.hutool.core.lang.UUID;
import com.aliyun.oss.OSS;
import com.atguigu.crowd.project.service.BucketService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc BucketServiceImpl
 */
@Service
public class BucketServiceImpl implements BucketService {

    @Value("${custom.oss.bucketName}")
    String bucketName;
    @Value("${custom.oss.urlPrefix}")
    String urlPrefix;
    @Value("${custom.oss.urlSuffix}")
    String urlSuffix;

    @Resource
    private OSS ossClient;

    @Override
    public String upload(File file) {
        Assert.notNull(file, "upload file can't be empty");
        String fullName = fileName(file.getName());
        ossClient.putObject(this.bucketName, fullName, file);
        return urlPrefix + bucketName + urlSuffix + "/" + fullName;
    }

    @Override
    public String upload(String name, InputStream in) {
        String fullName = fileName(name);
        ossClient.putObject(this.bucketName, fullName, in);
        return urlPrefix + bucketName + urlSuffix + "/" + fullName;
    }

    @Override
    public void remove(String name) {
        ossClient.deleteObject(this.bucketName, name);
    }

    protected String fileName(String name) {
        String suffix = "";
        int index = name.lastIndexOf(".");
        if (index > 0) {
            suffix = name.substring(index);
        }
        LocalDate now = LocalDate.now();
        String directory = now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth() + "/";
        String fileName = UUID.fastUUID().toString();
        return directory + fileName + suffix;
    }
}
