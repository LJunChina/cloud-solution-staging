package com.cloud.base.schedule.job.model;

import java.io.Serializable;

public class ScheduleTask implements Serializable {

    private static final long serialVersionUID = 6361009734934504457L;
    /**
     * 自增ID
     * schedule_task.id
     */
    private Long id;

    /**
     * 任务名称
     * schedule_task.job_name
     */
    private String jobName;

    /**
     * 任务组
     * schedule_task.job_group
     */
    private String jobGroup;

    /**
     * 任务状态 0-未执行 1-已执行
     * schedule_task.job_status
     */
    private String jobStatus;

    /**
     * cron执行表达式
     * schedule_task.cron_expression
     */
    private String cronExpression;

    /**
     * 任务描述信息
     * schedule_task.description
     */
    private String description;

    /**
     * 任务class全路径
     * schedule_task.bean_class
     */
    private String beanClass;

    /**
     * 任务是否有状态 0-无 1-有
     * schedule_task.is_concurrent
     */
    private String isConcurrent;

    /**
     * 任务执行的方法名称
     * schedule_task.method_name
     */
    private String methodName;

    /**
     * 远程调用URI地址
     * schedule_task.remote_uri
     */
    private String remoteUri;

    private String jobType;

    private String jobParams;

    private String httpMethod;

    public String getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(String httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobParams() {
        return jobParams;
    }

    public void setJobParams(String jobParams) {
        this.jobParams = jobParams;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroup() {
        return jobGroup;
    }

    public void setJobGroup(String jobGroup) {
        this.jobGroup = jobGroup;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getCronExpression() {
        return cronExpression;
    }

    public void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(String beanClass) {
        this.beanClass = beanClass;
    }

    public String getIsConcurrent() {
        return isConcurrent;
    }

    public void setIsConcurrent(String isConcurrent) {
        this.isConcurrent = isConcurrent;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getRemoteUri() {
        return remoteUri;
    }

    public void setRemoteUri(String remoteUri) {
        this.remoteUri = remoteUri;
    }
}
