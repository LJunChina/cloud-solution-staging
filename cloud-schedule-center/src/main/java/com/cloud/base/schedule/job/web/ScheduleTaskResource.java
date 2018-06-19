package com.cloud.base.schedule.job.web;

import com.alibaba.fastjson.JSONObject;
import com.cloud.base.schedule.job.service.ScheduleTaskService;
import com.cloud.base.schedule.job.web.dto.ScheduleTaskRequest;
import com.cloud.common.dto.BaseRespDTO;
import com.cloud.common.enums.ResultCode;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 定时任务API
 *
 * @author Jon_China
 * @create 2018/3/4
 */
@RestController
@RequestMapping(value = "/schedule-task")
public class ScheduleTaskResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleTaskResource.class);

    @Autowired
    private ScheduleTaskService scheduleTaskService;

    /**
     * 新增job
     * @param body
     * @return
     */
    @PostMapping(value = "/add")
    public String addTask(@RequestBody String body){
        LOGGER.info("params of addTask:",body);
        try {
            ScheduleTaskRequest request = JSONObject.parseObject(body, ScheduleTaskRequest.class);
            BaseRespDTO baseRespDTO = this.scheduleTaskService.addScheduleTask(request);
            String result = baseRespDTO.toString();
            LOGGER.info("result of addTask:",result);
            return result;
        }catch (Exception e){
            LOGGER.error("exception occurred in addTask:",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 定时任务分页查询
     * @param pageIndex
     * @param pageSize
     * @param jobName
     * @param jobGroup
     * @param jobStatus
     * @return
     */
    @GetMapping(value = "/page")
    public String getAllJobsByPage(@RequestParam(value = "pageIndex",defaultValue = "1") Integer pageIndex,
                                   @RequestParam(value = "pageSize",defaultValue = "10") Integer pageSize,
                                   @RequestParam(value = "jobName",defaultValue = StringUtils.EMPTY) String jobName,
                                   @RequestParam(value = "jobGroup",defaultValue = StringUtils.EMPTY) String jobGroup,
                                   @RequestParam(value = "jobStatus",defaultValue = StringUtils.EMPTY) String jobStatus){
        LOGGER.info("params of getAllJobsByPage,pageIndex:{},pageSize:{},jobName:{},jobGroup:{},jobStatus:{}",pageIndex,pageSize,jobName,jobGroup,jobStatus);
        try {
            ScheduleTaskRequest request = new ScheduleTaskRequest();
            request.setPageIndex(pageIndex);
            request.setPageSize(pageSize);
            request.setJobName(jobName);
            request.setJobGroup(jobGroup);
            request.setJobStatus(jobStatus);
            BaseRespDTO baseRespDTO = this.scheduleTaskService.getAllJobsByPage(request);
            String result = baseRespDTO.toString();
            LOGGER.info("result of getAllJobsByPage:",result);
            return result;
        }catch (Exception e){
            LOGGER.error("exception occurred in getAllJobsByPage:",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 更新job
     * @param id
     * @param body
     * @return
     */
    @PostMapping(value = "/update/{id}")
    public String updateJobById(@PathVariable(value = "id") long id,@RequestBody String body){
        LOGGER.info("params of updateJobById,id:{},body:{}",id,body);
        try {
            ScheduleTaskRequest request = JSONObject.parseObject(body, ScheduleTaskRequest.class);
            request.setId(id);
            BaseRespDTO baseRespDTO = this.scheduleTaskService.updateJob(request);
            String result = baseRespDTO.toString();
            LOGGER.info("result of updateJobById:",result);
            return result;
        }catch (Exception e){
            LOGGER.error("exception occurred in updateJobById:",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 根据id删除定时任务
     * @param id
     * @return
     */
    @PostMapping(value = "/delete/{id}")
    public String deleteJobById(@PathVariable(value = "id") long id){
        LOGGER.info("params of deleteJobById:",id);
        try {
            BaseRespDTO baseRespDTO = this.scheduleTaskService.deleteJob(id);
            String result = baseRespDTO.toString();
            LOGGER.info("result of deleteJobById:",result);
            return result;
        }catch (Exception e){
            LOGGER.error("exception occurred in deleteJobById:",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }

    /**
     * 根据id查询定时任务详情
     * @param id
     * @return
     */
    @GetMapping(value = "/job/{id}")
    public String getJobById(@PathVariable(value = "id") long id){
        LOGGER.info("params of getJobById:",id);
        try {
            BaseRespDTO baseRespDTO = this.scheduleTaskService.getJobById(id);
            String result = baseRespDTO.toString();
            LOGGER.info("result of getJobById:",result);
            return result;
        }catch (Exception e){
            LOGGER.error("exception occurred in getJobById:",e);
            return new BaseRespDTO(ResultCode.ERROR).toString();
        }
    }
}
