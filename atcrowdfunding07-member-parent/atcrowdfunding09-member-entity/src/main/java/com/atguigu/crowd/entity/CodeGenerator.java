package com.atguigu.crowd.entity;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;


/**
 * @author <a href="zyc199777@gmail.com">Zhu yc</a>
 * @version 1.0
 * @date 2020年05月13日
 * @desc CodeGenerator mybatis-plus 代码生成器
 */
public class CodeGenerator {

    public static void main(String[] args) {
        // 代码生成器
        AutoGenerator generator = new AutoGenerator();

        // 全局配置
        GlobalConfig config = new GlobalConfig();

        String path = System.getProperty("user.dir") + File.separator + "atcrowdfunding09-member-entity" + File.separator + "src" + File.separator + "main" + File.separator + "java";
        config.setOutputDir(path)
                .setFileOverride(false)
                .setOpen(false)
                .setEnableCache(false)
                .setAuthor("zhuyc")
                .setSwagger2(false)
                .setBaseResultMap(true)
                .setBaseColumnList(true)
                .setEntityName("%sEntity")
                .setMapperName("%sMapper")
                .setXmlName("%sMapper")
                .setServiceName("%sService")
                .setServiceImplName("%sServiceImpl")
                .setControllerName("%sController");

        // 数据源配置
        DataSourceConfig dataSource = new DataSourceConfig();
        dataSource.setDbType(DbType.MYSQL)
                .setUrl("jdbc:mysql://192.168.0.199:3306/project_crowd?useUnicode=true&characterEncoding=utf-8&allowMultiQueries=true&useSSL=false&serverTimezone=Asia/Shanghai")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setUsername("root")
                .setPassword("root");

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel)
                .setColumnNaming(NamingStrategy.underline_to_camel)
                .setTablePrefix("t_")
                .setEntityBuilderModel(true)
                .setEntityLombokModel(true)
                .setEntityBooleanColumnRemoveIsPrefix(true)
                .setRestControllerStyle(true)
                .setEntityTableFieldAnnotationEnable(true)
                .setInclude("t_order_project",
                        "t_address","t_order");

        PackageConfig pc = new PackageConfig();
        pc.setParent("com.atguigu.crowd.entity")
                .setEntity("po")
                .setService("service")
                .setServiceImpl("service.impl")
                .setMapper("mapper")
                .setXml("xml")
                .setController("controller");

        generator.setGlobalConfig(config)
                .setDataSource(dataSource)
                .setStrategy(strategy)
                .setPackageInfo(pc);

        generator.execute();
    }
}
