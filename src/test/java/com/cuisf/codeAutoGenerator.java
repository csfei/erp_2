package com.cuisf;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

/**
 * Created by Administrator on 2020-03-06.
 */
public class codeAutoGenerator {
    public static void main(String[] args) {
        //1创建代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //2全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");//获取当前项目的路径
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor("cuisf");
        gc.setOpen(false);//生成后是否打开资源管理器
        gc.setFileOverride(true);//重新生成文件后是否覆盖
        gc.setIdType(IdType.ID_WORKER_STR);//主键策略
        gc.setServiceName("%sService");//所有自动生成的service接口字母I去掉
        gc.setDateType(DateType.ONLY_DATE);//设置日期类型
         gc.setSwagger2(true); //实体属性 Swagger2 注解
        mpg.setGlobalConfig(gc);


        //3数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://127.0.0.1:3306/erp?useUnicode=true&characterEncoding=utf8&useSSL=true&serverTimezone=UTC");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        dsc.setDbType(DbType.MYSQL);

        mpg.setDataSource(dsc);

        // 4包配置
        PackageConfig pc = new PackageConfig();
       // pc.setModuleName("generator_01");
        pc.setParent("com.cuisf");
        pc.setController("controller");
       // pc.setEntity("entity");
        pc.setMapper("mapper");
        pc.setService("service");

        mpg.setPackageInfo(pc);

        //5策略
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel);//映射到实体类的策略  驼峰
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        //strategy.setEntityLombokModel(true);//自动添加lombok的注解
        //strategy.setRestControllerStyle(true);
        strategy.setInclude("\\w*");
        //自动填充 【日期【插入，修改】】
        //TableFill gmtCreate = new TableFill("useraddtime", FieldFill.INSERT);
        //TableFill gmtUpdate = new TableFill("usermodifytime", FieldFill.INSERT_UPDATE);

        //ArrayList<TableFill> tableFile = new ArrayList<>();
        //tableFile.add(gmtCreate);
        //tableFile.add(gmtUpdate);

        //strategy.setTableFillList(tableFile);
        //url驼峰命名  转化成_
        strategy.setControllerMappingHyphenStyle(true);
        mpg.setStrategy(strategy);

        //6.执行
        mpg.execute();
    }
}
