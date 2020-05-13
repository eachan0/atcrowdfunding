package com.atguigu.crowd.mysql;

import com.atguigu.crowd.entity.po.MemberEntity;
import com.atguigu.crowd.mysql.mapper.MemberMapper;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;


/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc CrowdMysqlMainTest
 */
@SpringBootTest
public class CrowdMysqlMainTest {

    @Resource
    private MemberMapper mapper;

    @Test
    void contextLoads() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String source = "123123";
        String encode = passwordEncoder.encode(source);
        MemberEntity member = new MemberEntity(null, "jack", encode, " 杰克",
                "jack@qq.com", 1, 1, "杰克", "123123", 2);
        mapper.insert(member);
    }
}
