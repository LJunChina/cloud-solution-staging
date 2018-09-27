package com.cloud.job.china;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * test
 *
 * @author Jon_China
 * @create 2018/7/5
 */
public class MqTest {

    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("115.159.152.121");
        factory.setUsername("superman");
        factory.setPassword("CloudBase123!@#");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        Map<String, Object> params = new HashMap<>();
        params.put("x-delayed-type", "durable");
        channel.exchangeDeclare("my-exchange", "x-delayed-message", false, false, params);


        byte[] messageBodyBytes = "delayed payload123".getBytes(StandardCharsets.UTF_8);
        Map<String, Object> headers = new HashMap<>();
        headers.put("x-delay", 10000);
        AMQP.BasicProperties.Builder props = new AMQP.BasicProperties.Builder().headers(headers);
        channel.basicPublish("my-exchange", "", props.build(), messageBodyBytes);
        channel.close();
        connection.close();
    }
}
