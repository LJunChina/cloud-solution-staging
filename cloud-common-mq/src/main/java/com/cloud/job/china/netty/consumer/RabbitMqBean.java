package com.cloud.job.china.netty.consumer;

import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
@Component
public class RabbitMqBean {

    private final AmqpTemplate amqpTemplate;

    private final AmqpAdmin amqpAdmin;


    @Autowired
    public RabbitMqBean(AmqpAdmin amqpAdmin, AmqpTemplate amqpTemplate) {
        this.amqpAdmin = amqpAdmin;
        this.amqpTemplate = amqpTemplate;
    }

    public AmqpTemplate getAmqpTemplate() {
        return amqpTemplate;
    }

    public AmqpAdmin getAmqpAdmin() {
        return amqpAdmin;
    }
}
