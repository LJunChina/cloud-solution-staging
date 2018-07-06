package com.cloud.common.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
@Component
public class TestConsumer {

    @RabbitListener(queues = "test",containerFactory="rabbitListenerContainerFactory")
    @RabbitHandler
    public void processMessage(@Payload byte[] content){
        System.out.println("receive message:"+ new String(content));
    }
}
