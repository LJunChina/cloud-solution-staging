package com.cloud.job.china.message.api;

/**
 * mq消息推送及数据库记录
 * @author Jon_China
 * @version 1.0
 * @since 2018年11月10日17:20:41
 */
public interface TransactionMessageApi {

    String saveMessageAndWattingConfirm();
}
