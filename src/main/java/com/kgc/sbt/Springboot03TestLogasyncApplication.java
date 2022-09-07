package com.kgc.sbt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableAsync        //开启异步处理
@EnableScheduling
public class Springboot03TestLogasyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot03TestLogasyncApplication.class, args);
    }

}
