package com.cloud.common.mq;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * test
 *
 * @author Jon_China
 * @create 2018/7/5
 */
public class MqTest {

    public static void main(String[] args) {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory("115.159.152.121",15672);
        connectionFactory.setUsername("superman");
        connectionFactory.setPassword("CloudBase123!@#");
        org.springframework.amqp.rabbit.connection.Connection connection = connectionFactory.createConnection();
        Channel channel = connection.createChannel(false);
        AmqpAdmin admin = new RabbitAdmin(connectionFactory);
        admin.declareQueue(new Queue("testMq"));
        AmqpTemplate template = new RabbitTemplate(connectionFactory);
        template.convertAndSend("testMq","hello");
        String receive = (String) template.receiveAndConvert("testMq");
        System.out.println(receive);
    }
}
