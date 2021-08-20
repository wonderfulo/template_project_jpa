package com.cxy;

import com.cxy.entity.TmNation;
import com.cxy.service.ITmNationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 陈翔宇
 * @version 1.0.0
 * @ClassName simpleTest.java
 * @Description
 * @createTime 2021年08月20日 12:33:00
 */
//该注解会启动springboot项目
@RunWith(SpringRunner.class)
//只有该注解 不会启动springboot项目
@SpringBootTest
public class simpleTest {

    @Autowired
    private ITmNationService tmNationService;

    @Test
    public void test(){

        ArrayList<Long> nationIds = new ArrayList<>();
        nationIds.add(1L);
        nationIds.add(2L);
        nationIds.add(3L);
        List<TmNation> byNationIdIn = tmNationService.findByNationIdIn(nationIds);
        System.out.println(byNationIdIn);
    }
}
