package com.smile.dao;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * 代码
 *
 * @Description
 * @ClassName MyGenerator
 * @Author smile
 * @date 2022.06.27 16:41
 */
public class MyGenerator {

    public static void main(String[] args) {
        // 创建 generator 对象（生成的对象）
        AutoGenerator autoGenerator = new AutoGenerator();

        // 数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setDbType(DbType.MYSQL);
        dataSourceConfig.setTypeConvert(new MySqlTypeConvert());
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/mall?useUnicode=true&characterEncoding=UTF-8&useSSL=false");
        dataSourceConfig.setUsername("admin");
        dataSourceConfig.setPassword("admin");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        autoGenerator.setDataSource(dataSourceConfig);

        // 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String property = System.getProperty("user.dir");
        globalConfig.setOutputDir(System.getProperty("user.dir") + "/mall-dao/src/main/java");   // 设置生成的目录
        globalConfig.setOpen(false);  // 生成成功后不会自动打开这个文件夹
        globalConfig.setAuthor("smile");  // 生成的作者
        globalConfig.setServiceName("%sService");  // Service接口去掉前面的I
        autoGenerator.setGlobalConfig(globalConfig);

        // 包信息
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.smile");  // 设置父包
        packageConfig.setModuleName("dao");
        packageConfig.setController("controller");
//        packageConfig.setService("service");
//        packageConfig.setServiceImpl("serviceImpl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("entity");
        autoGenerator.setPackageInfo(packageConfig);

        // 配置策略
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setTablePrefix("sys_");
        strategyConfig.setInclude("sys_role_menu");  // 要生成的表名
        strategyConfig.setEntityLombokModel(false);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);  // 数据库表映射到实体的命名策略，下划线转驼峰命名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);  // 数据库表字段映射到实体的命名策略，下划线转驼峰命名
        autoGenerator.setStrategy(strategyConfig);

        // 执行
        autoGenerator.execute();
    }
}
