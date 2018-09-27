package com.cloud.job.china.producer;

import com.cloud.job.china.CloudCommonMQApplicationTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jon_China
 * @create 2018/7/6
 */
public class MessageProducerTest extends CloudCommonMQApplicationTest {
    @Autowired
    private MessageProducer messageProducer;

    @Test
    public void testMsgSend() throws Exception{
        messageProducer.senMsg();
    }
}
