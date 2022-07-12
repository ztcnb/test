package com.ztc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@MapperScan("com.ztc.mapper")
public class CrmXmApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrmXmApplication.class, args);
    }

}
