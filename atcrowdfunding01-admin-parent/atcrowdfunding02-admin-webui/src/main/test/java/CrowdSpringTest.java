
import com.atguigu.crowd.entity.AdminEntity;
import com.atguigu.crowd.mapper.AdminMapper;
import com.atguigu.crowd.service.AdminService;
import com.atguigu.crowd.service.impl.AdminServiceImpl;
import jdk.jshell.spi.ExecutionControl;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年04月15日
 * @desc CrowdSpringTest
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-mybatis.xml","classpath:spring-tx.xml"})
public class CrowdSpringTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private AdminMapper mapper;

    @Autowired
    private AdminService service;

    @Test
    public void testDataSource() throws SQLException {
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    @Test
    public void testMapper(){
//        AdminEntity entity = new AdminEntity();
        /*entity.setId(1)
                .setLoginAcct("test_mapper")
                .setUserPswd("test_mapper")
                .setUserName("test_mapper")
                .setEmail("test_mapper");*/
//        mapper.insert(entity);
//         mapper.updateById(entity);
        System.out.println(mapper.selectById(1));
    }

    @Test
    public void testLog(){
        log.debug("debug message");
        log.info("info message");
        log.error("error message");
    }

    @Test
    public void testTx(){
        AdminEntity entity = new AdminEntity()
                .setLoginAcct("test_mapper")
                .setUserPswd("test_mapper")
                .setUserName("test_mapper")
                .setEmail("test_mapper");
        service.saveOne(entity);

    }
}
