package com.kgc.sbt.async.service.impl;

import com.kgc.sbt.async.service.ChargeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
public class ChargeServiceImpl implements ChargeService {
    @Override
    @Async
    public void executeAsyncCharge(String chargeTel, double chargeMoney) {
        log.info("***异步充值处理开始，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);
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
        log.info("***异步充值处理结束，充值手机号：{}，充值金额：{}",chargeTel,chargeMoney);
    }
}
