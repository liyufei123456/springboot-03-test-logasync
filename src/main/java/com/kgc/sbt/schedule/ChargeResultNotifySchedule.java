package com.kgc.sbt.schedule;


import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

//模拟充值结果回调，定时任务
@Slf4j
@Component
public class ChargeResultNotifySchedule {

    //异步充值处理结果，需要定时回调,使用定时方式1：fixedDelay(单位是毫秒),实现每5秒执行一次定时任务
    @Scheduled(fixedDelay = 5 * 1000)
    public void chargeResultNotifyMethodOne(){

        //模拟定时任务，从数据库查询5笔充值成功订单，运行批量回调处理
        List<String> chargeOrders = Arrays.asList("111","222","333","444","555");

        //循环处理5笔订单，批量结果回调
        log.info("---开始执行批量回调处理,使用fixedDelay方式！");
        chargeOrders.forEach(chargeOrderNo ->{
            log.info("***充值订单号：{}充值成功结果回调",chargeOrderNo);
            //模拟回调耗时：100ms
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("---结束执行批量回调处理***");
    }





    //异步充值处理结果，需要定时回调,使用定时方式1：fixedDelay(单位是毫秒),实现每5秒执行一次定时任务
//    @Scheduled(fixedDelay = 5 * 1000)
    @Scheduled(fixedRate = 5 * 1000)
    public void chargeResultNotifyMethodTwo(){

        //模拟定时任务，从数据库查询5笔充值成功订单，运行批量回调处理
        List<String> chargeOrders = Arrays.asList("666","777","888","999","000");

        //循环处理5笔订单，批量结果回调
        log.info("---开始执行批量回调处理,使用fixedDelay方式！");
        chargeOrders.forEach(chargeOrderNo ->{
            log.info("***充值订单号：{}充值成功结果回调",chargeOrderNo);
            //模拟回调耗时：100ms
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("---结束执行批量回调处理***");
    }



    @Scheduled(cron = "*/5 * * * * ?")
    //cron表达式写法固定，需要请百度
    public void chargeResultNotifyMethodThree(){

        //模拟定时任务，从数据库查询5笔充值成功订单，运行批量回调处理
        List<String> chargeOrders = Arrays.asList("5555","6666","2222","1111","6666");

        //循环处理5笔订单，批量结果回调
        log.info("---开始执行批量回调处理,使用fixedDelay方式！");
        chargeOrders.forEach(chargeOrderNo ->{
            log.info("***充值订单号：{}充值成功结果回调",chargeOrderNo);
            //模拟回调耗时：100ms
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        log.info("---结束执行批量回调处理***");
    }

}
