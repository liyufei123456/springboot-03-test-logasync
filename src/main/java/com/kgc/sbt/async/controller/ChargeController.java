package com.kgc.sbt.async.controller;

import com.kgc.sbt.async.service.ChargeService;
import com.kgc.sbt.async.service.impl.ChargeServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class ChargeController {

    //模拟同步充值
    @GetMapping("syncCharge")
    public String syncCharge(@RequestParam String chargeTel, @RequestParam Double chargeMoney){

        log.info("---开始充值，充值手机号：{}，充值金额：{}调用同步充值方法",chargeTel,chargeMoney);

        //获取当前时间的毫秒
//        long startTime =System.currentTimeMillis();

        //开始时间
        long startTime = Instant.now().toEpochMilli();

        //调用充值方法
        executeSyncCharge(chargeTel,chargeMoney);

        //结束时间
        long finishTime = Instant.now().toEpochMilli();
        log.info("---开始充值，充值手机号：{}，充值金额：{}，充值总耗时：{}",chargeTel,chargeMoney,finishTime-startTime);

        return String.format("---充值手机号：%s，充值金额：%s,充值成功!",chargeTel,chargeMoney);
    }


    //普通充值方法
    public void executeSyncCharge(String chargeTel,Double chargeMoney){

        log.info("***充值处理开始，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);

        //模拟充值耗时
        try {
            //以前写法
//            Thread.sleep(2000);
            //现在写法
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) {
//            e.printStackTrace();
            log.error("***异常处理信息{}",e.getMessage());
        }

        log.info("***充值处理结束，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);

    }







    @Autowired
    private ChargeService chargeService;

    //模拟异步充值
    @GetMapping("asyncCharge")
    public String asyncCharge(@RequestParam String chargeTel, @RequestParam Double chargeMoney){

        log.info("---开始充值，充值手机号：{}，充值金额：{}调用同步充值方法",chargeTel,chargeMoney);

        //获取当前时间的毫秒
//        long startTime =System.currentTimeMillis();

        //开始时间
        long startTime = Instant.now().toEpochMilli();

        //调用充值方法
//        executeAsyncCharge(chargeTel,chargeMoney);

        //调用异步充值处理方法业务接口
        chargeService.executeAsyncCharge(chargeTel,chargeMoney);


        //结束时间
        long finishTime = Instant.now().toEpochMilli();
        log.info("---开始充值，充值手机号：{}，充值金额：{}，充值总耗时：{}",chargeTel,chargeMoney,finishTime-startTime);

        return String.format("---充值手机号：%s，充值金额：%s,充值成功!",chargeTel,chargeMoney);
    }




//    @Async
//    public void executeAsyncCharge(String chargeTel,Double chargeMoney){
//
//        log.info("***异步充值处理开始，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);
//
//        //模拟充值耗时
//        try {
//            //以前写法
////            Thread.sleep(2000);
//            //现在写法
//            TimeUnit.MILLISECONDS.sleep(2000);
//        } catch (InterruptedException e) {
////            e.printStackTrace();
//            log.error("***异常处理信息{}",e.getMessage());
//        }
//
//        log.info("***异步充值处理结束，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);
//
//    }
}
