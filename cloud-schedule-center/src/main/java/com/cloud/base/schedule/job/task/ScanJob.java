package com.cloud.base.schedule.job.task;

import com.cloud.base.schedule.job.dao.ScheduleTaskDao;
import com.cloud.base.schedule.job.enums.JobTypeEnum;
import com.cloud.base.schedule.job.model.ScheduleTask;
import com.cloud.base.schedule.job.util.SpringContextUtil;
import org.quartz.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 定时扫描数据库任务变更
 *
 * @author Jon_China
 * @create 2018/3/1
 */
@Component
public class ScanJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScanJob.class);
    @Autowired
    private ScheduleTaskDao scheduleTaskDao;
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            LOGGER.info("********* start scan database **********");
            List<ScheduleTask> scheduleTaskList = scheduleTaskDao.getAllTasks();
            if(null == scheduleTaskList){
                return;
            }
            //过滤远程任务
            scheduleTaskList = scheduleTaskList.stream()
                    .filter(s -> JobTypeEnum.REMOTE.getCode().equalsIgnoreCase(s.getJobType())).collect(Collectors.toList());
            if(null == scheduleTaskList){
                return;
            }
            for (ScheduleTask task : scheduleTaskList){
                addJob(context,task);
            }
            LOGGER.info("********* scan database finish **********");
        }catch (Exception e){
            LOGGER.error("exception occurred in add job",e);
            throw new JobExecutionException(e);
        }
    }

    public void addJob(JobExecutionContext context,ScheduleTask job) throws SchedulerException,ClassNotFoundException {
        try {
            Scheduler scheduler = context.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(job.getJobName(), job.getJobGroup());
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            // 不存在，创建一个
            if (null == trigger) {
                Class clazz = ClassUtils.forName(job.getBeanClass(), this.getClass().getClassLoader());
                JobDetail jobDetail = JobBuilder
                        .newJob(clazz)
                        .withIdentity(job.getJobName(), job.getJobGroup())
                        .build();
                jobDetail.getJobDataMap().put("jobBean", job);
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式构建一个新的trigger
                trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(job.getJobName(), job.getJobGroup())
                        .withSchedule(scheduleBuilder).build();
                scheduler.scheduleJob(jobDetail, trigger);
                LOGGER.info("********* add job success **********");
            } else {
                // Trigger已存在，那么更新相应的定时设置
                // 表达式调度构建器
                CronScheduleBuilder scheduleBuilder = CronScheduleBuilder.cronSchedule(job.getCronExpression());
                // 按新的cronExpression表达式重新构建trigger
                trigger = trigger.getTriggerBuilder().withIdentity(triggerKey).withSchedule(scheduleBuilder).build();
                // 按新的trigger重新设置job执行
                scheduler.rescheduleJob(triggerKey, trigger);
                LOGGER.info("********* update job success **********");
            }
        } catch (SchedulerException e) {
            LOGGER.error("exception occurred in add job:", e);
            throw e;
        }
    }
}
