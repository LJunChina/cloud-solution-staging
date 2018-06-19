package com.cloud.base.schedule.job.config;

import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;

import java.util.List;

/**
 * spring boot启动完成后加载定时任务‘
 *
 * @author Jon_China
 * @create 2018/2/28
 */
@Component
public class JobBootstrap implements InitializingBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobBootstrap.class);

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;


    @Override
    public void afterPropertiesSet() throws Exception {
        LOGGER.info("********* start schedule task **********");
        Scheduler scheduler = this.schedulerFactoryBean.getScheduler();
        scheduler.clear();
        TriggerKey triggerKey = TriggerKey.triggerKey("scan-job", "scan");
        CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
        if (null == trigger) {
            Class clazz = ClassUtils.forName("com.cloud.base.schedule.job.task.ScanJob",this.getClass().getClassLoader());
            JobDetail jobDetail = JobBuilder
                    .newJob(clazz)
                    .withIdentity("scan-job", "scan")
                    .build();
            // 表达式调度构建器
            CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule("0/30 * * ? * * *");
            // 按新的cronExpression表达式构建一个新的trigger
            trigger = TriggerBuilder
                    .newTrigger()
                    .withIdentity("scan-job","scan")
                    .withSchedule(scheduleBuilder).build();
            scheduler.scheduleJob(jobDetail, trigger);
        }
    }
}
