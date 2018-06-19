package com.cloud.base.schedule.job.task;

import com.alibaba.fastjson.JSON;
import com.cloud.base.schedule.job.model.ScheduleTask;
import com.cloud.base.schedule.job.service.ScheduleTaskService;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 远程调用定时任务
 *
 * @author Jon_China
 * @create 2018/2/28
 */
@Component
public class RemoteJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(RemoteJob.class);

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("------------remote service schedule job start------------");
        //获取job任务详情
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        ScheduleTask job = (ScheduleTask) dataMap.get("jobBean");
        this.scheduleTaskService.scheduleRemoteJob(job.getRemoteUri(),job.getHttpMethod(), JSON.parseObject(job.getJobParams()));
        LOGGER.info("------------remote service schedule job finished------------");
    }
}
