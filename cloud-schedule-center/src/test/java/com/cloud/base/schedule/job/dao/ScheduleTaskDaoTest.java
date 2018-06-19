package com.cloud.base.schedule.job.dao;

import com.alibaba.fastjson.JSON;
import com.cloud.base.schedule.job.CloudScheduleCenterApplicationTests;
import com.cloud.base.schedule.job.enums.JobTypeEnum;
import com.cloud.base.schedule.job.model.ScheduleTask;
import com.cloud.common.enums.YesOrNoEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

/**
 * 定时任务查询单元测试
 *
 * @author Jon_China
 * @create 2018/2/28
 */
public class ScheduleTaskDaoTest extends CloudScheduleCenterApplicationTests {

    @Autowired
    private ScheduleTaskDao scheduleTaskDao;

    @Test
    public void testGetAllTasks(){
        ScheduleTask task = new ScheduleTask();
        task.setBeanClass("com.cloud.base.schedule.job.task.RemoteJob");
        task.setCronExpression("0/10 * * ? * * *");
        task.setDescription("本地任务调用测试");
        task.setIsConcurrent(YesOrNoEnum.NO.getCode());
        task.setJobGroup("remote");
        task.setJobName("remote-demo");
        task.setJobStatus(YesOrNoEnum.NO.getCode());
        task.setMethodName("execute");
        task.setRemoteUri("/local/1");
        task.setJobType(JobTypeEnum.REMOTE.getCode());
        Assert.assertTrue(this.scheduleTaskDao.save(task) == 1);
        Assert.assertNotNull(this.scheduleTaskDao.getAllTasks());
    }


    @Test
    public void testDeleteJobById(){
        Assert.assertTrue(this.scheduleTaskDao.deleteJobById(8L) == 1);
    }

    @Test
    public void testUpdateJob(){
        ScheduleTask task = this.scheduleTaskDao.getJobById(8L);
        Assert.assertNotNull(task);
        task.setRemoteUri("update");
        Assert.assertTrue(1 == this.scheduleTaskDao.updateJob(task));
    }
}
