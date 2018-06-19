package com.cloud.base.schedule.job.service;

import com.cloud.base.schedule.job.web.dto.ScheduleTaskRequest;
import com.cloud.common.dto.BaseRespDTO;

import java.util.Map;

/**
 * @author Jon_China
 * @create 2018/3/1
 */
public interface ScheduleTaskService {

    BaseRespDTO getUserInfo(String id);


    /**
     * 远程调用任务
     * @param uri
     * @param params
     * @param method
     * @return
     */
    String scheduleRemoteJob(String uri, String method,Map<String,Object> params);

    /**
     * 新增任务
     * @param request
     * @return
     */
    BaseRespDTO addScheduleTask(ScheduleTaskRequest request);

    /**
     * 定时任务分页查询
     * @param request
     * @return
     */
    BaseRespDTO getAllJobsByPage(ScheduleTaskRequest request);

    /**
     * 删除定时任务
     * @param id
     * @return
     */
    BaseRespDTO deleteJob(long id);

    /**
     * 更新定时任务
     * @param request
     * @return
     */
    BaseRespDTO updateJob(ScheduleTaskRequest request);

    /**
     * 根据id查询定时任务详情
     * @param id
     * @return
     */
    BaseRespDTO getJobById(long id);

}
