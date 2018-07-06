package com.cloud.common.mq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
@Component
public class TestConsumer {

    @RabbitListener(queues = "test")
    public void processMessage(String content){
        System.out.println("receive message:"+ content);
    }
}
