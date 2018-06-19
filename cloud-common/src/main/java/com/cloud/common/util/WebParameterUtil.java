package com.cloud.common.util;

import org.apache.commons.codec.binary.StringUtils;

import java.util.Map;
import java.util.Set;

/**
 * 参数map转rest风格
 *
 * @author Jon_China
 * @create 2018/3/4
 */
public final class WebParameterUtil {

    private WebParameterUtil(){}

    /**
     * map类型参数转化为rest风格
     * @param uri
     * @return
     */
    public static String generatorRestStyle(String uri, Map<String,String> params){
        if(EmptyChecker.isEmpty(params)){
            return uri;
        }
        StringBuilder builder = new StringBuilder(uri);
        builder.append("?");
        Set<Map.Entry<String,String>> entrySet = params.entrySet();
        entrySet.forEach(e -> {
            builder.append(e.getKey());
            builder.append("={");
            builder.append(e.getKey());
            builder.append("}&");
        });
        return builder.toString().substring(0,builder.length() - 1);
    }
}
