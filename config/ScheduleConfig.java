package com.quartz.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * 定时任务配置
 * 
 *
 */
@Configuration
public class ScheduleConfig
{
    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource)
    {
        System.err.println("配置加载==============>>>>   123456");
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        factory.setDataSource(dataSource);

        // quartz参数
        Properties prop = new Properties();
        prop.put("org.quartz.scheduler.instanceName", "RuoyiScheduler");
        prop.put("org.quartz.scheduler.instanceId", "AUTO");
        // 线程池配置
        prop.put("org.quartz.threadPool.class", "org.quartz.simpl.SimpleThreadPool");
        prop.put("org.quartz.threadPool.threadCount", "20");
        prop.put("org.quartz.threadPool.threadPriority", "5");
        // JobStore配置
        prop.put("org.quartz.jobStore.class", "org.quartz.impl.jdbcjobstore.JobStoreTX");
        // 集群配置
        prop.put("org.quartz.jobStore.isClustered", "false");
//        prop.put("org.quartz.jobStore.clusterCheckinInterval", "15000");
//        prop.put("org.quartz.jobStore.maxMisfiresToHandleAtATime", "1");
        prop.put("org.quartz.jobStore.txIsolationLevelSerializable", "true");

        // sqlserver 启用
        // prop.put("org.quartz.jobStore.selectWithLockSQL", "SELECT * FROM {0}LOCKS UPDLOCK WHERE LOCK_NAME = ?");
        prop.put("org.quartz.jobStore.misfireThreshold", "12000");
        prop.put("org.quartz.jobStore.tablePrefix", "QRTZ_");
//#qzDS 数据源
//        org.quartz.dataSource.qzDS.driver = com.mysql.jdbc.Driver
//        org.quartz.dataSource.qzDS.URL = jdbc:mysql://localhost:3306/quartz?useUnicode=true&characterEncoding=UTF-8
//    org.quartz.dataSource.qzDS.user = root
//        org.quartz.dataSource.qzDS.password = root
//         = 10
//        #数据源命名
//        org.quartz.jobStore.dataSource = qzDS
//        prop.put("org.quartz.jobStore.dataSource", "qzDS");
//        prop.put("org.quartz.dataSource.qzDS.connectionProvider.class", "com.htkj.system.quartz.config.DruidConnectionProvider");
//        prop.put("org.quartz.dataSource.qzDS.driver", "com.mysql.jdbc.Driver");
//        prop.put("org.quartz.dataSource.qzDS.URL", "characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false");
//        prop.put("org.quartz.dataSource.qzDS.user", "");
//        prop.put("org.quartz.dataSource.qzDS.password", "!@");
//        prop.put("org.quartz.dataSource.qzDS.maxConnection", "10");

        factory.setQuartzProperties(prop);

        factory.setSchedulerName("RuoyiScheduler");
        // 延时启动
        factory.setStartupDelay(1);
        factory.setApplicationContextSchedulerContextKey("applicationContextKey");
        // 可选，QuartzScheduler
        // 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        // 设置自动启动，默认为true
        factory.setAutoStartup(true);
    System.err.println("定时器初始化配置=====================>>>>!");
        return factory;
    }
}
