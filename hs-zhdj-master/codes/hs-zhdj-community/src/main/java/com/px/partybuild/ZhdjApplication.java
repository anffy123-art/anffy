package com.px.partybuild;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.px.partybuild.mapper")
@EnableAsync
@EnableScheduling
public class ZhdjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZhdjApplication.class, args);
    }

}
