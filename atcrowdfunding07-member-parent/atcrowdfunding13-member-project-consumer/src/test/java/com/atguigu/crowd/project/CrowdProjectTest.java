package com.atguigu.crowd.project;

import com.atguigu.crowd.project.service.BucketService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.File;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月15日
 * @desc CorwdProjectTest
 */
@SpringBootTest
public class CrowdProjectTest {

    @Resource
    private BucketService service;

    @Test
    public void testUpload(){
        File file = new File("C:\\Users\\zyc19\\Pictures\\Camera Roll\\cube_yukee_4.jpg");
        File file1 = new File("C:\\Users\\zyc19\\Pictures\\Camera Roll\\cube_yukee_2.jpg");
        String upload = service.upload(file);
        String upload1 = service.upload(file1);
        System.out.println(upload);
        System.out.println(upload1);
    }

    @Test
    public void testRemove(){
        String name = "2020-5-15/b535f60b-8f47-48aa-b106-5e7ce5962087.jpg";
        service.remove(name);
    }
}
