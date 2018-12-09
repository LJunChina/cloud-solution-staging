package com.cloud.jon.china.user.microservice.config;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * 处理h2不支持；多句查询
 *
 */
@Intercepts({@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class})})
@Component
public class MybatisInterceptor implements Interceptor {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Object intercept(Invocation invocation){
        //获取参数
        Object[] args = invocation.getArgs();
        MappedStatement ms = (MappedStatement) args[0];
        Object parameter = args[1];
        BoundSql boundSql = ms.getBoundSql(null);
        String sql = boundSql.getSql();
        int effectRow = 0;
        if(sql.contains(";") && sql.split(";").length > 1){
            String[] strings = sql.split(";");
            for(String currentSql : strings){
                int update = jdbcTemplate.update(currentSql, parameter);
                effectRow += update;
            }
        }
        return effectRow;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }


}
