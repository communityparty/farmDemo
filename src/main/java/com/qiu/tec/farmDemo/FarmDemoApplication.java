package com.qiu.tec.farmDemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan("com.qiu.tec.farmDemo.mapper")
public class FarmDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(FarmDemoApplication.class, args);
    }

}
