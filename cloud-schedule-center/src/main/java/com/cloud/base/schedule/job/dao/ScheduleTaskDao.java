package com.cloud.base.schedule.job.dao;

import com.cloud.base.schedule.job.model.ScheduleTask;
import com.cloud.base.schedule.job.web.dto.ScheduleTaskRequest;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 定时任务数据访问
 *
 * @author Jon_China
 * @create 2018/2/28
 */
@Repository(value = "scheduleTaskDao")
public interface ScheduleTaskDao {

    List<ScheduleTask> getAllTasks();

    int save(ScheduleTask scheduleTask);

    /**
     * 定时任务分页查询
     * @param request
     * @return
     */
    List<ScheduleTask> getAllJobsByPage(ScheduleTaskRequest request);

    /**
     * 根据id删除定时任务
     * @param id
     * @return
     */
    int deleteJobById(@Param(value = "id") long id);

    /**
     * 根据id查询定时任务
     * @param id
     * @return
     */
    ScheduleTask getJobById(@Param(value = "id") long id);

    /**
     * 更新定时任务
     * @param scheduleTask
     * @return
     */
    int updateJob(ScheduleTask scheduleTask);
}
