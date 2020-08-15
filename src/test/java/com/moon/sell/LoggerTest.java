package com.moon.sell;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;



@Slf4j
@SpringBootTest
public class LoggerTest {

        // 使用 @Slf4j 注解  代理这行代码
//    private final Logger log = LoggerFactory.getLogger(LoggerTest.class);


    @Test
    public void test01(){
        String name = "test name";
        log.trace("trace....");
        log.debug("debug...");
        log.info("info....");
        log.warn("warning....");
        log.error("error");
        log.info("name:{}",name);
    }

}
