package com.cloud.base.schedule.job;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@MapperScan(value = "com.cloud.base.schedule.job.dao")
@Transactional
@Rollback
@SpringBootTest
public class CloudScheduleCenterApplicationTests {

	@Test
	public void contextLoads() {
	}

}
