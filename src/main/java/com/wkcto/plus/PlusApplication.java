package com.wkcto.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @MapperScan:扫描器，指定Mapper类所在的包 
 
 */
@SpringBootApplication
@MapperScan(value = "com.wkcto.plus.mapper")
//@MapperScan(value = "com.wkcto.order")
public class PlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlusApplication.class, args);
    }
}
