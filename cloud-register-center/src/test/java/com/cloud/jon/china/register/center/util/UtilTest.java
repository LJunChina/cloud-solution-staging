package com.cloud.jon.china.register.center.util;

import com.cloud.common.util.EmptyChecker;
import org.junit.Assert;
import org.junit.Test;

/**
 * 工具类单元测试
 *
 * @author Jon_China
 * @create 2018/6/18
 */
public class UtilTest {

    @Test
    public void testEmptyChecker(){
        Assert.assertTrue(EmptyChecker.isEmpty(" "));
    }
}
