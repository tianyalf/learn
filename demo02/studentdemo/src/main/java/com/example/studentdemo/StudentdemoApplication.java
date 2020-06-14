package com.example.studentdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.studentdemo.datasource.dao")
public class StudentdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentdemoApplication.class, args);
    }

}
