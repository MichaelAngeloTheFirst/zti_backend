package com.zti;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication//(exclude={DataSourceAutoConfiguration.class})
//@ComponentScan({"com.zti.repository"})
public class ZtiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZtiApplication.class, args);
    }


}
