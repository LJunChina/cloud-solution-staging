package com.cloud.job.china.consumer;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
@Component
@RabbitListener(containerFactory="rabbitListenerContainerFactory",
        bindings = @QueueBinding(value = @Queue(value = "my-queue",durable = "true"),exchange = @Exchange(value = "my-exchange",delayed = "true")))
public class TestConsumer {

    @RabbitHandler
    public void processMessage(@Payload byte[] content){
        System.out.println("receive message:"+ new String(content));
    }
}
