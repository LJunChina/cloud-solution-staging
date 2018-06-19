package com.cloud.base.schedule.job.config;

import com.cloud.base.schedule.job.exception.QuartzTaskException;
import com.cloud.base.schedule.job.util.SpringContextUtil;
import com.cloud.common.util.EmptyChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.net.URL;

/**
 * bean加载
 *
 * @author Jon_China
 * @create 2018/2/28
 */
@Configuration
public class BeanLoader {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private LoadBeanJobFactory loadBeanJobFactory;

    @Autowired
    private PlatformTransactionManager transactionManager;

    @Bean
    public SchedulerFactoryBean createSchedule(){
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        //用于quartz集群,QuartzScheduler 启动时更新己存在的Job，这样就不用每次修改targetObject后删除qrtz_job_details表对应记录了
        factory.setOverwriteExistingJobs(true);
        //用于quartz集群,加载quartz数据源
        factory.setDataSource(dataSource);
        //QuartzScheduler 延时启动，应用启动完10秒后 QuartzScheduler 再启动
        factory.setStartupDelay(5);
        //用于quartz集群,加载quartz数据源配置
        factory.setAutoStartup(true);
        factory.setApplicationContextSchedulerContextKey("applicationContext");
        factory.setApplicationContext(SpringContextUtil.getApplicationContext());
        //注册触发器
        URL url = this.getClass().getClassLoader().getResource("quartz.properties");
        if(EmptyChecker.isEmpty(url)){
            throw new QuartzTaskException("quartz properties file not found");
        }
        factory.setConfigLocation(new FileSystemResource(url.getPath()));
        factory.setJobFactory(loadBeanJobFactory);
        factory.setTransactionManager(transactionManager);
        return factory;
    }
}
