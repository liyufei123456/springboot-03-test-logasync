package com.kgc.sbt.springboot03testlogasync;

//import org.apache.log4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;




@SpringBootTest
@RunWith(SpringRunner.class)
public class Springboot03TestLogasyncApplicationTests {

//    方式一：手动创建日志对象
    private Logger logger =  LoggerFactory.getLogger(getClass());
    @Test
  public void testSpringBootLogger() {

        //规范:除了临时调试，不用sout，统一使用日志调试



        logger.trace("-----trace级别日志，级别最低，开发中几乎不用，了解-----");
        logger.debug("-----{}级别日志，默认线上不开(内容更详细，日志量较大)，用于线上问题定位,{}-----","debug","掌握");
        logger.info("-----{}级别日志，SpringBoot的默认日志级别,{}","info","掌握");
        logger.warn("-----{}级别日志，业务警告日志级别，警告不一定是错误（主要记录异常流程）,{}","warn","掌握");
        logger.error("-----{}级别日志，最高级别，异常或者错误日志级别，实际开发过程中出现异常或者错误，都必须使用此级别,{}","error","掌握");

    }

}
