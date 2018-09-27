package com.cloud.job.china;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
public class SortBeanTest {


    public static void main(String[] args) {
        SortBean sortBean1 = new SortBean();
        sortBean1.setSort(3);
        sortBean1.setUserId(123L);
        SortBean sortBean2 = new SortBean();
        sortBean2.setSort(2);
        sortBean2.setUserId(123L);
        SortBean sortBean3 = new SortBean();
        sortBean3.setSort(1);
        sortBean3.setUserId(234L);
        SortBean sortBean4 = new SortBean();
        sortBean4.setSort(4);
        sortBean4.setUserId(234L);
        SortBean sortBean5 = new SortBean();
        sortBean5.setSort(5);
        sortBean5.setUserId(23423L);
        List<SortBean> beanList = Arrays.asList(sortBean1, sortBean2, sortBean3, sortBean4, sortBean5);
        List<SortBean> sortBeanList = new ArrayList<>(beanList);
        sortBeanList.sort(Comparator.comparing(SortBean::getSort));
        Map<Long, List<SortBean>> listMap = sortBeanList.stream().collect(Collectors.groupingBy(SortBean::getUserId));
        Set<Map.Entry<Long, List<SortBean>>> entrySet = listMap.entrySet();
        Map<Long,Integer> sortMap = new HashMap<>();
        int sort = 1;
        for (Map.Entry<Long, List<SortBean>> entry:entrySet){
            sortMap.put(entry.getKey(),sort++);
        }
        sortBeanList.forEach(s -> {
            if(sortMap.containsKey(s.getUserId())){
                s.setRealSort(sortMap.get(s.getUserId()));
            }
        });
        log.info("result:{}", JSON.toJSONString(sortBeanList));
    }
}
