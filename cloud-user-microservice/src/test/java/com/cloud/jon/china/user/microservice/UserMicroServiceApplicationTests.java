package com.cloud.jon.china.user.microservice;

import com.cloud.common.dto.BaseRespDTO;
import com.cloud.common.enums.ResultCode;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@MapperScan(value = "com.cloud.jon.china.user.microservice.dao")
//使用@Transactional @Rollback注解进行自动回滚
@Transactional
@Rollback
@ActiveProfiles(value = "dev")
@SpringBootTest
public class UserMicroServiceApplicationTests {

	@Test
	public void contextLoads() {
	}

    protected void assertResultCode(BaseRespDTO result){
        assertEquals(ResultCode.OK.getCode(), result.getCode());
    }

}
