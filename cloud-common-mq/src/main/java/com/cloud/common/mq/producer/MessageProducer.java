package com.cloud.common.mq.producer;

import com.cloud.common.mq.consumer.RabbitMqBean;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
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
        Message message = MessageBuilder.withBody("nima".getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_TEXT_PLAIN)
                .setMessageId("test")
                .setHeader("x-delay","10000")
                .build();
        this.rabbitMqBean.getAmqpTemplate().convertAndSend(message);
    }
}
