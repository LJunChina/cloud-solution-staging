package com.cloud.common.mq.producer;

import com.cloud.common.mq.consumer.RabbitMqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
@Component
public class MessageProducer {

    @Autowired
    private RabbitMqBean rabbitMqBean;

    public void senMsg(){
        this.rabbitMqBean.getAmqpTemplate().convertAndSend("nima");
    }
}
