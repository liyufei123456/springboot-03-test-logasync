package com.kgc.sbt.log.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class LoggerController {


    @GetMapping("/testSlf4jLogger")
    public String testSpringBootLogger(){
        //使用info级别日志记录日志，其他级别一致
        log.info("-----借助lombok提供的记录日志注解@Slf4j，记录info-----");
        return "记录日志成功";
    }
}
