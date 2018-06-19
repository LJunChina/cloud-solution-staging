package com.cloud.base.schedule.job.task;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 本地任务调用
 *
 * @author Jon_China
 * @create 2018/3/4
 */
public class LocalJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocalJob.class);

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        LOGGER.info("--------------本地任务开始执行--------------");
    }
}
