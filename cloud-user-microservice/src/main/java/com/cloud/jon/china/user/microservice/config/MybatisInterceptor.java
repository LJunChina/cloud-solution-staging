package com.cloud.jon.china.user.microservice.config;

import org.apache.ibatis.cache.CacheKey;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Stream;

/**
 * 处理h2不支持；多句查询
 *
 */
@Intercepts({
        @Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class}),
        @Signature(type = Executor.class, method = "query", args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class, CacheKey.class, BoundSql.class})
})
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
        if(sql.toUpperCase().contains("INTERVAL")){
            String[] s = sql.trim().split(" ");
            Object[] params = new Object[4];
//            List<String> sqls = new LinkedList<>(Arrays.asList(s));
            for (int i = 0;i < s.length;i++){
                if(s[i].toUpperCase().equals("INTERVAL")){
                    //参数1
                    params[0] = s[i + 1];
                    //参数2
                    params[1] = s[i + 2];
                    //操作符
                    params[3] = s[i - 1];
                }
            }
            //构造h2日期函数
            if(params[3].equals("-")){
                params[0] = -Integer.valueOf(params[0].toString());
            }else {
                params[0] = Integer.valueOf(params[0].toString());
            }
            String h2DateFunction = String.format("DATEADD('%s', %d, '%s')",params[1],params[0],params[2]);
            //重组sql
            String resultSql = "";

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
